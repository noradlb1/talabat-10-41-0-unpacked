package org.junit.internal.runners;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Deprecated
public class MethodValidator {
    private final List<Throwable> errors = new ArrayList();
    private TestClass testClass;

    public MethodValidator(TestClass testClass2) {
        this.testClass = testClass2;
    }

    private void validateTestMethods(Class<? extends Annotation> cls, boolean z11) {
        String str;
        for (Method next : this.testClass.getAnnotatedMethods(cls)) {
            if (Modifier.isStatic(next.getModifiers()) != z11) {
                if (z11) {
                    str = "should";
                } else {
                    str = "should not";
                }
                List<Throwable> list = this.errors;
                list.add(new Exception("Method " + next.getName() + "() " + str + " be static"));
            }
            if (!Modifier.isPublic(next.getDeclaringClass().getModifiers())) {
                List<Throwable> list2 = this.errors;
                list2.add(new Exception("Class " + next.getDeclaringClass().getName() + " should be public"));
            }
            if (!Modifier.isPublic(next.getModifiers())) {
                List<Throwable> list3 = this.errors;
                list3.add(new Exception("Method " + next.getName() + " should be public"));
            }
            if (next.getReturnType() != Void.TYPE) {
                List<Throwable> list4 = this.errors;
                list4.add(new Exception("Method " + next.getName() + " should be void"));
            }
            if (next.getParameterTypes().length != 0) {
                List<Throwable> list5 = this.errors;
                list5.add(new Exception("Method " + next.getName() + " should have no parameters"));
            }
        }
    }

    public void assertValid() throws InitializationError {
        if (!this.errors.isEmpty()) {
            throw new InitializationError(this.errors);
        }
    }

    public void validateInstanceMethods() {
        validateTestMethods(After.class, false);
        validateTestMethods(Before.class, false);
        Class<Test> cls = Test.class;
        validateTestMethods(cls, false);
        if (this.testClass.getAnnotatedMethods(cls).size() == 0) {
            this.errors.add(new Exception("No runnable methods"));
        }
    }

    public List<Throwable> validateMethodsForDefaultRunner() {
        validateNoArgConstructor();
        validateStaticMethods();
        validateInstanceMethods();
        return this.errors;
    }

    public void validateNoArgConstructor() {
        try {
            this.testClass.getConstructor();
        } catch (Exception e11) {
            this.errors.add(new Exception("Test class should have public zero-argument constructor", e11));
        }
    }

    public void validateStaticMethods() {
        validateTestMethods(BeforeClass.class, true);
        validateTestMethods(AfterClass.class, true);
    }
}
