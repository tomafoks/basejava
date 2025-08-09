package com.urise.webapp.model;

import java.util.UUID;

/**
 * Initial resume class
 */
public class Resume {

    // Unique identifier
    private final String uuid;
    private String fullName;

    public Resume() {
        this(UUID.randomUUID().toString());
    }

    public Resume(String fullName) {
        this.uuid = (UUID.randomUUID().toString());
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return fullName;
    }

    public String uuid() {
        return uuid;
    }

    public String fullName() {
        return fullName;
    }
}
