package net.bytebuddy.utility;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public interface Invoker {
    Object invoke(Method method, Object obj, Object[] objArr) throws IllegalAccessException, InvocationTargetException;

    Object newInstance(Constructor<?> constructor, Object[] objArr) throws InstantiationException, IllegalAccessException, InvocationTargetException;
}
