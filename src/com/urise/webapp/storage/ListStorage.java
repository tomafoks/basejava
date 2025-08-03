package com.urise.webapp.storage;

import java.util.ArrayList;
import java.util.List;

import com.urise.webapp.model.Resume;

public class ListStorage extends AbstractStorage {

    private List<Resume> listStorage = new ArrayList<>();

    @Override
    protected Resume doGet(Object searchKey) {
        return listStorage.get((Integer) searchKey);

    }

    @Override
    protected void doInsert(Resume resume, Object searchKey) {
        listStorage.add(resume);
    }

    @Override
    protected void doUpdate(Resume resume, Object searchKey) {
        listStorage.set((Integer) searchKey, new Resume("updated"));
    }

    @Override
    protected void doDeleted(String uuid, Object searchKey) {
        listStorage.remove((int) searchKey);
    }

    @Override
    public void clear() {
        listStorage.clear();
    }

    @Override
    public int size() {
        return listStorage.size();
    }

    @Override
    public Resume[] getAll() {
        return listStorage.toArray(new Resume[0]);
    }

    @Override
    protected boolean isExist(Object searchKey) {
        if ((Integer) searchKey >= 0) {
            return true;
        }
        return false;
    }

    @Override
    protected Object getSearchKey(String uuid) {
        for (int i = 0; i < listStorage.size(); i++) {
            if (uuid.equals(listStorage.get(i).getUuid())) {
                return i;
            }
        }
        return -1;
    }
}