package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

public final class SchedulerPoolFactory {
    public static final boolean PURGE_ENABLED = a(true, "rx3.purge-enabled", true, true, new SystemPropertyAccessor());

    public static final class SystemPropertyAccessor implements Function<String, String> {
        public String apply(String str) {
            return System.getProperty(str);
        }
    }

    private SchedulerPoolFactory() {
        throw new IllegalStateException("No instances!");
    }

    public static boolean a(boolean z11, String str, boolean z12, boolean z13, Function<String, String> function) {
        if (!z11) {
            return z13;
        }
        try {
            String apply = function.apply(str);
            if (apply == null) {
                return z12;
            }
            return "true".equals(apply);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            return z12;
        }
    }

    public static ScheduledExecutorService create(ThreadFactory threadFactory) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, threadFactory);
        scheduledThreadPoolExecutor.setRemoveOnCancelPolicy(PURGE_ENABLED);
        return scheduledThreadPoolExecutor;
    }
}
