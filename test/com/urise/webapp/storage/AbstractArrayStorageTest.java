package com.urise.webapp.storage;

import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public abstract class AbstractArrayStorageTest {

    protected final Storage storage;

    AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";
    private static final Resume RESUME1 = new Resume(UUID_1);
    private static final Resume RESUME2 = new Resume(UUID_2);
    private static final Resume RESUME3 = new Resume(UUID_3);
    private static final Resume RESUME4 = new Resume(UUID_4);

    @Before
    public void setUp() {
        storage.clear();
        storage.save(RESUME1);
        storage.save(RESUME2);
        storage.save(RESUME3);
    }

    @Test
    public void get() {
        assertGet(RESUME1);
        assertGet(RESUME2);
        assertGet(RESUME3);
    }

    @Test
    public void update() {
        storage.update(RESUME1);
        Assert.assertSame(RESUME1, storage.get(RESUME1.getUuid()));
    }

    @Test()
    public void save() {
        storage.save(RESUME4);
        assertGet(RESUME4);
        assertSize(4);
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        storage.delete(RESUME3.getUuid());
        storage.get(RESUME3.getUuid());
    }

    @Test()
    public void clear() {
        storage.clear();
        assertSize(0);
    }

    @Test
    public void getAll() {
        Resume[] array = storage.getAll();
        Assert.assertEquals(3, array.length);
        Assert.assertEquals(RESUME1, array[0]);
        Assert.assertEquals(RESUME2, array[1]);
        Assert.assertEquals(RESUME3, array[2]);
    }

    @Test
    public void size() {
        assertSize(3);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }

    @Test(expected = StorageException.class)
    public void arrayOverflow() {
        try {
            for (int i = 0; i <= AbstractArrayStorage.STORAGE_LIMIT - 4; i++) {
                storage.save(new Resume());
            }
        } catch (StorageException e) {
            Assert.fail("overflow occurred ahead of time");
        }
    }

    private void assertGet(Resume resume) {
        Assert.assertEquals(resume, storage.get(resume.getUuid()));
    }

    private void assertSize(int size) {
        Assert.assertEquals(size, storage.size());
    }
}