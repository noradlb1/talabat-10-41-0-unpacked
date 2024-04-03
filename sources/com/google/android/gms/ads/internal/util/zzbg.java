package com.google.android.gms.ads.internal.util;

import com.google.android.gms.common.internal.Objects;

public final class zzbg {
    public final String zza;
    public final double zzb;
    public final double zzc;
    public final double zzd;
    public final int zze;

    public zzbg(String str, double d11, double d12, double d13, int i11) {
        this.zza = str;
        this.zzc = d11;
        this.zzb = d12;
        this.zzd = d13;
        this.zze = i11;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbg)) {
            return false;
        }
        zzbg zzbg = (zzbg) obj;
        if (Objects.equal(this.zza, zzbg.zza) && this.zzb == zzbg.zzb && this.zzc == zzbg.zzc && this.zze == zzbg.zze && Double.compare(this.zzd, zzbg.zzd) == 0) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, Double.valueOf(this.zzb), Double.valueOf(this.zzc), Double.valueOf(this.zzd), Integer.valueOf(this.zze));
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("name", this.zza).add("minBound", Double.valueOf(this.zzc)).add("maxBound", Double.valueOf(this.zzb)).add("percent", Double.valueOf(this.zzd)).add("count", Integer.valueOf(this.zze)).toString();
    }
}
