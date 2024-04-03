package io.reactivex.rxjava3.android.plugins;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import java.util.concurrent.Callable;

public final class RxAndroidPlugins {
    private static volatile Function<Callable<Scheduler>, Scheduler> onInitMainThreadHandler;
    private static volatile Function<Scheduler, Scheduler> onMainThreadHandler;

    private RxAndroidPlugins() {
        throw new AssertionError("No instances.");
    }

    public static <T, R> R a(Function<T, R> function, T t11) {
        try {
            return function.apply(t11);
        } catch (Throwable th2) {
            throw Exceptions.propagate(th2);
        }
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [io.reactivex.rxjava3.functions.Function<java.util.concurrent.Callable<io.reactivex.rxjava3.core.Scheduler>, io.reactivex.rxjava3.core.Scheduler>, io.reactivex.rxjava3.functions.Function] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static io.reactivex.rxjava3.core.Scheduler b(io.reactivex.rxjava3.functions.Function<java.util.concurrent.Callable<io.reactivex.rxjava3.core.Scheduler>, io.reactivex.rxjava3.core.Scheduler> r0, java.util.concurrent.Callable<io.reactivex.rxjava3.core.Scheduler> r1) {
        /*
            java.lang.Object r0 = a(r0, r1)
            io.reactivex.rxjava3.core.Scheduler r0 = (io.reactivex.rxjava3.core.Scheduler) r0
            if (r0 == 0) goto L_0x0009
            return r0
        L_0x0009:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Scheduler Callable returned null"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.android.plugins.RxAndroidPlugins.b(io.reactivex.rxjava3.functions.Function, java.util.concurrent.Callable):io.reactivex.rxjava3.core.Scheduler");
    }

    public static Scheduler c(Callable<Scheduler> callable) {
        try {
            Scheduler call = callable.call();
            if (call != null) {
                return call;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th2) {
            throw Exceptions.propagate(th2);
        }
    }

    public static Function<Callable<Scheduler>, Scheduler> getInitMainThreadSchedulerHandler() {
        return onInitMainThreadHandler;
    }

    public static Function<Scheduler, Scheduler> getOnMainThreadSchedulerHandler() {
        return onMainThreadHandler;
    }

    public static Scheduler initMainThreadScheduler(Callable<Scheduler> callable) {
        if (callable != null) {
            Function<Callable<Scheduler>, Scheduler> function = onInitMainThreadHandler;
            if (function == null) {
                return c(callable);
            }
            return b(function, callable);
        }
        throw new NullPointerException("scheduler == null");
    }

    public static Scheduler onMainThreadScheduler(Scheduler scheduler) {
        if (scheduler != null) {
            Function function = onMainThreadHandler;
            if (function == null) {
                return scheduler;
            }
            return (Scheduler) a(function, scheduler);
        }
        throw new NullPointerException("scheduler == null");
    }

    public static void reset() {
        setInitMainThreadSchedulerHandler((Function<Callable<Scheduler>, Scheduler>) null);
        setMainThreadSchedulerHandler((Function<Scheduler, Scheduler>) null);
    }

    public static void setInitMainThreadSchedulerHandler(Function<Callable<Scheduler>, Scheduler> function) {
        onInitMainThreadHandler = function;
    }

    public static void setMainThreadSchedulerHandler(Function<Scheduler, Scheduler> function) {
        onMainThreadHandler = function;
    }
}
