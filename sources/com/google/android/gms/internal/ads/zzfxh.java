package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

public final class zzfxh {
    public static zzfxb zza(ExecutorService executorService) {
        zzfxb zzfxb;
        if (executorService instanceof zzfxb) {
            return (zzfxb) executorService;
        }
        if (executorService instanceof ScheduledExecutorService) {
            zzfxb = new zzfxg((ScheduledExecutorService) executorService);
        } else {
            zzfxb = new zzfxd(executorService);
        }
        return zzfxb;
    }

    public static Executor zzb() {
        return zzfwe.INSTANCE;
    }

    public static Executor zzc(Executor executor, zzfvg<?> zzfvg) {
        executor.getClass();
        if (executor == zzfwe.INSTANCE) {
            return executor;
        }
        return new zzfxc(executor, zzfvg);
    }
}
