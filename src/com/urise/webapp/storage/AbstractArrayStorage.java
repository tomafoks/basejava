package com.urise.webapp.storage;

import java.util.Arrays;

import com.urise.webapp.model.Resume;

public abstract class AbstractArrayStorage implements Storage {

    protected Resume[] storage = new Resume[10000];
    private int size = 0;

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public void delete(String uuid) {
        // TODO Auto-generated method stub

    }

    @Override
    public Resume get(String uuid) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Resume[] getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void save(Resume resume) {
               if (size() >= storage.length) {
            System.out.println("storage resumes is full!");
            return;
        }
        if (getIndex(resume.getUuid()) == -1) {
            storage[size()] = resume;
            size++;
        } else {
            System.out.println(resume.getUuid() + " resume is available in the array 'storage'");
        }
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void update(Resume resume) {
        // TODO Auto-generated method stub

    }

}
