package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    protected abstract boolean isExist(int searchKey);

    protected abstract int getSearchKey(String uuid);

    protected abstract void doUpdate(int searchKey, String uuid);

    protected abstract void doDeleted(int searchKey, String uuid);

    protected abstract void doSave(int searchKey, String uuid);

    @Override
    public void update(Resume resume) {
        int searchKey = getSearchKey(resume.getUuid());
        doUpdate(searchKey, resume.getUuid());
    }

    @Override
    public void delete(String uuid) {
        int searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        } else {
            doDeleted(searchKey, uuid);
        }
    }

    @Override
    public void save(Resume resume) {
        int searchKey = getSearchKey(resume.getUuid());
        if (!isExist(searchKey)) {
            throw new ExistStorageException(resume.getUuid());
        } else {
            doSave(searchKey, resume.getUuid());
        }
    }

    private Object getExistSearchKey() {
        int searchKey = getSearchKey(resume.getUuid());
     if (!isExist(searchKey)) {
            throw new NotExistStorageException(resume.getUuid());
        } else {
            return 
    }

}
