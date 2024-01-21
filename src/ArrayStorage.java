/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < this.size(); i++) {
            storage[i] = null;
        }
    }

    void save(Resume r) {
        storage[this.size()] = r;
    }

    Resume get(String uuid) {
        for (int i = 0; i < this.size(); i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < this.size(); i++) {
            if (storage[i].uuid.equals(uuid)) {
                if (i+1 == this.size()) {
                    storage[i] = null;
                } else {
                    storage[i] = storage[i+1];
                }
                for (int j = i+1; j < this.size(); j++) {
                    if (j+1 != this.size()) {
                        storage[j] = storage[j+1];
                    } else {
                        storage[j] = null;
                    }
                }
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] r = new Resume[this.size()];
        for (int i = 0; i < this.size(); i++) {
            r[i] = storage[i];
        }
        return r;
    }

    int size() {
        int i = 0;
        while (storage[i] != null) {
            i++;
        }
        return i;
    }
}
