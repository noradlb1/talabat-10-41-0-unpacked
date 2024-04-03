package com.huawei.hms.hatool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class b0 {

    /* renamed from: b  reason: collision with root package name */
    private static b0 f48970b = new b0();

    /* renamed from: c  reason: collision with root package name */
    private static b0 f48971c = new b0();

    /* renamed from: d  reason: collision with root package name */
    private static b0 f48972d = new b0();

    /* renamed from: a  reason: collision with root package name */
    private ThreadPoolExecutor f48973a = new ThreadPoolExecutor(0, 1, 60000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(5000), new b());

    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private Runnable f48974a;

        public a(Runnable runnable) {
            this.f48974a = runnable;
        }

        public void run() {
            Runnable runnable = this.f48974a;
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Exception unused) {
                    v.e("hmsSdk", "InnerTask : Exception has happened,From internal operations!");
                }
            }
        }
    }

    public static class b implements ThreadFactory {

        /* renamed from: d  reason: collision with root package name */
        private static final AtomicInteger f48975d = new AtomicInteger(1);

        /* renamed from: a  reason: collision with root package name */
        private final ThreadGroup f48976a;

        /* renamed from: b  reason: collision with root package name */
        private final AtomicInteger f48977b = new AtomicInteger(1);

        /* renamed from: c  reason: collision with root package name */
        private final String f48978c;

        public b() {
            SecurityManager securityManager = System.getSecurityManager();
            this.f48976a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.f48978c = "FormalHASDK-base-" + f48975d.getAndIncrement();
        }

        public Thread newThread(Runnable runnable) {
            ThreadGroup threadGroup = this.f48976a;
            return new Thread(threadGroup, runnable, this.f48978c + this.f48977b.getAndIncrement(), 0);
        }
    }

    static {
        new b0();
        new b0();
    }

    private b0() {
    }

    public static b0 a() {
        return f48972d;
    }

    public static b0 b() {
        return f48971c;
    }

    public static b0 c() {
        return f48970b;
    }

    public void a(g gVar) {
        try {
            this.f48973a.execute(new a(gVar));
        } catch (RejectedExecutionException unused) {
            v.e("hmsSdk", "addToQueue() Exception has happened!Form rejected execution");
        }
    }
}
