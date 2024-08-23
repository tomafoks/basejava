/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) break;
            storage[i] = null;
        }
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                break;
            }
        }
    }

    Resume get(String uuid) {
        for (Resume resume : storage) {
            if (resume != null) {
                if (resume.uuid == uuid) {
                    return resume;
                }
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                break;
            }
            if (storage[i].uuid == uuid) {
                storage[i] = storage[this.size() - 1];
                storage[this.size() - 1] = null;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] getResume = new Resume[this.size()];
        for (int i = 0; i < this.size(); i++) {
            if (storage[i] != null) {
                getResume[i] = storage[i];
            }
        }
        return getResume;
    }

    int size() {
        int count = 0;
        for (Resume resume : storage) {
            if (resume == null) break;
            count++;
        }
        return count;
    }
}
