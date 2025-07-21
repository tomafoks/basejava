package com.urise.webapp.storage;

import java.util.Arrays;

import com.urise.webapp.model.Resume;

public abstract class AbstractArrayStorage implements Storage {

    final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public Resume get(String uuid) {
        return null;
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size());
    }

    public void save(Resume resume) {
        if (size >= storage.length) {
            System.out.println("storage resumes is full!");
            return;
        }
        if (getIndex(resume.getUuid()) == -1) {
            doInsert(resume);
            size++;
        } else {
            System.out.println(resume.getUuid() + " resume is available in the array 'storage'");
        }
    }

    public int size() {
        return size;
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index != -1) {
            storage[index].setUuid("updated test");
        } else {
            System.out.println(resume.getUuid() + " resume not in array 'storage'");
        }
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index != -1) {
            doDeleted(index);
            size--;
        } else {
            System.out.println(uuid + " resume not in array 'storage'");
        }
    }

    protected abstract int getIndex(String uuid);

    protected abstract void doInsert(Resume resume);

    protected abstract void doDeleted(int index);
}