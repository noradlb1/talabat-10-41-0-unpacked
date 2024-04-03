package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

public final class zzack {
    public final int zza;
    public final int zzb;
    public final long zzc;
    public final long zzd;
    public final long zze;
    public final zzab zzf;
    public final int zzg;
    @Nullable
    public final long[] zzh;
    @Nullable
    public final long[] zzi;
    public final int zzj;
    @Nullable
    private final zzacl[] zzk;

    public zzack(int i11, int i12, long j11, long j12, long j13, zzab zzab, int i13, @Nullable zzacl[] zzaclArr, int i14, @Nullable long[] jArr, @Nullable long[] jArr2) {
        this.zza = i11;
        this.zzb = i12;
        this.zzc = j11;
        this.zzd = j12;
        this.zze = j13;
        this.zzf = zzab;
        this.zzg = i13;
        this.zzk = zzaclArr;
        this.zzj = i14;
        this.zzh = jArr;
        this.zzi = jArr2;
    }

    @Nullable
    public final zzacl zza(int i11) {
        zzacl[] zzaclArr = this.zzk;
        if (zzaclArr == null) {
            return null;
        }
        return zzaclArr[i11];
    }
}
