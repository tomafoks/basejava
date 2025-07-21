package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index != -1) {
            return storage[index];
        } else {
            System.out.println(uuid + " resume not in array 'storage'");
            return null;
        }
    }

    @Override
    public void doInsert(Resume resume) {
        storage[size] = resume;
    }

    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void doDeleted(int index) {
        storage[index] = storage[size() - 1];
        storage[size() - 1] = null;
    }
}