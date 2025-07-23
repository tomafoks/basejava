package com.urise.webapp.storage;

import java.util.Arrays;

import com.urise.webapp.model.Resume;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected int getIndex(String uuid) {
        Resume resume = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, resume);
    }

    @Override
    protected void doInsert(Resume resume, int key) {
        int index = (-key) - 1;
        storage[index] = resume;
    }

    @Override
    protected void doDeleted(int index) {

        int number = size - index - 1;
        if (number > 0) {
            System.arraycopy(storage, index + 1, storage, index, number);
        }
    }

}
