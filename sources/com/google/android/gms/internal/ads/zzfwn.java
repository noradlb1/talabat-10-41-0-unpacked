package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

final class zzfwn<V> implements Runnable {
    final Future<V> zza;
    final zzfwm<? super V> zzb;

    public zzfwn(Future<V> future, zzfwm<? super V> zzfwm) {
        this.zza = future;
        this.zzb = zzfwm;
    }

    public final void run() {
        Throwable zza2;
        Future<V> future = this.zza;
        if (!(future instanceof zzfxs) || (zza2 = zzfxt.zza((zzfxs) future)) == null) {
            try {
                this.zzb.zzb(zzfwq.zzp(this.zza));
            } catch (ExecutionException e11) {
                this.zzb.zza(e11.getCause());
            } catch (Error | RuntimeException e12) {
                this.zzb.zza(e12);
            }
        } else {
            this.zzb.zza(zza2);
        }
    }

    public final String toString() {
        zzfqa zza2 = zzfqb.zza(this);
        zza2.zza(this.zzb);
        return zza2.toString();
    }
}
