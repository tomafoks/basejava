package com.urise.webapp.exception;

public class NotExistStorageException extends StorageException {
    public NotExistStorageException(String uuid) {
        super(" resume not in array 'storage'", uuid);
        
    }
}
