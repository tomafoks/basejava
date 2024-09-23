package com.urise.webapp;

import com.urise.webapp.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MaineReflection {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Resume r = new Resume();
        Field field = r.getClass().getDeclaredFields()[0];
        System.out.println(field.getName());
        field.setAccessible(true);
        System.out.println(field.get(r));
        field.get(r);
        field.set(r, "new_uuid");
        System.out.println(r);
        System.out.println("");


        Class<? extends Resume> res = r.getClass();
        Method toStr = res.getMethod("toString");
        System.out.println(toStr.getName());
    }
}
