package com.urise.webapp.storage;

import java.util.HashMap;
import java.util.Map;

import com.urise.webapp.model.Resume;

public class MapStorage extends AbstractStorage {
    Map<String, Resume> storageMap = new HashMap<>();

    @Override
    protected void doInsert(Resume resume, Object searchKey) {
        storageMap.put((String) searchKey, resume);
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return storageMap.containsKey(searchKey);
    }

    @Override
    protected Object getSearchKey(String uuid) {
        return (String) uuid;
    }

    @Override
    protected void doUpdate(Resume resume, Object searchKey) {
        storageMap.replace((String) searchKey, new Resume("test_update", "Ivan_update"));
    }

    @Override
    protected void doDeleted(String uuid, Object searchKey) {
        storageMap.remove(searchKey);
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return storageMap.get(searchKey);
    }

    @Override
    public void clear() {
        storageMap.clear();
    }

    @Override
    public Resume[] getAll() {
        return storageMap.values().toArray(new Resume[0]);
    }

    @Override
    public int size() {
        return storageMap.size();
    }
}
