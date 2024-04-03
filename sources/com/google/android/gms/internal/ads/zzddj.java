package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzt;

public final class zzddj implements zzdhm {
    private final Context zza;
    private final zzfef zzb;
    private final zzcjf zzc;
    private final zzg zzd;
    private final zzebb zze;

    public zzddj(Context context, zzfef zzfef, zzcjf zzcjf, zzg zzg, zzebb zzebb) {
        this.zza = context;
        this.zzb = zzfef;
        this.zzc = zzcjf;
        this.zzd = zzg;
        this.zze = zzebb;
    }

    public final void zzd(zzcdq zzcdq) {
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzcA)).booleanValue()) {
            zzt.zza().zzc(this.zza, this.zzc, this.zzb.zzf, this.zzd.zzg());
        }
        this.zze.zzq();
    }

    public final void zze(zzfdz zzfdz) {
    }
}
