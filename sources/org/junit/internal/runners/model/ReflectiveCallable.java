package org.junit.internal.runners.model;

import java.lang.reflect.InvocationTargetException;

public abstract class ReflectiveCallable {
    public abstract Object a() throws Throwable;

    public Object run() throws Throwable {
        try {
            return a();
        } catch (InvocationTargetException e11) {
            throw e11.getTargetException();
        }
    }
}
