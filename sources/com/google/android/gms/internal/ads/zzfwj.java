package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public abstract class zzfwj<V> extends zzfsj implements Future<V> {
    public boolean cancel(boolean z11) {
        return zzb().cancel(z11);
    }

    public final V get() throws InterruptedException, ExecutionException {
        return zzb().get();
    }

    public final boolean isCancelled() {
        return zzb().isCancelled();
    }

    public final boolean isDone() {
        return zzb().isDone();
    }

    public /* bridge */ /* synthetic */ Object zza() {
        throw null;
    }

    public abstract Future<? extends V> zzb();

    public final V get(long j11, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return zzb().get(j11, timeUnit);
    }
}
