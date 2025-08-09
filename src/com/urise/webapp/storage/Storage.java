package com.urise.webapp.storage;

import java.util.List;

import com.urise.webapp.model.Resume;

public interface Storage {
    public void clear();

    public void save(Resume resume);

    public Resume get(String uuid);

    public void update(Resume resume);

    public void delete(String uuid);

    // public Resume[] getAll();

    List<Resume> getAllSorted();

    public int size();
}
