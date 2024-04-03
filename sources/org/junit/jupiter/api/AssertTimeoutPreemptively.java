package org.junit.jupiter.api;

import j$.time.Duration;
import j$.util.function.Supplier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.function.ThrowingSupplier;
import org.junit.platform.commons.JUnitException;
import org.junit.platform.commons.util.ExceptionUtils;
import org.opentest4j.AssertionFailedError;

class AssertTimeoutPreemptively {

    public static class ExecutionTimeoutException extends JUnitException {
        private static final long serialVersionUID = 1;

        public ExecutionTimeoutException(String str) {
            super(str);
        }
    }

    public static class TimeoutThreadFactory implements ThreadFactory {
        private static final AtomicInteger threadNumber = new AtomicInteger(1);

        private TimeoutThreadFactory() {
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "junit-timeout-thread-" + threadNumber.getAndIncrement());
        }
    }

    /* access modifiers changed from: private */
    public static AssertionFailedError createAssertionFailure(Duration duration, Supplier<String> supplier, Throwable th2) {
        AssertionFailureBuilder message = AssertionFailureBuilder.assertionFailure().message(supplier);
        return message.reason("execution timed out after " + duration.toMillis() + " ms").cause(th2).build();
    }

    public static <T> T f(Duration duration, ThrowingSupplier<T> throwingSupplier) {
        return i(duration, throwingSupplier, (Supplier<String>) null, new i());
    }

    public static <T> T g(Duration duration, ThrowingSupplier<T> throwingSupplier, String str) {
        return i(duration, throwingSupplier, str == null ? null : new h(str), new i());
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [j$.util.function.Supplier, j$.util.function.Supplier<java.lang.String>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> T h(j$.time.Duration r1, org.junit.jupiter.api.function.ThrowingSupplier<T> r2, j$.util.function.Supplier<java.lang.String> r3) {
        /*
            org.junit.jupiter.api.i r0 = new org.junit.jupiter.api.i
            r0.<init>()
            java.lang.Object r1 = i(r1, r2, r3, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.junit.jupiter.api.AssertTimeoutPreemptively.h(j$.time.Duration, org.junit.jupiter.api.function.ThrowingSupplier, j$.util.function.Supplier):java.lang.Object");
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [j$.util.function.Supplier, j$.util.function.Supplier<java.lang.String>] */
    /* JADX WARNING: type inference failed for: r6v0, types: [org.junit.jupiter.api.Assertions$TimeoutFailureFactory, org.junit.jupiter.api.Assertions$TimeoutFailureFactory<E>] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T, E extends java.lang.Throwable> T i(j$.time.Duration r3, org.junit.jupiter.api.function.ThrowingSupplier<T> r4, j$.util.function.Supplier<java.lang.String> r5, org.junit.jupiter.api.Assertions.TimeoutFailureFactory<E> r6) throws java.lang.Throwable {
        /*
            java.util.concurrent.atomic.AtomicReference r0 = new java.util.concurrent.atomic.AtomicReference
            r0.<init>()
            org.junit.jupiter.api.AssertTimeoutPreemptively$TimeoutThreadFactory r1 = new org.junit.jupiter.api.AssertTimeoutPreemptively$TimeoutThreadFactory
            r2 = 0
            r1.<init>()
            java.util.concurrent.ExecutorService r1 = java.util.concurrent.Executors.newSingleThreadExecutor(r1)
            java.util.concurrent.Future r4 = submitTask(r4, r0, r1)     // Catch:{ all -> 0x0020 }
            x20.d r2 = new x20.d     // Catch:{ all -> 0x0020 }
            r2.<init>(r0)     // Catch:{ all -> 0x0020 }
            java.lang.Object r3 = resolveFutureAndHandleException(r4, r3, r5, r2, r6)     // Catch:{ all -> 0x0020 }
            r1.shutdownNow()
            return r3
        L_0x0020:
            r3 = move-exception
            r1.shutdownNow()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.junit.jupiter.api.AssertTimeoutPreemptively.i(j$.time.Duration, org.junit.jupiter.api.function.ThrowingSupplier, j$.util.function.Supplier, org.junit.jupiter.api.Assertions$TimeoutFailureFactory):java.lang.Object");
    }

    public static void j(Duration duration, Executable executable) {
        k(duration, executable, (String) null);
    }

    public static void k(Duration duration, Executable executable, String str) {
        g(duration, new k(executable), str);
    }

    public static void l(Duration duration, Executable executable, Supplier<String> supplier) {
        h(duration, new l(executable), supplier);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String lambda$assertTimeoutPreemptively$2(String str) {
        return str;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object lambda$submitTask$3(AtomicReference atomicReference, ThrowingSupplier throwingSupplier) throws Exception {
        try {
            atomicReference.set(Thread.currentThread());
            return throwingSupplier.get();
        } catch (Throwable th2) {
            throw ExceptionUtils.throwAsUncheckedException(th2);
        }
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [j$.util.function.Supplier, j$.util.function.Supplier<java.lang.String>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <T, E extends java.lang.Throwable> T resolveFutureAndHandleException(java.util.concurrent.Future<T> r3, j$.time.Duration r4, j$.util.function.Supplier<java.lang.String> r5, j$.util.function.Supplier<java.lang.Thread> r6, org.junit.jupiter.api.Assertions.TimeoutFailureFactory<E> r7) throws java.lang.Throwable {
        /*
            long r0 = r4.toMillis()     // Catch:{ TimeoutException -> 0x001b, ExecutionException -> 0x0011, all -> 0x000b }
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ TimeoutException -> 0x001b, ExecutionException -> 0x0011, all -> 0x000b }
            java.lang.Object r3 = r3.get(r0, r2)     // Catch:{ TimeoutException -> 0x001b, ExecutionException -> 0x0011, all -> 0x000b }
            return r3
        L_0x000b:
            r3 = move-exception
            java.lang.RuntimeException r3 = org.junit.platform.commons.util.ExceptionUtils.throwAsUncheckedException(r3)
            throw r3
        L_0x0011:
            r3 = move-exception
            java.lang.Throwable r3 = r3.getCause()
            java.lang.RuntimeException r3 = org.junit.platform.commons.util.ExceptionUtils.throwAsUncheckedException(r3)
            throw r3
        L_0x001b:
            java.lang.Object r3 = r6.get()
            java.lang.Thread r3 = (java.lang.Thread) r3
            if (r3 == 0) goto L_0x0045
            org.junit.jupiter.api.AssertTimeoutPreemptively$ExecutionTimeoutException r6 = new org.junit.jupiter.api.AssertTimeoutPreemptively$ExecutionTimeoutException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Execution timed out in thread "
            r0.append(r1)
            java.lang.String r1 = r3.getName()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r6.<init>(r0)
            java.lang.StackTraceElement[] r3 = r3.getStackTrace()
            r6.setStackTrace(r3)
            goto L_0x0046
        L_0x0045:
            r6 = 0
        L_0x0046:
            java.lang.Throwable r3 = r7.createTimeoutFailure(r4, r5, r6)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.junit.jupiter.api.AssertTimeoutPreemptively.resolveFutureAndHandleException(java.util.concurrent.Future, j$.time.Duration, j$.util.function.Supplier, j$.util.function.Supplier, org.junit.jupiter.api.Assertions$TimeoutFailureFactory):java.lang.Object");
    }

    private static <T> Future<T> submitTask(ThrowingSupplier<T> throwingSupplier, AtomicReference<Thread> atomicReference, ExecutorService executorService) {
        return executorService.submit(new j(atomicReference, throwingSupplier));
    }
}
