package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import i9.c;
import i9.d;
import i9.e;
import i9.f;
import java.util.concurrent.Callable;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class Callables {
    private Callables() {
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static <T> AsyncCallable<T> asAsyncCallable(Callable<T> callable, ListeningExecutorService listeningExecutorService) {
        Preconditions.checkNotNull(callable);
        Preconditions.checkNotNull(listeningExecutorService);
        return new f(listeningExecutorService, callable);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object lambda$returning$0(Object obj) throws Exception {
        return obj;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object lambda$threadRenaming$2(Supplier supplier, Callable callable) throws Exception {
        Thread currentThread = Thread.currentThread();
        String name2 = currentThread.getName();
        boolean trySetName = trySetName((String) supplier.get(), currentThread);
        try {
            return callable.call();
        } finally {
            if (trySetName) {
                trySetName(name2, currentThread);
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$threadRenaming$3(Supplier supplier, Runnable runnable) {
        Thread currentThread = Thread.currentThread();
        String name2 = currentThread.getName();
        boolean trySetName = trySetName((String) supplier.get(), currentThread);
        try {
            runnable.run();
        } finally {
            if (trySetName) {
                trySetName(name2, currentThread);
            }
        }
    }

    public static <T> Callable<T> returning(@ParametricNullness T t11) {
        return new c(t11);
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static <T> Callable<T> threadRenaming(Callable<T> callable, Supplier<String> supplier) {
        Preconditions.checkNotNull(supplier);
        Preconditions.checkNotNull(callable);
        return new e(supplier, callable);
    }

    @GwtIncompatible
    @J2ktIncompatible
    private static boolean trySetName(String str, Thread thread) {
        try {
            thread.setName(str);
            return true;
        } catch (SecurityException unused) {
            return false;
        }
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static Runnable threadRenaming(Runnable runnable, Supplier<String> supplier) {
        Preconditions.checkNotNull(supplier);
        Preconditions.checkNotNull(runnable);
        return new d(supplier, runnable);
    }
}
