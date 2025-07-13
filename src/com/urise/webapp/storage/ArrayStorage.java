package com.urise.webapp.storage;
import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    public void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                size++;
                break;
            }
        }
    }

    public Resume get(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                break;
            }
            if (storage[i].getUuid().equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    public void update() {

    }

    public void delete(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                break;
            }
            if (storage[i].getUuid().equals(uuid)) {
                storage[i] = storage[size - 1];
                storage[size - 1] = null;
            }
        }
        size--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Resume[] resume = new Resume[size];
        for (int i = 0; i < size; i++) {
            resume[i] = storage[i];
        }
        return resume;
    }

    public int size() {
        return size;
    }
}
