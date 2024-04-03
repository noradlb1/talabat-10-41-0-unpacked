package org.junit.internal.runners;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.junit.internal.AssumptionViolatedException;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.TestTimedOutException;

@Deprecated
public class MethodRoadie {
    private final Description description;
    private final RunNotifier notifier;
    private final Object test;
    private TestMethod testMethod;

    public MethodRoadie(Object obj, TestMethod testMethod2, RunNotifier runNotifier, Description description2) {
        this.test = obj;
        this.notifier = runNotifier;
        this.description = description2;
        this.testMethod = testMethod2;
    }

    private void runAfters() {
        for (Method invoke : this.testMethod.b()) {
            try {
                invoke.invoke(this.test, new Object[0]);
            } catch (InvocationTargetException e11) {
                a(e11.getTargetException());
            } catch (Throwable th2) {
                a(th2);
            }
        }
    }

    private void runBefores() throws FailedBefore {
        try {
            for (Method invoke : this.testMethod.c()) {
                invoke.invoke(this.test, new Object[0]);
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

    private void runWithTimeout(final long j11) {
        runBeforesThenTestThenAfters(new Runnable() {
            public void run() {
                ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
                Future submit = newSingleThreadExecutor.submit(new Callable<Object>() {
                    public Object call() throws Exception {
                        MethodRoadie.this.b();
                        return null;
                    }
                });
                newSingleThreadExecutor.shutdown();
                try {
                    long j11 = j11;
                    TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                    if (!newSingleThreadExecutor.awaitTermination(j11, timeUnit)) {
                        newSingleThreadExecutor.shutdownNow();
                    }
                    submit.get(0, timeUnit);
                } catch (TimeoutException unused) {
                    MethodRoadie.this.a(new TestTimedOutException(j11, TimeUnit.MILLISECONDS));
                } catch (Exception e11) {
                    MethodRoadie.this.a(e11);
                }
            }
        });
    }

    public void a(Throwable th2) {
        this.notifier.fireTestFailure(new Failure(this.description, th2));
    }

    public void b() {
        try {
            this.testMethod.invoke(this.test);
            if (this.testMethod.a()) {
                a(new AssertionError("Expected exception: " + this.testMethod.d().getName()));
            }
        } catch (InvocationTargetException e11) {
            Throwable targetException = e11.getTargetException();
            if (!(targetException instanceof AssumptionViolatedException)) {
                if (!this.testMethod.a()) {
                    a(targetException);
                } else if (this.testMethod.e(targetException)) {
                    a(new Exception("Unexpected exception, expected<" + this.testMethod.d().getName() + "> but was<" + targetException.getClass().getName() + ">", targetException));
                }
            }
        } catch (Throwable th2) {
            a(th2);
        }
    }

    public void run() {
        if (this.testMethod.isIgnored()) {
            this.notifier.fireTestIgnored(this.description);
            return;
        }
        this.notifier.fireTestStarted(this.description);
        try {
            long timeout = this.testMethod.getTimeout();
            if (timeout > 0) {
                runWithTimeout(timeout);
            } else {
                runTest();
            }
        } finally {
            this.notifier.fireTestFinished(this.description);
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0009 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void runBeforesThenTestThenAfters(java.lang.Runnable r2) {
        /*
            r1 = this;
            r1.runBefores()     // Catch:{ FailedBefore -> 0x0015, Exception -> 0x0009 }
            r2.run()     // Catch:{ FailedBefore -> 0x0015, Exception -> 0x0009 }
            goto L_0x0015
        L_0x0007:
            r2 = move-exception
            goto L_0x0011
        L_0x0009:
            java.lang.RuntimeException r2 = new java.lang.RuntimeException     // Catch:{ all -> 0x0007 }
            java.lang.String r0 = "test should never throw an exception to this level"
            r2.<init>(r0)     // Catch:{ all -> 0x0007 }
            throw r2     // Catch:{ all -> 0x0007 }
        L_0x0011:
            r1.runAfters()
            throw r2
        L_0x0015:
            r1.runAfters()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.junit.internal.runners.MethodRoadie.runBeforesThenTestThenAfters(java.lang.Runnable):void");
    }

    public void runTest() {
        runBeforesThenTestThenAfters(new Runnable() {
            public void run() {
                MethodRoadie.this.b();
            }
        });
    }
}
