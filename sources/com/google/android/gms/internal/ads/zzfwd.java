package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import javax.annotation.CheckForNull;

final class zzfwd<V> extends zzfvp<Object, V> {
    /* access modifiers changed from: private */
    @CheckForNull
    public zzfwc<?> zza;

    public zzfwd(zzfsn<? extends zzfxa<?>> zzfsn, boolean z11, Executor executor, Callable<V> callable) {
        super(zzfsn, z11, false);
        this.zza = new zzfwb(this, callable, executor);
        zzx();
    }

    public final void zzA(int i11) {
        super.zzA(i11);
        if (i11 == 1) {
            this.zza = null;
        }
    }

    public final void zzb(int i11, @CheckForNull Object obj) {
    }

    public final void zzp() {
        zzfwc<?> zzfwc = this.zza;
        if (zzfwc != null) {
            zzfwc.zzh();
        }
    }

    public final void zzw() {
        zzfwc<?> zzfwc = this.zza;
        if (zzfwc != null) {
            zzfwc.zzf();
        }
    }
}
