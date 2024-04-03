package io.reactivex.internal.schedulers;

import i.b;
import io.reactivex.functions.Function;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class SchedulerPoolFactory {
    public static final boolean PURGE_ENABLED;
    public static final int PURGE_PERIOD_SECONDS;

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicReference<ScheduledExecutorService> f18521a = new AtomicReference<>();

    /* renamed from: b  reason: collision with root package name */
    public static final Map<ScheduledThreadPoolExecutor, Object> f18522b = new ConcurrentHashMap();

    public static final class ScheduledTask implements Runnable {
        public void run() {
            Iterator it = new ArrayList(SchedulerPoolFactory.f18522b.keySet()).iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) it.next();
                if (scheduledThreadPoolExecutor.isShutdown()) {
                    SchedulerPoolFactory.f18522b.remove(scheduledThreadPoolExecutor);
                } else {
                    scheduledThreadPoolExecutor.purge();
                }
            }
        }
    }

    public static final class SystemPropertyAccessor implements Function<String, String> {
        public String apply(String str) throws Exception {
            return System.getProperty(str);
        }
    }

    static {
        SystemPropertyAccessor systemPropertyAccessor = new SystemPropertyAccessor();
        boolean a11 = a(true, "rx2.purge-enabled", true, true, systemPropertyAccessor);
        PURGE_ENABLED = a11;
        PURGE_PERIOD_SECONDS = b(a11, "rx2.purge-period-seconds", 1, 1, systemPropertyAccessor);
        start();
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
        } catch (Throwable unused) {
            return z12;
        }
    }

    public static int b(boolean z11, String str, int i11, int i12, Function<String, String> function) {
        if (!z11) {
            return i12;
        }
        try {
            String apply = function.apply(str);
            if (apply == null) {
                return i11;
            }
            return Integer.parseInt(apply);
        } catch (Throwable unused) {
            return i11;
        }
    }

    public static void c(boolean z11, ScheduledExecutorService scheduledExecutorService) {
        if (z11 && (scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
            f18522b.put((ScheduledThreadPoolExecutor) scheduledExecutorService, scheduledExecutorService);
        }
    }

    public static ScheduledExecutorService create(ThreadFactory threadFactory) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        c(PURGE_ENABLED, newScheduledThreadPool);
        return newScheduledThreadPool;
    }

    public static void d(boolean z11) {
        if (z11) {
            while (true) {
                AtomicReference<ScheduledExecutorService> atomicReference = f18521a;
                ScheduledExecutorService scheduledExecutorService = atomicReference.get();
                if (scheduledExecutorService == null) {
                    ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge"));
                    if (b.a(atomicReference, scheduledExecutorService, newScheduledThreadPool)) {
                        ScheduledTask scheduledTask = new ScheduledTask();
                        int i11 = PURGE_PERIOD_SECONDS;
                        newScheduledThreadPool.scheduleAtFixedRate(scheduledTask, (long) i11, (long) i11, TimeUnit.SECONDS);
                        return;
                    }
                    newScheduledThreadPool.shutdownNow();
                } else {
                    return;
                }
            }
        }
    }

    public static void shutdown() {
        ScheduledExecutorService andSet = f18521a.getAndSet((Object) null);
        if (andSet != null) {
            andSet.shutdownNow();
        }
        f18522b.clear();
    }

    public static void start() {
        d(PURGE_ENABLED);
    }
}
