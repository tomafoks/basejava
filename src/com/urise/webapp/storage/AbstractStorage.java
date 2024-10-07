package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    public final Resume get(String uuid) {
        Object key = notExistResume(uuid);
        return getResume(key);
    }

    public final void update(Resume r) {
        Object key = notExistResume(r.getUuid());
        updateResume(r, key);
    }

    public final void save(Resume r) {
        Object key = existResume(r.getUuid());
        saveResume(r, key);
    }

    public final void delete(String uuid) {
        Object key = notExistResume(uuid);
        removeResume(key, uuid);
    }

    protected abstract void removeResume(Object key, String uuid);

    protected abstract void saveResume(Resume r, Object key);

    protected abstract void updateResume(Resume r, Object key);

    protected abstract Resume getResume(Object key);

    protected abstract int keySearchArray(String uuid);

    protected abstract boolean isExist(Object key);

    private Object existResume(String uuid) {
        Object key = keySearchArray(uuid);
        if (isExist(key)) {
            throw new ExistStorageException(uuid);
        }
        return key;
    }

    private Object notExistResume(String uuid) {
        Object key = keySearchArray(uuid);
        if (!isExist(key)) {
            throw new NotExistStorageException(uuid);
        }
        return key;
    }
}
