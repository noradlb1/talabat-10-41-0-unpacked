package com.huawei.hms.analytics.framework.f;

import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.framework.b.b;
import com.huawei.hms.analytics.framework.config.ICollectorConfig;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f48000a = new a(5);

    /* renamed from: b  reason: collision with root package name */
    private static a f48001b = new a(1);

    /* renamed from: c  reason: collision with root package name */
    private ThreadPoolExecutor f48002c;

    /* renamed from: com.huawei.hms.analytics.framework.f.a$a  reason: collision with other inner class name */
    public static class C0062a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private Runnable f48003a;

        public C0062a(Runnable runnable) {
            this.f48003a = runnable;
        }

        public final void run() {
            Runnable runnable = this.f48003a;
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Throwable th2) {
                    ICollectorConfig a11 = b.a().a("_openness_config_tag");
                    if (a11 != null) {
                        a11.handlerThrowable(th2);
                    }
                    HiLog.e("MissionThread", "other error :" + th2.getMessage());
                }
            }
        }
    }

    private a(int i11) {
        int i12 = i11;
        this.f48002c = new ThreadPoolExecutor(0, i12, 10000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(5000));
    }

    public static a a() {
        return f48000a;
    }

    public static a b() {
        return f48001b;
    }

    public final void a(Runnable runnable) {
        try {
            this.f48002c.execute(new C0062a(runnable));
        } catch (RejectedExecutionException unused) {
            HiLog.w("MissionThread", "addToQueue() Exception has happened! From rejected execution");
        }
    }
}
