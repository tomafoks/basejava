package com.urise.webapp.storage;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ArrayStorageTest extends AbstractArrayStorageTest {
    public ArrayStorageTest() {
        super(new ArrayStorage());
    }

    @Override
    @Test
    public void testUpdate() {
        storage.update(storage.get(UUID_1));
        assertTrue("updated" == storage.get("updated").getUuid());
    }
}