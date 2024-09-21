package com.urise.webapp.storage;

import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public abstract class AbstractArrayStorageTest {

    public Storage storage;

    AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    private static final String uuid_1 = "uuid1";
    private static final String uuid_2 = "uuid2";
    private static final String uuid_3 = "uuid3";
    private static final Resume resume_1 = new Resume(uuid_1);
    private static final Resume resume_2 = new Resume(uuid_2);
    private static final Resume resume_3 = new Resume(uuid_3);

    @Before
    public void setUp() {
        storage.clear();
        storage.save(resume_1);
        storage.save(resume_2);
        storage.save(resume_3);
    }

    @Test
    public void get() {
        Assert.assertEquals(resume_1, storage.get(resume_1.getUuid()));
        Assert.assertEquals(resume_2, storage.get(resume_2.getUuid()));
        Assert.assertEquals(resume_3, storage.get(resume_3.getUuid()));
    }

    @Test
    public void update() {
    }

    @Test
    public void save() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void clear() {
    }

    @Test
    public void getAll() {
    }

    @Test
    public void size() {
        Assert.assertEquals(3, storage.size());
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }
}