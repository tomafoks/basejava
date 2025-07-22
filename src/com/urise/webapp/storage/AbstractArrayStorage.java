package com.urise.webapp.storage;

import java.util.Arrays;

import com.urise.webapp.model.Resume;

public abstract class AbstractArrayStorage implements Storage {

    final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            return storage[index];
        } else {
            System.out.println(uuid + " resume not in array 'storage'");
            return null;
        }
    }

    public void save(Resume resume) {
        if (size >= storage.length) {
            System.out.println("storage resume is full!");
            return;
        }
        int index = getIndex(resume.getUuid());
        if (index < 0) {
            doInsert(resume, index);
            size++;
        } else {
            System.out.println(resume.getUuid() + " resume is available in the array 'storage'");
        }
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index >= 0) {
            storage[index].setUuid("updated test");
        } else {
            System.out.println(resume.getUuid() + " resume not in array 'storage' UPDATED");
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            doDeleted(index);
            storage[size() - 1] = null;
            size--;
        } else {
            System.out.println(uuid + " resume not in array 'storage'");
        }
    }

    public int size() {
        return size;
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size());
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    protected abstract int getIndex(String uuid);

    protected abstract void doInsert(Resume resume, int key);

    protected abstract void doDeleted(int index);
}