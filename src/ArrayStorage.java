/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null)
                break;
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
        for (Resume resume : storage) {
            if (resume == null) {
                break;
            }
            if (resume.uuid == uuid) {
                resume = null;
            }
        }

        for (int i = 2; i < storage.length - 1; i++) {
            storage[i - 1] = storage[i];
            storage[i] = null;
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
        return 0;
    }
}
