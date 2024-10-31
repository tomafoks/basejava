package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {

    private List<Resume> storageList = new ArrayList<>();

    @Override
    protected void removeResume(Object key, String uuid) {
        storageList.remove(((Integer) key).intValue());
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
        return storageList.toArray(new Resume[storageList.size()]);
    }

    @Override
    public int size() {
        return storageList.size();
    }

    @Override
    protected Object keySearchArray(String uuid) {
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
