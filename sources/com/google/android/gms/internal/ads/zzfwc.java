package com.google.android.gms.internal.ads;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

abstract class zzfwc<T> extends zzfwz<T> {
    private final Executor zza;
    final /* synthetic */ zzfwd zzb;

    public zzfwc(zzfwd zzfwd, Executor executor) {
        this.zzb = zzfwd;
        executor.getClass();
        this.zza = executor;
    }

    public abstract void zzc(T t11);

    public final void zzd(Throwable th2) {
        this.zzb.zza = null;
        if (th2 instanceof ExecutionException) {
            this.zzb.zzt(((ExecutionException) th2).getCause());
        } else if (th2 instanceof CancellationException) {
            this.zzb.cancel(false);
        } else {
            this.zzb.zzt(th2);
        }
    }

    public final void zze(T t11) {
        this.zzb.zza = null;
        zzc(t11);
    }

    public final void zzf() {
        try {
            this.zza.execute(this);
        } catch (RejectedExecutionException e11) {
            this.zzb.zzt(e11);
        }
    }

    public final boolean zzg() {
        return this.zzb.isDone();
    }
}
