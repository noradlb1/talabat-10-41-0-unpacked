package com.huawei.hms.analytics;

import com.huawei.hms.analytics.core.log.HiLog;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class dg {
    private static final dg ijk = new dg(1);
    private static final dg ikl = new dg(3);
    private static final dg klm = new dg(3);
    private static final dg lmn = new dg(1);
    private final ThreadPoolExecutor hij;

    public static class lmn implements Runnable {
        private Runnable lmn;

        public lmn(Runnable runnable) {
            this.lmn = runnable;
        }

        public final void run() {
            Runnable runnable = this.lmn;
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Throwable th2) {
                    HiLog.w("ThreadStock", "InnerTask : Error has happened,From internal operations!" + th2.getMessage());
                    dr.lmn(th2);
                }
            }
        }
    }

    private dg(int i11) {
        int i12 = i11;
        this.hij = new ThreadPoolExecutor(0, i12, 60000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(5000));
    }

    public static dg ijk() {
        return ijk;
    }

    public static dg ikl() {
        return ikl;
    }

    public static dg klm() {
        return klm;
    }

    public static dg lmn() {
        return lmn;
    }

    public final void lmn(Runnable runnable) {
        try {
            this.hij.execute(new lmn(runnable));
        } catch (RejectedExecutionException unused) {
            HiLog.w("ThreadStock", "addToQueue() Exception has happened!Form rejected execution");
        }
    }
}
