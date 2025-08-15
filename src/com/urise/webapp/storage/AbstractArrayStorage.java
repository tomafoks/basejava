package com.urise.webapp.storage;

import java.util.Arrays;
import java.util.List;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractArrayStorage extends AbstractStorage {

    final static int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    protected abstract void insertElement(Resume resume, int index);

    protected abstract void fillDeletedElement(int index);

    @Override
    protected Resume doGet(Object index) {
        return storage[(Integer) index];
    }

    @Override
    protected void doInsert(Resume resume, Object searchKey) {
        int index = (Integer) searchKey;
        if (size >= storage.length) {
            throw new StorageException("array overflow!", resume.getUuid());
        }
        insertElement(resume, index);
        size++;
    }

    @Override
    protected void doUpdate(Resume resume, Object searchKey) {
        storage[(Integer) searchKey] = resume;
    }

    @Override
    protected void doDeleted(String uuid, Object searchKey) {
        fillDeletedElement((Integer) searchKey);
        storage[size() - 1] = null;
        size--;
    }

    @Override
    protected boolean isExist(Object searchKey) {
        if ((Integer) searchKey >= 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size());
    }

    //make realization sort in storage
    @Override
    public List<Resume> getAllSorted() {
        return Arrays.asList(storage);
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }
}