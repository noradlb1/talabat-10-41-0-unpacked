package org.junit.internal.runners;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.Filterable;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runner.manipulation.Sortable;
import org.junit.runner.manipulation.Sorter;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;

@Deprecated
public class JUnit4ClassRunner extends Runner implements Filterable, Sortable {
    private TestClass testClass;
    private final List<Method> testMethods = d();

    public JUnit4ClassRunner(Class<?> cls) throws InitializationError {
        this.testClass = new TestClass(cls);
        validate();
    }

    private void testAborted(RunNotifier runNotifier, Description description, Throwable th2) {
        runNotifier.fireTestStarted(description);
        runNotifier.fireTestFailure(new Failure(description, th2));
        runNotifier.fireTestFinished(description);
    }

    public Annotation[] a() {
        return this.testClass.getJavaClass().getAnnotations();
    }

    public String b() {
        return c().getName();
    }

    public TestClass c() {
        return this.testClass;
    }

    public Object createTest() throws Exception {
        return c().getConstructor().newInstance(new Object[0]);
    }

    public List<Method> d() {
        return this.testClass.getTestMethods();
    }

    public void e(Method method, RunNotifier runNotifier) {
        Description f11 = f(method);
        try {
            new MethodRoadie(createTest(), j(method), runNotifier, f11).run();
        } catch (InvocationTargetException e11) {
            testAborted(runNotifier, f11, e11.getCause());
        } catch (Exception e12) {
            testAborted(runNotifier, f11, e12);
        }
    }

    public Description f(Method method) {
        return Description.createTestDescription(c().getJavaClass(), i(method), h(method));
    }

    public void filter(Filter filter) throws NoTestsRemainException {
        Iterator<Method> it = this.testMethods.iterator();
        while (it.hasNext()) {
            if (!filter.shouldRun(f(it.next()))) {
                it.remove();
            }
        }
        if (this.testMethods.isEmpty()) {
            throw new NoTestsRemainException();
        }
    }

    public void g(RunNotifier runNotifier) {
        for (Method e11 : this.testMethods) {
            e(e11, runNotifier);
        }
    }

    public Description getDescription() {
        Description createSuiteDescription = Description.createSuiteDescription(b(), a());
        for (Method f11 : this.testMethods) {
            createSuiteDescription.addChild(f(f11));
        }
        return createSuiteDescription;
    }

    public Annotation[] h(Method method) {
        return method.getAnnotations();
    }

    public String i(Method method) {
        return method.getName();
    }

    public TestMethod j(Method method) {
        return new TestMethod(method, this.testClass);
    }

    public void run(final RunNotifier runNotifier) {
        new ClassRoadie(runNotifier, this.testClass, getDescription(), new Runnable() {
            public void run() {
                JUnit4ClassRunner.this.g(runNotifier);
            }
        }).runProtected();
    }

    public void sort(final Sorter sorter) {
        Collections.sort(this.testMethods, new Comparator<Method>() {
            public int compare(Method method, Method method2) {
                return sorter.compare(JUnit4ClassRunner.this.f(method), JUnit4ClassRunner.this.f(method2));
            }
        });
    }

    public void validate() throws InitializationError {
        MethodValidator methodValidator = new MethodValidator(this.testClass);
        methodValidator.validateMethodsForDefaultRunner();
        methodValidator.assertValid();
    }
}
