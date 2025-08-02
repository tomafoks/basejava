package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public class MapStorage extends AbstractStorage {

    @Override
    protected void doInsert(Resume resume, Object searchKey) {
    }

    @Override
    protected boolean isExist(Object searchKey) {
    }

    @Override
    protected Object getSearchKey(String uuid) {
    }

    @Override
    protected void doUpdate(Resume resume, Object searchKey) {
    }

    @Override
    protected void doDeleted(String uuid, Object searchKey) {
    }

    @Override
    protected Resume doGet(Object searchKey) {
    }

    @Override
    public void clear() {
    }

    @Override
    public Resume[] getAll() {
    }

    @Override
    public int size() {
    }
}
