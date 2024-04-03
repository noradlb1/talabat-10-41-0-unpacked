package com.huawei.location.lite.common.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import net.bytebuddy.utility.JavaConstant;

public class ExecutorManager {
    private static final String THREADNAME_HEADER = "common";

    public static ThreadFactory createThreadFactory(final String str) {
        if (str != null && !str.trim().isEmpty()) {
            return new ThreadFactory() {
                private final AtomicInteger threadNumbers = new AtomicInteger(0);

                public Thread newThread(Runnable runnable) {
                    return new Thread(runnable, "Location_" + str + JavaConstant.Dynamic.DEFAULT_NAME + this.threadNumbers.getAndIncrement());
                }
            };
        }
        throw new NullPointerException("ThreadName is empty");
    }

    public static ExecutorService newCachedThreadPool(String str) {
        return new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), createThreadFactory(str));
    }

    public static ExecutorService newFixedThreadPool(int i11, int i12, String str) {
        return new ThreadPoolExecutor(i11, i12, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), createThreadFactory(str));
    }

    public static ScheduledExecutorService newScheduledThreadPool(int i11, String str) {
        return new ScheduledThreadPoolExecutor(i11, createThreadFactory(str));
    }

    public static ExecutorService newSingleThreadExecutor(String str) {
        return Executors.newSingleThreadExecutor(createThreadFactory(str));
    }
}
