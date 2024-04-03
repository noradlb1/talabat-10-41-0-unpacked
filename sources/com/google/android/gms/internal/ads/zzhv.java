package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

final class zzhv {
    public final zzpz zza;
    public final long zzb;
    public final long zzc;
    public final long zzd;
    public final long zze;
    public final boolean zzf;
    public final boolean zzg;
    public final boolean zzh;
    public final boolean zzi;

    public zzhv(zzpz zzpz, long j11, long j12, long j13, long j14, boolean z11, boolean z12, boolean z13, boolean z14) {
        boolean z15;
        boolean z16 = true;
        if (!z14 || z12) {
            z15 = true;
        } else {
            z15 = false;
        }
        zzdy.zzd(z15);
        if (z13 && !z12) {
            z16 = false;
        }
        zzdy.zzd(z16);
        this.zza = zzpz;
        this.zzb = j11;
        this.zzc = j12;
        this.zzd = j13;
        this.zze = j14;
        this.zzf = false;
        this.zzg = z12;
        this.zzh = z13;
        this.zzi = z14;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzhv.class == obj.getClass()) {
            zzhv zzhv = (zzhv) obj;
            if (this.zzb == zzhv.zzb && this.zzc == zzhv.zzc && this.zzd == zzhv.zzd && this.zze == zzhv.zze && this.zzg == zzhv.zzg && this.zzh == zzhv.zzh && this.zzi == zzhv.zzi && zzfn.zzP(this.zza, zzhv.zza)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((((((((this.zza.hashCode() + 527) * 31) + ((int) this.zzb)) * 31) + ((int) this.zzc)) * 31) + ((int) this.zzd)) * 31) + ((int) this.zze)) * 961) + (this.zzg ? 1 : 0)) * 31) + (this.zzh ? 1 : 0)) * 31) + (this.zzi ? 1 : 0);
    }

    public final zzhv zza(long j11) {
        if (j11 == this.zzc) {
            return this;
        }
        return new zzhv(this.zza, this.zzb, j11, this.zzd, this.zze, false, this.zzg, this.zzh, this.zzi);
    }

    public final zzhv zzb(long j11) {
        if (j11 == this.zzb) {
            return this;
        }
        return new zzhv(this.zza, j11, this.zzc, this.zzd, this.zze, false, this.zzg, this.zzh, this.zzi);
    }
}
