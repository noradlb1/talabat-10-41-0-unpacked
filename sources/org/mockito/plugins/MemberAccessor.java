package org.mockito.plugins;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public interface MemberAccessor {

    public interface ConstructionDispatcher {
        Object newInstance() throws InstantiationException, InvocationTargetException, IllegalAccessException;
    }

    public interface OnConstruction {
        Object invoke(ConstructionDispatcher constructionDispatcher) throws InstantiationException, InvocationTargetException, IllegalAccessException;
    }

    Object get(Field field, Object obj) throws IllegalAccessException;

    Object invoke(Method method, Object obj, Object... objArr) throws InvocationTargetException, IllegalAccessException;

    Object newInstance(Constructor<?> constructor, OnConstruction onConstruction, Object... objArr) throws InstantiationException, InvocationTargetException, IllegalAccessException;

    Object newInstance(Constructor<?> constructor, Object... objArr) throws InstantiationException, InvocationTargetException, IllegalAccessException;

    void set(Field field, Object obj, Object obj2) throws IllegalAccessException;
}
