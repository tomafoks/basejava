package com.urise.webapp.storage;

import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;

public abstract class AbstractArrayStorageTest {
    AbstractArrayStorageTest() {
        storage = new ArrayStorage();
    }

    private final Storage storage;

    private static final String uuid_1 = "uuid1";
    private static final String uuid_2 = "uuid2";
    private static final String uuid_3 = "uuid3";

    //@Before вызывается первым при каждом обращении к любому методу
    @Before
    public void setUp() {
        storage.clear();
        storage.save(new Resume(uuid_1));
        storage.save(new Resume(uuid_2));
        storage.save(new Resume(uuid_3));
    }

    @org.junit.Test
    public void get() {
    }

    @org.junit.Test
    public void update() {
    }

    @org.junit.Test
    public void save() {
    }

    @org.junit.Test
    public void delete() {
    }

    @org.junit.Test
    public void clear() {
    }

    @org.junit.Test
    public void getAll() {
    }

    @org.junit.Test
    public void size() {
        Assert.assertEquals(3, storage.size());
    }

    @org.junit.Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }
}