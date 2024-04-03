package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;

public final class zzfkw {
    private static zzfkw zza;
    private float zzb = 0.0f;
    private final zzfko zzc;
    private final zzfkm zzd;
    private zzfkn zze;
    private zzfkp zzf;

    public zzfkw(zzfko zzfko, zzfkm zzfkm) {
        this.zzc = zzfko;
        this.zzd = zzfkm;
    }

    public static zzfkw zzb() {
        if (zza == null) {
            zza = new zzfkw(new zzfko(), new zzfkm());
        }
        return zza;
    }

    public final float zza() {
        return this.zzb;
    }

    public final void zzc(Context context) {
        this.zze = new zzfkn(new Handler(), context, new zzfkl(), this, (byte[]) null);
    }

    public final void zzd(float f11) {
        this.zzb = f11;
        if (this.zzf == null) {
            this.zzf = zzfkp.zza();
        }
        for (zzfke zzg : this.zzf.zzb()) {
            zzg.zzg().zzh(f11);
        }
    }

    public final void zze() {
        zzfkr.zza().zzg(this);
        zzfkr.zza().zzd();
        if (zzfkr.zza().zzf()) {
            zzfls.zzd().zzi();
        }
        this.zze.zza();
    }

    public final void zzf() {
        zzfls.zzd().zzj();
        zzfkr.zza().zze();
        this.zze.zzb();
    }
}
