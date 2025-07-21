package com.urise.webapp.storage;

import java.util.Arrays;

import com.urise.webapp.model.Resume;

public abstract class AbstractArrayStorage implements Storage {

    final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    private int size = 0;

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public void delete(String uuid) {

    }

    @Override
    public Resume get(String uuid) {
        return null;
    }

    @Override
    public Resume[] getAll() {
        return null;
    }

    @Override
    public void save(Resume resume) {
        if (size() >= storage.length) {
            System.out.println("storage resumes is full!");
            return;
        }
        doInsert(resume);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void update(Resume resume) {
        // TODO Auto-generated method stub
    }

    protected abstract int getIndex(String uuid);

    protected abstract void doInsert(Resume resume);
}