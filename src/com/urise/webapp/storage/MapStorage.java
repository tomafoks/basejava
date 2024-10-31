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
        storageMap.put(key.toString(), r);
//        System.out.println(storageMap.toString());

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
        if (!storageMap.isEmpty()) {
            for (Map.Entry entry : storageMap.entrySet()) {
                System.out.println("string: " + uuid + "; value: " + entry.getValue());
                System.out.println(uuid.equals(entry.getValue()));
                if (uuid.equals(entry.getValue())) {
                    return entry.getKey();// нашли наше значение и возвращаем  ключ
                }
            }
        }
        System.out.println("");
        return -1;
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
