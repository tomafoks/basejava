package com.urise.webapp.storage;

import java.util.Arrays;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractArrayStorage extends AbstractStorage {

    final static int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            return storage[index];
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    public void save(Resume resume) {
        if (size >= storage.length) {
            throw new StorageException("array overflow!", resume.getUuid());
        }
        int index = getIndex(resume.getUuid());
        if (index <= 0) {
            doInsert(resume, index);
            size++;
        } else {
            throw new ExistStorageException(resume.getUuid());
        }
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index >= 0) {
            storage[index] = new Resume("updated");
        } else {
            throw new NotExistStorageException(resume.getUuid());
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            doDeleted(index);
            storage[size() - 1] = null;
            size--;
        } else {
            throw new NotExistStorageException(uuid);
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