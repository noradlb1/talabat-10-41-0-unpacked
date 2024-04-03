package org.mockito.internal.util.reflection;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import org.mockito.plugins.MemberAccessor;
import z30.l;
import z30.m;

public class ReflectionMemberAccessor implements MemberAccessor {
    private static void silentSetAccessible(AccessibleObject accessibleObject, boolean z11) {
        try {
            accessibleObject.setAccessible(z11);
        } catch (RuntimeException unused) {
        }
    }

    public Object get(Field field, Object obj) throws IllegalAccessException {
        silentSetAccessible(field, true);
        try {
            Object obj2 = field.get(obj);
            silentSetAccessible(field, false);
            return obj2;
        } catch (IllegalAccessException e11) {
            e = e11;
            throw e;
        } catch (IllegalArgumentException e12) {
            e = e12;
            throw e;
        } catch (RuntimeException e13) {
            throw new IllegalStateException("Could not read " + field + " from " + obj, e13);
        } catch (Throwable th2) {
            silentSetAccessible(field, false);
            throw th2;
        }
    }

    public Object invoke(Method method, Object obj, Object... objArr) throws InvocationTargetException, IllegalAccessException {
        silentSetAccessible(method, true);
        try {
            Object invoke = method.invoke(obj, objArr);
            silentSetAccessible(method, false);
            return invoke;
        } catch (InvocationTargetException e11) {
            e = e11;
            throw e;
        } catch (IllegalAccessException e12) {
            e = e12;
            throw e;
        } catch (IllegalArgumentException e13) {
            e = e13;
            throw e;
        } catch (RuntimeException e14) {
            throw new IllegalStateException("Could not invoke " + method + " on " + obj, e14);
        } catch (Throwable th2) {
            silentSetAccessible(method, false);
            throw th2;
        }
    }

    public Object newInstance(Constructor<?> constructor, Object... objArr) throws InstantiationException, InvocationTargetException, IllegalAccessException {
        return newInstance(constructor, new l(), objArr);
    }

    public void set(Field field, Object obj, Object obj2) throws IllegalAccessException {
        silentSetAccessible(field, true);
        try {
            field.set(obj, obj2);
            silentSetAccessible(field, false);
        } catch (IllegalAccessException e11) {
            e = e11;
            throw e;
        } catch (IllegalArgumentException e12) {
            e = e12;
            throw e;
        } catch (RuntimeException e13) {
            throw new IllegalStateException("Could not write " + field + " to " + obj, e13);
        } catch (Throwable th2) {
            silentSetAccessible(field, false);
            throw th2;
        }
    }

    public Object newInstance(Constructor<?> constructor, MemberAccessor.OnConstruction onConstruction, Object... objArr) throws InstantiationException, InvocationTargetException, IllegalAccessException {
        silentSetAccessible(constructor, true);
        try {
            Object invoke = onConstruction.invoke(new m(constructor, objArr));
            silentSetAccessible(constructor, false);
            return invoke;
        } catch (InvocationTargetException e11) {
            e = e11;
            throw e;
        } catch (IllegalAccessException e12) {
            e = e12;
            throw e;
        } catch (InstantiationException e13) {
            e = e13;
            throw e;
        } catch (IllegalArgumentException e14) {
            e = e14;
            throw e;
        } catch (RuntimeException e15) {
            throw new IllegalStateException("Failed to invoke " + constructor + " with " + Arrays.toString(objArr), e15);
        } catch (Throwable th2) {
            silentSetAccessible(constructor, false);
            throw th2;
        }
    }
}
