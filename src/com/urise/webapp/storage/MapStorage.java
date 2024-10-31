package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {

    Map<String, Resume> storageMap = new HashMap<>();

    @Override
    protected void removeResume(Object key, String uuid) {
        storageMap.remove(key);
    }

    @Override
    protected void saveResume(Resume r, Object key) {
        System.out.println(storageMap.size());
        storageMap.put((String) key, r);
    }

    @Override
    protected void updateResume(Resume r, Object key) {
    }

    @Override
    protected Resume getResume(Object key) {
        return storageMap.get(key);
    }

    @Override
    protected Object keySearchArray(String uuid) {
//        for (Map.Entry entry : storageMap.entrySet()) {
//            if (uuid.equals(entry.getValue())) {
//                return (int) entry.getKey();// нашли наше значение и возвращаем  ключ
//            }
//        }
//        return -1;
        return uuid;
    }

    @Override
    protected boolean isExist(Object key) {
        return (Integer) key >= 0;
    }

    @Override
    public void clear() {
        storageMap.clear();
    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    public int size() {
        return storageMap.size();
    }
}
