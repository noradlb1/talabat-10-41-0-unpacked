package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

public final class zzdbk {
    private final zzfdz zza;
    private final zzfdn zzb;
    private final String zzc;

    public zzdbk(zzfdz zzfdz, zzfdn zzfdn, @Nullable String str) {
        this.zza = zzfdz;
        this.zzb = zzfdn;
        this.zzc = str == null ? "com.google.ads.mediation.admob.AdMobAdapter" : str;
    }

    public final zzfdn zza() {
        return this.zzb;
    }

    public final zzfdq zzb() {
        return this.zza.zzb.zzb;
    }

    public final zzfdz zzc() {
        return this.zza;
    }

    public final String zzd() {
        return this.zzc;
    }
}
