package com.urise.webapp.storage;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ListStorageTest extends AbstractStorageTest {
    
    public ListStorageTest() {
        super(new ListStorage());
    }

    // @Override
    // @Test
    // public void testUpdate() {
    //     storage.update(storage.get("uuid1"));
    //     assertTrue("updated" == storage.get("updated").getUuid());
    // }
}