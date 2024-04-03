package org.junit.internal.runners;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.internal.AssumptionViolatedException;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;

@Deprecated
public class ClassRoadie {
    private Description description;
    private RunNotifier notifier;
    private final Runnable runnable;
    private TestClass testClass;

    public ClassRoadie(RunNotifier runNotifier, TestClass testClass2, Description description2, Runnable runnable2) {
        this.notifier = runNotifier;
        this.testClass = testClass2;
        this.description = description2;
        this.runnable = runnable2;
    }

    private void runAfters() {
        for (Method invoke : this.testClass.a()) {
            try {
                invoke.invoke((Object) null, new Object[0]);
            } catch (InvocationTargetException e11) {
                a(e11.getTargetException());
            } catch (Throwable th2) {
                a(th2);
            }
        }
    }

    private void runBefores() throws FailedBefore {
        try {
            for (Method invoke : this.testClass.b()) {
                invoke.invoke((Object) null, new Object[0]);
            }
        } catch (InvocationTargetException e11) {
            throw e11.getTargetException();
        } catch (AssumptionViolatedException unused) {
            throw new FailedBefore();
        } catch (Throwable th2) {
            a(th2);
            throw new FailedBefore();
        }
    }

    public void a(Throwable th2) {
        this.notifier.fireTestFailure(new Failure(this.description, th2));
    }

    public void b() {
        this.runnable.run();
    }

    public void runProtected() {
        try {
            runBefores();
            b();
        } catch (FailedBefore unused) {
        } catch (Throwable th2) {
            runAfters();
            throw th2;
        }
        runAfters();
    }
}
