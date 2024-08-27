package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private final int STORAGE_LIMIT = 10000;
    private final Resume[] storage = new Resume[STORAGE_LIMIT];
    private int size;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume r) {
        if (size < storage.length) {
            if (getIndex(r.getUuid()) >= 0) {
                storage[size++] = r;
            }
        }
    }

    public void update(Resume resume) {
        if (getIndex(resume.getUuid()) >= 0) {
            resume.setUuid("test update");
        } else System.out.println("ERROR " + resume.getUuid() + " not found");
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            return storage[index];
        } else System.out.println("ERROR " + uuid + " not found");
        return null;
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            size--;
            storage[index].setUuid(storage[size].getUuid());
            storage[size] = null;
        } else System.out.println("ERROR " + uuid + " not found");
    }


    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < size; i++)
            if (storage[i].getUuid().equals(uuid))
                return i;
        return -1;
    }
}