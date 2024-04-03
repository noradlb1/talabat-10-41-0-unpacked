package com.huawei.hms.feature.dynamic;

import com.huawei.hms.common.util.Logger;
import java.lang.Thread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f48784a = "ExecutorsManager";

    /* renamed from: b  reason: collision with root package name */
    private static final long f48785b = 60;

    public static class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f48786a = new AtomicInteger(1);

        /* renamed from: b  reason: collision with root package name */
        private final String f48787b;

        /* renamed from: com.huawei.hms.feature.dynamic.c$a$a  reason: collision with other inner class name */
        public class C0067a implements Thread.UncaughtExceptionHandler {
            public C0067a() {
            }

            public void uncaughtException(Thread thread, Throwable th2) {
                Logger.e(c.f48784a, thread.getName() + " : " + th2.getMessage());
            }
        }

        public a(String str) {
            this.f48787b = str + "-thread-";
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f48787b + this.f48786a.getAndIncrement());
            thread.setUncaughtExceptionHandler(new C0067a());
            return thread;
        }
    }

    public static ExecutorService a(int i11, String str) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i11, i11, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a(str));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }
}
