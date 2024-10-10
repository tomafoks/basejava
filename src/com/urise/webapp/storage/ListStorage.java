package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;

public class ListStorage extends AbstractStorage {

    //    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    ArrayList<Resume> storageList = new ArrayList<Resume>();

    @Override
    protected void removeResume(Object key, String uuid) {
        storageList.remove((Integer) key);
    }

    @Override
    protected void saveResume(Resume r, Object key) {
        storageList.add(r);
    }

    @Override
    protected void updateResume(Resume r, Object key) {
        storageList.set((Integer) key, r);
    }

    @Override
    protected Resume getResume(Object key) {
        return storageList.get((Integer) key);
    }

    @Override
    public void clear() {
        storageList.clear();
    }

    @Override
    public Resume[] getAll() {
        return (Resume[]) storageList.toArray();
    }

    @Override
    public int size() {
        return storageList.size();
    }

    @Override
    protected int keySearchArray(String uuid) {
        for (int i = 0; i < storageList.size(); i++) {
            if (uuid.equals(storageList.get(i).getUuid())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected boolean isExist(Object key) {
        return (Integer) key >= 0;
    }
}
}
