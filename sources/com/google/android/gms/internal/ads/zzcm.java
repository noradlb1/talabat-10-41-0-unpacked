package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

public final class zzcm {
    public static final zzcm zza = new zzcm(zzftc.zzl());
    public static final zzj<zzcm> zzb = zzcl.zza;
    public final zzftc<Integer> zzc;

    public zzcm(zzftc<Integer> zzftc) {
        this.zzc = zzftc;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzcm.class != obj.getClass()) {
            return false;
        }
        return this.zzc.equals(((zzcm) obj).zzc);
    }

    public final int hashCode() {
        return this.zzc.hashCode();
    }
}
