package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

public final class zzfz {
    public final String zza;
    public final zzab zzb;
    public final zzab zzc;
    public final int zzd;
    public final int zze;

    public zzfz(String str, zzab zzab, zzab zzab2, int i11, int i12) {
        boolean z11 = true;
        if (i11 != 0) {
            if (i12 == 0) {
                i12 = 0;
            } else {
                z11 = false;
            }
        }
        zzdy.zzd(z11);
        zzdy.zzc(str);
        this.zza = str;
        zzab.getClass();
        this.zzb = zzab;
        zzab2.getClass();
        this.zzc = zzab2;
        this.zzd = i11;
        this.zze = i12;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzfz.class == obj.getClass()) {
            zzfz zzfz = (zzfz) obj;
            if (this.zzd != zzfz.zzd || this.zze != zzfz.zze || !this.zza.equals(zzfz.zza) || !this.zzb.equals(zzfz.zzb) || !this.zzc.equals(zzfz.zzc)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((this.zzd + 527) * 31) + this.zze) * 31) + this.zza.hashCode()) * 31) + this.zzb.hashCode()) * 31) + this.zzc.hashCode();
    }
}
