package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

public class zzbf {
    public final Object zza;
    public final int zzb;
    public final int zzc;
    public final long zzd;
    public final int zze;

    public zzbf(zzbf zzbf) {
        this.zza = zzbf.zza;
        this.zzb = zzbf.zzb;
        this.zzc = zzbf.zzc;
        this.zzd = zzbf.zzd;
        this.zze = zzbf.zze;
    }

    public zzbf(Object obj, int i11, int i12, long j11) {
        this(obj, i11, i12, j11, -1);
    }

    private zzbf(Object obj, int i11, int i12, long j11, int i13) {
        this.zza = obj;
        this.zzb = i11;
        this.zzc = i12;
        this.zzd = j11;
        this.zze = i13;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbf)) {
            return false;
        }
        zzbf zzbf = (zzbf) obj;
        if (this.zza.equals(zzbf.zza) && this.zzb == zzbf.zzb && this.zzc == zzbf.zzc && this.zzd == zzbf.zzd && this.zze == zzbf.zze) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((this.zza.hashCode() + 527) * 31) + this.zzb) * 31) + this.zzc) * 31) + ((int) this.zzd)) * 31) + this.zze;
    }

    public final zzbf zza(Object obj) {
        if (this.zza.equals(obj)) {
            return this;
        }
        return new zzbf(obj, this.zzb, this.zzc, this.zzd, this.zze);
    }

    public final boolean zzb() {
        return this.zzb != -1;
    }

    public zzbf(Object obj, long j11) {
        this(obj, -1, -1, -1, -1);
    }

    public zzbf(Object obj, long j11, int i11) {
        this(obj, -1, -1, j11, i11);
    }
}
