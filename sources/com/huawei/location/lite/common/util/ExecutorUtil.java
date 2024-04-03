package com.huawei.location.lite.common.util;

import androidx.annotation.NonNull;
import com.huawei.location.lite.common.log.LogConsole;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorUtil {
    private static final long KEEP_ALIVE_TIME = 60;
    private static final String LOCATION_POOL_DELAY_PREFIX_DEFAULT = "Loc-Task-Delay";
    private static final String LOCATION_POOL_PREFIX_DEFAULT = "Location-Task";
    private static final int THREAD_CORE = 5;
    private static final int THREAD_MAX = 10;
    private final ThreadPoolExecutor executor;
    private final ScheduledExecutorService scheduledExecutor;

    public static class ExecutorsHolder {
        /* access modifiers changed from: private */
        public static final ExecutorUtil INSTANCE = new ExecutorUtil();

        private ExecutorsHolder() {
        }
    }

    public static class NamedThreadFactory implements ThreadFactory {
        private final AtomicInteger counter = new AtomicInteger(1);
        private final String poolName;

        public NamedThreadFactory(String str) {
            this.poolName = str;
        }

        public Thread newThread(@NonNull Runnable runnable) {
            return new Thread(runnable, this.poolName + SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE + this.counter.getAndIncrement());
        }
    }

    private ExecutorUtil() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory(LOCATION_POOL_PREFIX_DEFAULT));
        this.executor = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.scheduledExecutor = new ScheduledThreadPoolExecutor(5, new NamedThreadFactory(LOCATION_POOL_DELAY_PREFIX_DEFAULT));
    }

    public static ExecutorUtil getInstance() {
        return ExecutorsHolder.INSTANCE;
    }

    public ScheduledFuture execute(Runnable runnable, long j11, TimeUnit timeUnit) {
        try {
            return getScheduledExecutor().schedule(runnable, j11, timeUnit);
        } catch (Throwable unused) {
            LogConsole.e("ExecutorUtil", "scheduledExecutor schedule fatal error", true);
            return null;
        }
    }

    public void execute(Runnable runnable) {
        try {
            getExecutor().execute(runnable);
        } catch (Throwable unused) {
            LogConsole.e("ExecutorUtil", "ExecutorUtil fatal error", true);
        }
    }

    public ExecutorService getExecutor() {
        return this.executor;
    }

    public ScheduledExecutorService getScheduledExecutor() {
        return this.scheduledExecutor;
    }
}
