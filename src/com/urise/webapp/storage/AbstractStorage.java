package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    @Override
    public void clear() {
    }

    @Override
    public void save(Resume resume) {
    }

    @Override
    public Resume get(String uuid) {
        return null;
    }

    @Override
    public void update(Resume resume) {
    }

    @Override
    public void delete(String uuid) {
    }

    @Override
    public Resume[] getAll() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

}
