package com.example.spring.abc;

public final class GlobalObject {
    private static Object value = null;
    private GlobalObject() {

    }

    public synchronized static void setValue(Object o) {
        value = o;
    }

    public static Object getValue() {
        return value;
    }
}
