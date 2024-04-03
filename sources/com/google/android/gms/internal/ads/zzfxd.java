package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

class zzfxd extends zzfvj {
    private final ExecutorService zza;

    public zzfxd(ExecutorService executorService) {
        executorService.getClass();
        this.zza = executorService;
    }

    public final boolean awaitTermination(long j11, TimeUnit timeUnit) throws InterruptedException {
        return this.zza.awaitTermination(j11, timeUnit);
    }

    public final void execute(Runnable runnable) {
        this.zza.execute(runnable);
    }

    public final boolean isShutdown() {
        return this.zza.isShutdown();
    }

    public final boolean isTerminated() {
        return this.zza.isTerminated();
    }

    public final void shutdown() {
        this.zza.shutdown();
    }

    public final List<Runnable> shutdownNow() {
        return this.zza.shutdownNow();
    }

    public final String toString() {
        String obj = super.toString();
        String valueOf = String.valueOf(this.zza);
        StringBuilder sb2 = new StringBuilder(String.valueOf(obj).length() + 2 + valueOf.length());
        sb2.append(obj);
        sb2.append("[");
        sb2.append(valueOf);
        sb2.append("]");
        return sb2.toString();
    }
}
