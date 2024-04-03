package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzg;

public final class zzegj implements zzdgf, zzdeu {
    private static final Object zza = new Object();
    private static int zzb;
    private final zzg zzc;
    private final zzegs zzd;

    public zzegj(zzegs zzegs, zzg zzg) {
        this.zzd = zzegs;
        this.zzc = zzg;
    }

    private final void zzb(boolean z11) {
        int i11;
        int intValue;
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzeE)).booleanValue() && !this.zzc.zzL()) {
            Object obj = zza;
            synchronized (obj) {
                i11 = zzb;
                intValue = ((Integer) zzbgq.zzc().zzb(zzblj.zzeF)).intValue();
            }
            if (i11 < intValue) {
                this.zzd.zze(z11);
                synchronized (obj) {
                    zzb++;
                }
            }
        }
    }

    public final void zza(zzbew zzbew) {
        zzb(false);
    }

    public final void zzn() {
        zzb(true);
    }
}
