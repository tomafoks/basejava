package com.urise.webapp;

import com.urise.webapp.model.Resume;

import java.lang.reflect.Field;

public class MaineReflection {
    public static void main(String[] args) throws IllegalAccessException {
        Resume r = new Resume();
        Field field = r.getClass().getDeclaredFields()[0];
        System.out.println(field.getName());
        field.setAccessible(true);
        System.out.println(r);
        field.get(r);
        field.set(r, "new_uuid");
        System.out.println(r);
    }
}
