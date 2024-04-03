package com.google.android.gms.internal.ads;

import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;

public abstract class zzfvj extends AbstractExecutorService implements zzfxb {
    public final <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t11) {
        return zzfxp.zza(runnable, t11);
    }

    public final /* synthetic */ Future submit(Runnable runnable) {
        return (zzfxa) super.submit(runnable);
    }

    public final zzfxa<?> zza(Runnable runnable) {
        return (zzfxa) super.submit(runnable);
    }

    public final <T> zzfxa<T> zzb(Callable<T> callable) {
        return (zzfxa) super.submit(callable);
    }

    public final <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new zzfxp(callable);
    }

    public final /* synthetic */ Future submit(Runnable runnable, Object obj) {
        return (zzfxa) super.submit(runnable, obj);
    }

    public final /* synthetic */ Future submit(Callable callable) {
        return (zzfxa) super.submit(callable);
    }
}
