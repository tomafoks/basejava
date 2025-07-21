package com.urise.webapp.storage;

import java.util.Arrays;

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

    public void update(Resume resume) {
    int index = getIndex(resume.getUuid());
        if (index != -1) {
            storage[index].setUuid("updated test");
        } else {
            System.out.println(resume.getUuid() + " resume not in array 'storage'");
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index != -1) {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println(uuid + " resume not in array 'storage'");
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size());
    }

    @Override
    public void doInsert(Resume resume) {
        if (getIndex(resume.getUuid()) == -1) {
            storage[size()] = resume;
        } else {
            System.out.println(resume.getUuid() + " resume is available in the array 'storage'");
        }
    }

    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < size(); i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}