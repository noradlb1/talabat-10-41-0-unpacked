package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

final class zzaq {
    final String zza;
    final String zzb;
    final long zzc;
    final long zzd;
    final long zze;
    final long zzf;
    final long zzg;
    final Long zzh;
    final Long zzi;
    final Long zzj;
    final Boolean zzk;

    public zzaq(String str, String str2, long j11, long j12, long j13, long j14, long j15, Long l11, Long l12, Long l13, Boolean bool) {
        boolean z11;
        boolean z12;
        boolean z13;
        long j16 = j11;
        long j17 = j12;
        long j18 = j13;
        long j19 = j15;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        boolean z14 = true;
        if (j16 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        if (j17 >= 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        Preconditions.checkArgument(z12);
        if (j18 >= 0) {
            z13 = true;
        } else {
            z13 = false;
        }
        Preconditions.checkArgument(z13);
        Preconditions.checkArgument(j19 < 0 ? false : z14);
        this.zza = str;
        this.zzb = str2;
        this.zzc = j16;
        this.zzd = j17;
        this.zze = j18;
        this.zzf = j14;
        this.zzg = j19;
        this.zzh = l11;
        this.zzi = l12;
        this.zzj = l13;
        this.zzk = bool;
    }

    public final zzaq zza(Long l11, Long l12, Boolean bool) {
        if (bool != null) {
            bool.booleanValue();
        }
        return new zzaq(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, l11, l12, bool);
    }

    public final zzaq zzb(long j11, long j12) {
        return new zzaq(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, j11, Long.valueOf(j12), this.zzi, this.zzj, this.zzk);
    }

    public final zzaq zzc(long j11) {
        return new zzaq(this.zza, this.zzb, this.zzc, this.zzd, this.zze, j11, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk);
    }
}
