package com.urise.webapp.storage;

import org.junit.Assert;
import org.junit.Test;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest {
    protected AbstractArrayStorageTest(final Storage storage) {
        super(storage);
    }

    @Test(expected = StorageException.class)
    public void saveOverflow() {
        try {
            for (int i = storage.size(); i < AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume("Ivan" + i));
            }
        } catch (final StorageException e) {
            Assert.fail();
        }
        storage.save(new Resume("Overflow!!!"));
    }
}
