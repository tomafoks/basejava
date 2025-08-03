package com.urise.webapp.storage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractArrayStorageTest {
    protected Storage storage;
    private final static String UUID_1 = "uuid1";
    private final static String UUID_2 = "uuid2";
    private final static String UUID_3 = "uuid3";
    private final static String UUID_4 = "uuid4";

    protected AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    public void testClear() {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test(expected = NotExistStorageException.class)
    public void testDelete() {
        storage.delete(UUID_1);
        assertSize(2);
        storage.get(UUID_1);
    }

    @Test
    public void testGet() {
        assertGet(storage.get(UUID_1));
        assertGet(storage.get(UUID_2));
        assertGet(storage.get(UUID_3));
    }

    @Test(expected = NotExistStorageException.class)
    public void testGetNotExist() {
        storage.get("dummy");
    }

    @Test
    public void testGetAll() {
        Resume[] res = storage.getAll();
        Assert.assertEquals(3, res.length);
    }

    @Test
    public void testSave() {
        Resume res = new Resume(UUID_4);
        storage.save(res);
        assertGet(res);
    }

    @Test
    public void testSize() {
        assertSize(3);
    }

    @Test
    public void testUpdate() {
        storage.update(storage.get(UUID_1));
        assertGet(storage.get("updated"));
    }

    @Test(expected = StorageException.class)
    public void saveOverflow() {
        try {
            for (int i = storage.size(); i < AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume());
            }
        } catch (StorageException e) {
            Assert.fail();
        }
        storage.save(new Resume());
    }

    private void assertGet(Resume r) {
        Assert.assertEquals(r, storage.get(r.getUuid()));
    }

    private void assertSize(int size) {
        Assert.assertEquals(size, storage.size());
    }
}
