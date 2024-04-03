package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;

public final class zzca {
    public static final zzj<zzca> zza = zzbz.zza;
    @Nullable
    public Object zzb;
    @Nullable
    public Object zzc;
    public int zzd;
    public long zze;
    public long zzf;
    public boolean zzg;
    private zzd zzh = zzd.zza;

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzca.class.equals(obj.getClass())) {
            zzca zzca = (zzca) obj;
            if (!zzfn.zzP(this.zzb, zzca.zzb) || !zzfn.zzP(this.zzc, zzca.zzc) || this.zzd != zzca.zzd || this.zze != zzca.zze || this.zzg != zzca.zzg || !zzfn.zzP(this.zzh, zzca.zzh)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i11;
        Object obj = this.zzb;
        int i12 = 0;
        if (obj == null) {
            i11 = 0;
        } else {
            i11 = obj.hashCode();
        }
        int i13 = (i11 + 217) * 31;
        Object obj2 = this.zzc;
        if (obj2 != null) {
            i12 = obj2.hashCode();
        }
        int i14 = this.zzd;
        long j11 = this.zze;
        return ((((((((i13 + i12) * 31) + i14) * 31) + ((int) ((j11 >>> 32) ^ j11))) * 961) + (this.zzg ? 1 : 0)) * 31) + this.zzh.hashCode();
    }

    public final int zza(int i11) {
        return this.zzh.zza(i11).zzc;
    }

    public final int zzb(long j11) {
        return -1;
    }

    public final int zzc(long j11) {
        return -1;
    }

    public final int zzd(int i11) {
        return this.zzh.zza(i11).zza(-1);
    }

    public final int zze(int i11, int i12) {
        return this.zzh.zza(i11).zza(i12);
    }

    public final long zzf(int i11, int i12) {
        zzc zza2 = this.zzh.zza(i11);
        if (zza2.zzc != -1) {
            return zza2.zzf[i12];
        }
        return C.TIME_UNSET;
    }

    public final long zzg(int i11) {
        long j11 = this.zzh.zza(i11).zzb;
        return 0;
    }

    public final long zzh() {
        long j11 = this.zzh.zzc;
        return 0;
    }

    public final long zzi(int i11) {
        long j11 = this.zzh.zza(i11).zzg;
        return 0;
    }

    public final zzca zzj(@Nullable Object obj, @Nullable Object obj2, int i11, long j11, long j12, zzd zzd2, boolean z11) {
        this.zzb = obj;
        this.zzc = obj2;
        this.zzd = 0;
        this.zze = j11;
        this.zzf = 0;
        this.zzh = zzd2;
        this.zzg = z11;
        return this;
    }

    public final boolean zzk(int i11) {
        boolean z11 = this.zzh.zza(i11).zzh;
        return false;
    }
}
