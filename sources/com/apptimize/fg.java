package com.apptimize;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class fg {

    /* renamed from: a  reason: collision with root package name */
    public static final String f42426a = "fg";

    /* renamed from: b  reason: collision with root package name */
    public static final ScheduledExecutorService f42427b = Executors.newSingleThreadScheduledExecutor();

    /* renamed from: c  reason: collision with root package name */
    public static final ExecutorService f42428c = Executors.newSingleThreadExecutor();

    /* renamed from: d  reason: collision with root package name */
    public static final ThreadPoolExecutor f42429d;

    static {
        String simpleName = fg.class.getSimpleName();
        f42429d = (ThreadPoolExecutor) fe.a(simpleName, null, new fk<ThreadPoolExecutor>() {
            /* renamed from: a */
            public ThreadPoolExecutor b() {
                int availableProcessors = Runtime.getRuntime().availableProcessors() + 1;
                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(availableProcessors, availableProcessors, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
                threadPoolExecutor.allowCoreThreadTimeOut(true);
                return threadPoolExecutor;
            }
        });
    }
}
