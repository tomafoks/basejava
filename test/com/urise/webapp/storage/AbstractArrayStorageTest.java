package com.urise.webapp.storage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.urise.webapp.model.Resume;

public class AbstractArrayStorageTest {
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

    }

    @Test
    public void testDelete() {

    }

    @Test
    public void testGet() {
        Assert.assertEquals(UUID_2, storage.get("uuid2").getUuid());
    }

    @Test
    public void testGetNotExist() {

    }

    @Test
    public void testGetAll() {

    }

    @Test
    public void testSave() {

    }

    @Test
    public void testSize() {

    }

    @Test
    public void testUpdate() {

    }
}
