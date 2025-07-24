package com.urise.webapp.exception;

public class ExistStorageException extends StorageException {
    public ExistStorageException(String uuid) {
        super("resume is available in the array 'storage'", uuid);
    }
}
