package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    @Override
    protected Resume getResume(Object key) {
        return storage[(int) key];
    }

    @Override
    protected void updateResume(Resume r, Object key) {
        storage[(int) key] = r;
    }

    @Override
    protected void saveResume(Resume r, Object key) {
        if (size >= STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", r.getUuid());
        }
        insertResume(r, (Integer) key);
        size++;
    }

    @Override
    protected void removeResume(Object key, String uuid) {
        deleteResume((Integer) key);
        size--;
        storage[size] = null;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }


    @Override
    protected boolean isExist(Object key) {
        return (Integer) key >= 0;
    }

    protected abstract void insertResume(Resume r, int index);

    protected abstract void deleteResume(int index);
}