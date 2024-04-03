package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

final class zzfwi<V> extends zzfwh<V> {
    private final zzfxa<V> zza;

    public zzfwi(zzfxa<V> zzfxa) {
        zzfxa.getClass();
        this.zza = zzfxa;
    }

    public final boolean cancel(boolean z11) {
        return this.zza.cancel(z11);
    }

    public final V get() throws InterruptedException, ExecutionException {
        return this.zza.get();
    }

    public final boolean isCancelled() {
        return this.zza.isCancelled();
    }

    public final boolean isDone() {
        return this.zza.isDone();
    }

    public final String toString() {
        return this.zza.toString();
    }

    public final void zzc(Runnable runnable, Executor executor) {
        this.zza.zzc(runnable, executor);
    }

    public final V get(long j11, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.zza.get(j11, timeUnit);
    }
}
