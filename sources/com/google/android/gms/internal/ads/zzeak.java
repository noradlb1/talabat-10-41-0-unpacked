package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzeak implements zzdzy {
    /* access modifiers changed from: private */
    public final long zza;
    private final zzepf zzb;

    public zzeak(long j11, Context context, zzead zzead, zzcqm zzcqm, String str) {
        this.zza = j11;
        zzfbs zzw = zzcqm.zzw();
        zzw.zzc(context);
        zzw.zza(new zzbfi());
        zzw.zzb(str);
        zzepf zza2 = zzw.zzd().zza();
        this.zzb = zza2;
        zza2.zzD(new zzeaj(this, zzead));
    }

    public final void zza() {
        this.zzb.zzx();
    }

    public final void zzb(zzbfd zzbfd) {
        this.zzb.zzaa(zzbfd);
    }

    public final void zzc() {
        this.zzb.zzW(ObjectWrapper.wrap(null));
    }
}
