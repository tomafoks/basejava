/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size = 0;

    void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                size++;
                break;
            }
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                break;
            }
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    public void update(){

    }

    void delete(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                break;
            }
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = storage[size - 1];
                storage[size - 1] = null;
            }
        }
        size--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resume = new Resume[size];
        for (int i = 0; i < size; i++) {
            resume[i] = storage[i];
        }
        return resume;
    }

    int size() {
        return size;
    }
}
