package com.urise.webapp.storage;

import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

public class MapStorageTest extends AbstractArrayStorageTest {

    public MapStorageTest() {
        super(new MapStorage());
    }

    @Override
    @Test
    public void testUpdate() {
        storage.update(storage.get(UUID_1));
        assertTrue("updated" == storage.get(UUID_1).getUuid());
    }

    @Override
    @Test
    @Ignore
    public void saveOverflow() {
    }
}
