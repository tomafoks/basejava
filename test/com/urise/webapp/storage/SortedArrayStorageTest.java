package com.urise.webapp.storage;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

public class SortedArrayStorageTest extends AbstractArrayStorageTest {

    public SortedArrayStorageTest() {
        super(new SortedArrayStorage());
    }

    // @Override
    // @Test
    // public void testUpdate() {
    //     storage.update(storage.get("uuid1"));
    //     assertTrue("updated" == storage.get("updated").getUuid());
    // }

    @Override
    @Test(expected = StorageException.class)
    public void saveOverflow() {
        try {
            for (int i = storage.size(); i < AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume());
            }
        } catch (final StorageException e) {
            Assert.fail();
        }
        storage.save(new Resume());
    }
}
