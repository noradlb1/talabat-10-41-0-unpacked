package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicInteger;

@Deprecated
public class zzcjy<T> {
    private final zzcjr<T> zza;
    /* access modifiers changed from: private */
    public final AtomicInteger zzb = new AtomicInteger(0);

    public zzcjy() {
        zzcjr<T> zzcjr = new zzcjr<>();
        this.zza = zzcjr;
        zzfwq.zzr(zzcjr, new zzcjw(this), zzcjm.zzf);
    }

    @Deprecated
    public final int zze() {
        return this.zzb.get();
    }

    @Deprecated
    public final void zzg() {
        this.zza.zze(new Exception());
    }

    @Deprecated
    public final void zzh(T t11) {
        this.zza.zzd(t11);
    }

    @Deprecated
    public final void zzi(zzcjv<T> zzcjv, zzcjt zzcjt) {
        zzfwq.zzr(this.zza, new zzcjx(this, zzcjv, zzcjt), zzcjm.zzf);
    }
}
