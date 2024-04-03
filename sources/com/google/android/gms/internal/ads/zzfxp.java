package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;
import javax.annotation.CheckForNull;

final class zzfxp<V> extends zzfwg<V> implements RunnableFuture<V> {
    @CheckForNull
    private volatile zzfwz<?> zza;

    public zzfxp(zzfvw<V> zzfvw) {
        this.zza = new zzfxn(this, zzfvw);
    }

    public static <V> zzfxp<V> zza(Runnable runnable, V v11) {
        return new zzfxp<>(Executors.callable(runnable, v11));
    }

    public final void run() {
        zzfwz<?> zzfwz = this.zza;
        if (zzfwz != null) {
            zzfwz.run();
        }
        this.zza = null;
    }

    @CheckForNull
    public final String zzd() {
        zzfwz<?> zzfwz = this.zza;
        if (zzfwz == null) {
            return super.zzd();
        }
        String obj = zzfwz.toString();
        StringBuilder sb2 = new StringBuilder(obj.length() + 7);
        sb2.append("task=[");
        sb2.append(obj);
        sb2.append("]");
        return sb2.toString();
    }

    public final void zze() {
        zzfwz<?> zzfwz;
        if (zzv() && (zzfwz = this.zza) != null) {
            zzfwz.zzh();
        }
        this.zza = null;
    }

    public zzfxp(Callable<V> callable) {
        this.zza = new zzfxo(this, callable);
    }
}
