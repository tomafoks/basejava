package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {

    private final Map<String, Resume> storage = new HashMap<>();

    @Override
    protected void removeResume(Object key, String uuid) {
        storage.remove((String) key);
    }

    @Override
    protected void saveResume(Resume r, Object key) {
        storage.put(key.toString(), r);
    }

    @Override
    protected void updateResume(Resume r, Object key) {
        storage.replace((String) key, r);
    }

    @Override
    protected Resume getResume(Object key) {
        return storage.get((String) key);
    }

    @Override
    protected Object getSearchArray(String uuid) {
        return uuid;
    }

    @Override
    protected boolean isExist(Object key) {
        return storage.containsKey((String) key);
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public Resume[] getAll() {
        return storage.values().toArray(new Resume[0]);
    }

    @Override
    public int size() {
        return storage.size();
    }
}
