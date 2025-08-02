package com.urise.webapp.storage;

import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    protected abstract void doInsert(Resume resume, Object searchKey);

    protected abstract boolean isExist(Object searchKey);

    protected abstract Object getSearchKey(String uuid);

    protected abstract void doUpdate(Resume resume, Object searchKey);

    protected abstract void doDeleted(String uuid, Object searchKey);

    protected abstract Resume doGet(Object searchKey);
  
    @Override
    public void save(Resume resume) {
        Object searchKey = getNotExistSearchKey(resume.getUuid());
        doInsert(resume, searchKey);
    }

    @Override
    public void update(Resume resume) {
        Object searchKey = getExistSearchKey(resume.getUuid());
        doUpdate(resume, searchKey);
    }

    @Override
    public void delete(String uuid) {
        Object searchKey = getExistSearchKey(uuid);
        doDeleted(uuid, searchKey);
    }

    @Override
    public Resume get(String uuid) {
       Object searchKey = getExistSearchKey(uuid);
       return doGet(searchKey);
    }

    private Object getExistSearchKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private Object getNotExistSearchKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }
}
