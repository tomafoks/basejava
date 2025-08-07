package com.urise.webapp.storage;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SortedArrayStorageTest extends AbstractArrayStorageTest {

    public SortedArrayStorageTest() {
        super(new SortedArrayStorage());
    }

    @Override
    @Test
    public void testUpdate() {
        storage.update(storage.get(UUID_1));
        assertTrue("updated" == storage.get("updated").getUuid());
    }
}
