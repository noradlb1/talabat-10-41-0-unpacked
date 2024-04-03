package org.junit.internal.runners;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

@Deprecated
public class TestMethod {
    private final Method method;
    private TestClass testClass;

    public TestMethod(Method method2, TestClass testClass2) {
        this.method = method2;
        this.testClass = testClass2;
    }

    public boolean a() {
        return d() != null;
    }

    public List<Method> b() {
        return this.testClass.getAnnotatedMethods(After.class);
    }

    public List<Method> c() {
        return this.testClass.getAnnotatedMethods(Before.class);
    }

    public Class<? extends Throwable> d() {
        Test test = (Test) this.method.getAnnotation(Test.class);
        if (test == null || test.expected() == Test.None.class) {
            return null;
        }
        return test.expected();
    }

    public boolean e(Throwable th2) {
        return !d().isAssignableFrom(th2.getClass());
    }

    public long getTimeout() {
        Test test = (Test) this.method.getAnnotation(Test.class);
        if (test == null) {
            return 0;
        }
        return test.timeout();
    }

    public void invoke(Object obj) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        this.method.invoke(obj, new Object[0]);
    }

    public boolean isIgnored() {
        return this.method.getAnnotation(Ignore.class) != null;
    }
}
