package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {

    Map<Integer, String> storageMap = new HashMap<Integer, String>();

    @Override
    protected void removeResume(Object key, String uuid) {

    }

    @Override
    protected void saveResume(Resume r, Object key) {
        storageMap.put((Integer) key, r.toString());
    }

    @Override
    protected void updateResume(Resume r, Object key) {

    }

    @Override
    protected Resume getResume(Object key) {
        return null;
    }

    @Override
    protected int keySearchArray(String uuid) {
        return 0;
    }

    @Override
    protected boolean isExist(Object key) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    public int size() {
        return 0;
    }
}
