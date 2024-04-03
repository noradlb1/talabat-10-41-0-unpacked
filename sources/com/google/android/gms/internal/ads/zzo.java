package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

public final class zzo {
    public static final zzo zza = new zzo(0, 0, 0);
    public static final zzj<zzo> zzb = zzn.zza;
    public final int zzc = 0;
    public final int zzd;
    public final int zze;

    public zzo(int i11, int i12, int i13) {
        this.zzd = i12;
        this.zze = i13;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzo)) {
            return false;
        }
        zzo zzo = (zzo) obj;
        int i11 = zzo.zzc;
        if (this.zzd == zzo.zzd && this.zze == zzo.zze) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((this.zzd + 16337) * 31) + this.zze;
    }
}
