package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;

public final class zzego implements zzfif {
    private final zzegl zza;

    public zzego(zzegl zzegl) {
        this.zza = zzegl;
    }

    public final void zzb(zzfhy zzfhy, String str, Throwable th2) {
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzeE)).booleanValue() && zzfhy.RENDERER == zzfhy && this.zza.zzc() != 0) {
            this.zza.zze(zzt.zzA().elapsedRealtime() - this.zza.zzc());
        }
    }

    public final void zzbN(zzfhy zzfhy, String str) {
    }

    public final void zzbO(zzfhy zzfhy, String str) {
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzeE)).booleanValue() && zzfhy.RENDERER == zzfhy && this.zza.zzc() != 0) {
            this.zza.zze(zzt.zzA().elapsedRealtime() - this.zza.zzc());
        }
    }

    public final void zzc(zzfhy zzfhy, String str) {
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzeE)).booleanValue() && zzfhy.RENDERER == zzfhy) {
            this.zza.zzf(zzt.zzA().elapsedRealtime());
        }
    }
}
