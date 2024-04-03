package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class zzfhj<E, V> implements zzfxa<V> {
    private final E zza;
    private final String zzb;
    private final zzfxa<V> zzc;

    @VisibleForTesting(otherwise = 3)
    public zzfhj(E e11, String str, zzfxa<V> zzfxa) {
        this.zza = e11;
        this.zzb = str;
        this.zzc = zzfxa;
    }

    public final boolean cancel(boolean z11) {
        return this.zzc.cancel(z11);
    }

    public final V get() throws InterruptedException, ExecutionException {
        return this.zzc.get();
    }

    public final boolean isCancelled() {
        return this.zzc.isCancelled();
    }

    public final boolean isDone() {
        return this.zzc.isDone();
    }

    public final String toString() {
        String str = this.zzb;
        int identityHashCode = System.identityHashCode(this);
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 12);
        sb2.append(str);
        sb2.append("@");
        sb2.append(identityHashCode);
        return sb2.toString();
    }

    public final E zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zzb;
    }

    public final void zzc(Runnable runnable, Executor executor) {
        this.zzc.zzc(runnable, executor);
    }

    public final V get(long j11, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.zzc.get(j11, timeUnit);
    }
}
