package com.urise.webapp.storage;

import java.util.Arrays;

import com.urise.webapp.model.Resume;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void insertElement(Resume resume, int index) {
        int key = (-index) - 1;
        storage[key] = resume;
    }

    @Override
    protected void fillDeletedElement(int index) {
        int number = size - index - 1;
        if (number > 0) {
            System.arraycopy(storage, index + 1, storage, index, number);
        }
    }

    @Override
    protected Object getSearchKey(String uuid) {
        Resume resume = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, resume);
    }
}
