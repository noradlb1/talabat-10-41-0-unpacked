package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class zzfph implements zzfpf {
    private zzfph() {
    }

    public /* synthetic */ zzfph(zzfpg zzfpg) {
    }

    public final ExecutorService zza(int i11) {
        return zzc(1, Executors.defaultThreadFactory(), 2);
    }

    public final ExecutorService zzb(ThreadFactory threadFactory, int i11) {
        return zzc(1, threadFactory, 1);
    }

    public final ExecutorService zzc(int i11, ThreadFactory threadFactory, int i12) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i11, i11, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactory);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return Executors.unconfigurableExecutorService(threadPoolExecutor);
    }
}
