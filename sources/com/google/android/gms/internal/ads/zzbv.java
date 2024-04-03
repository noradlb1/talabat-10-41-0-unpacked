package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Arrays;

public final class zzbv {
    public static final zzj<zzbv> zza = zzbu.zza;
    @Nullable
    public final Object zzb;
    public final int zzc;
    @Nullable
    public final zzaz zzd;
    @Nullable
    public final Object zze;
    public final int zzf;
    public final long zzg;
    public final long zzh;
    public final int zzi;
    public final int zzj;

    public zzbv(@Nullable Object obj, int i11, @Nullable zzaz zzaz, @Nullable Object obj2, int i12, long j11, long j12, int i13, int i14) {
        this.zzb = obj;
        this.zzc = i11;
        this.zzd = zzaz;
        this.zze = obj2;
        this.zzf = i12;
        this.zzg = j11;
        this.zzh = j12;
        this.zzi = i13;
        this.zzj = i14;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzbv.class == obj.getClass()) {
            zzbv zzbv = (zzbv) obj;
            if (this.zzc == zzbv.zzc && this.zzf == zzbv.zzf && this.zzg == zzbv.zzg && this.zzh == zzbv.zzh && this.zzi == zzbv.zzi && this.zzj == zzbv.zzj && zzfqc.zza(this.zzb, zzbv.zzb) && zzfqc.zza(this.zze, zzbv.zze) && zzfqc.zza(this.zzd, zzbv.zzd)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzb, Integer.valueOf(this.zzc), this.zzd, this.zze, Integer.valueOf(this.zzf), Integer.valueOf(this.zzc), Long.valueOf(this.zzg), Long.valueOf(this.zzh), Integer.valueOf(this.zzi), Integer.valueOf(this.zzj)});
    }
}
