package com.urise.webapp.storage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractArrayStorageTest {
    protected Storage storage;
    public final static String UUID_1 = "uuid1";
    private final static String UUID_2 = "uuid2";
    private final static String UUID_3 = "uuid3";
    private final static String UUID_4 = "uuid4";

    protected AbstractArrayStorageTest(final Storage storage) {
        this.storage = storage;
    }

    @Test
    public abstract void testUpdate();

    @Before
    public void setUp() {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test(expected = StorageException.class)
    public abstract void saveOverflow();

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
        final Resume[] res = storage.getAll();
        Assert.assertEquals(3, res.length);
    }

    @Test
    public void testSave() {
        final Resume res = new Resume(UUID_4);
        storage.save(res);
        assertGet(res);
    }

    @Test
    public void testSize() {
        assertSize(3);
    }

    private void assertGet(final Resume r) {
        Assert.assertEquals(r, storage.get(r.getUuid()));
    }

    private void assertSize(final int size) {
        Assert.assertEquals(size, storage.size());
    }
}
