package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume r) {
        if (size < storage.length) {
            if (foundResume(r.getUuid()) == null) {
                storage[size++] = r;
            }
        }
    }

    public void update(Resume resume) {
        if (foundResume(resume.getUuid()) != null) {
            resume.setUuid("test update");
        } else System.out.println("ERROR " + resume.getUuid() + " not found");
    }

    public Resume get(String uuid) {
        Resume r = foundResume(uuid);
        if (r != null) {
            return r;
        } else System.out.println("ERROR " + uuid + " not found");
        return null;
    }

    public void delete(String uuid) {
        Resume r = foundResume(uuid);
        if (r != null) {
            size--;
            r.setUuid(storage[size].getUuid());
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

    private Resume foundResume(String uuid) {
        for (int i = 0; i < size; i++)
            if (storage[i].getUuid().equals(uuid))
                return storage[i];
        return null;
    }
}