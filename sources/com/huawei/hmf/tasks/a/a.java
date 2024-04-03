package com.huawei.hmf.tasks.a;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final a f47664a = new a();

    /* renamed from: c  reason: collision with root package name */
    private static final int f47665c;

    /* renamed from: d  reason: collision with root package name */
    private static final int f47666d;

    /* renamed from: e  reason: collision with root package name */
    private static final int f47667e;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f47668b = new C0059a((byte) 0);

    /* renamed from: com.huawei.hmf.tasks.a.a$a  reason: collision with other inner class name */
    public static class C0059a implements Executor {
        private C0059a() {
        }

        public /* synthetic */ C0059a(byte b11) {
            this();
        }

        public final void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f47665c = availableProcessors;
        f47666d = availableProcessors + 1;
        f47667e = (availableProcessors * 2) + 1;
    }

    public static ExecutorService a() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f47666d, f47667e, 1, TimeUnit.SECONDS, new LinkedBlockingQueue());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static Executor b() {
        return f47664a.f47668b;
    }
}
