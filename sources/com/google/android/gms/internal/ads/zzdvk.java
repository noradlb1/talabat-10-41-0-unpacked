package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

public final class zzdvk implements zzbsi {
    private final zzdfy zza;
    @Nullable
    private final zzces zzb;
    private final String zzc;
    private final String zzd;

    public zzdvk(zzdfy zzdfy, zzfdn zzfdn) {
        this.zza = zzdfy;
        this.zzb = zzfdn.zzm;
        this.zzc = zzfdn.zzk;
        this.zzd = zzfdn.zzl;
    }

    @ParametersAreNonnullByDefault
    public final void zza(zzces zzces) {
        int i11;
        String str;
        zzces zzces2 = this.zzb;
        if (zzces2 != null) {
            zzces = zzces2;
        }
        if (zzces != null) {
            str = zzces.zza;
            i11 = zzces.zzb;
        } else {
            str = "";
            i11 = 1;
        }
        this.zza.zzd(new zzced(str, i11), this.zzc, this.zzd);
    }

    public final void zzb() {
        this.zza.zze();
    }

    public final void zzc() {
        this.zza.zzf();
    }
}
