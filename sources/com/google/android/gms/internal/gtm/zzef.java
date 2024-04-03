package com.google.android.gms.internal.gtm;

import android.content.Context;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class zzef extends ThreadPoolExecutor {
    private final Context zzrm;

    public zzef(Context context, int i11, int i12, long j11, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(1, 1, 0, timeUnit, blockingQueue, threadFactory);
        this.zzrm = context;
    }

    public final void afterExecute(Runnable runnable, Throwable th2) {
        if (th2 != null) {
            zzea.zza("Uncaught exception: ", th2, this.zzrm);
        }
    }
}
