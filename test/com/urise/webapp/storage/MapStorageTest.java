package com.urise.webapp.storage;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MapStorageTest extends AbstractStorageTest {

    public MapStorageTest() {
        super(new MapStorage());
    }

    // @Override
    // @Test
    // public void testUpdate() {
    //     storage.update(storage.get("uuid1"));
    //     assertTrue("updated" == storage.get("uuid1").getUuid());
    // }
}
