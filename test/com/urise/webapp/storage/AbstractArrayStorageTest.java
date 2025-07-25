package com.urise.webapp.storage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public class AbstractArrayStorageTest {

    public AbstractArrayStorageTest() {
    }

    static final Storage storage = new ArrayStorage();

    private final static String UUID_1 = "uuid1";
    private final static String UUID_2 = "uuid2";
    private final static String UUID_3 = "uuid3";

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

    @Test (expected = NotExistStorageException.class)
    public void testDelete() {
        storage.delete("uuid1");
        Assert.assertEquals("uuid1", storage.get("uuid1").toString());
    }

    @Test
    public void testGet() {
        Assert.assertEquals(UUID_2, storage.get("uuid2").getUuid());
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
        Resume res = new Resume("test");
        storage.save(res);
        Assert.assertEquals(res, storage.get("test"));
    }

    @Test
    public void testSize() {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void testUpdate() {
        storage.update(storage.get("uuid1"));
        Assert.assertEquals("updated", storage.get("updated").toString());
    }
}
