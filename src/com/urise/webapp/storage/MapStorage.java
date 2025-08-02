package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public class MapStorage extends AbstractStorage{

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clear'");
    }

    @Override
    public Resume[] getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    @Override
    protected void doInsert(Resume resume, Object searchKey) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'doInsert'");
    }

    @Override
    protected boolean isExist(Object searchKey) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isExist'");
    }

    @Override
    protected Object getSearchKey(String uuid) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSearchKey'");
    }

    @Override
    protected void doUpdate(Resume resume, Object searchKey) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'doUpdate'");
    }

    @Override
    protected void doDeleted(String uuid, Object searchKey) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'doDeleted'");
    }

    @Override
    protected Resume doGet(Object searchKey) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'doGet'");
    }

}
