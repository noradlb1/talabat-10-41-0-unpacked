package com.google.android.gms.internal.ads;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import java.util.List;

final class zzif {
    private static final zzpz zzt = new zzpz(new Object());
    public final zzcd zza;
    public final zzpz zzb;
    public final long zzc;
    public final long zzd;
    public final int zze;
    @Nullable
    public final zzgg zzf;
    public final boolean zzg;
    public final zzch zzh;
    public final zzsw zzi;
    public final List<zzdd> zzj;
    public final zzpz zzk;
    public final boolean zzl;
    public final int zzm;
    public final zzbn zzn;
    public final boolean zzo;
    public final boolean zzp;
    public volatile long zzq;
    public volatile long zzr;
    public volatile long zzs;

    public zzif(zzcd zzcd, zzpz zzpz, long j11, long j12, int i11, @Nullable zzgg zzgg, boolean z11, zzch zzch, zzsw zzsw, List<zzdd> list, zzpz zzpz2, boolean z12, int i12, zzbn zzbn, long j13, long j14, long j15, boolean z13, boolean z14) {
        this.zza = zzcd;
        this.zzb = zzpz;
        this.zzc = j11;
        this.zzd = j12;
        this.zze = i11;
        this.zzf = zzgg;
        this.zzg = z11;
        this.zzh = zzch;
        this.zzi = zzsw;
        this.zzj = list;
        this.zzk = zzpz2;
        this.zzl = z12;
        this.zzm = i12;
        this.zzn = zzbn;
        this.zzq = j13;
        this.zzr = j14;
        this.zzs = j15;
        this.zzo = z13;
        this.zzp = z14;
    }

    public static zzif zzh(zzsw zzsw) {
        zzcd zzcd = zzcd.zza;
        zzpz zzpz = zzt;
        return new zzif(zzcd, zzpz, C.TIME_UNSET, 0, 1, (zzgg) null, false, zzch.zza, zzsw, zzfss.zzo(), zzpz, false, 0, zzbn.zza, 0, 0, 0, false, false);
    }

    public static zzpz zzi() {
        return zzt;
    }

    @CheckResult
    public final zzif zza(zzpz zzpz) {
        zzcd zzcd = this.zza;
        return new zzif(zzcd, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, zzpz, this.zzl, this.zzm, this.zzn, this.zzq, this.zzr, this.zzs, this.zzo, this.zzp);
    }

    @CheckResult
    public final zzif zzb(zzpz zzpz, long j11, long j12, long j13, long j14, zzch zzch, zzsw zzsw, List<zzdd> list) {
        long j15 = j11;
        zzch zzch2 = zzch;
        zzsw zzsw2 = zzsw;
        List<zzdd> list2 = list;
        zzcd zzcd = this.zza;
        return new zzif(zzcd, zzpz, j12, j13, this.zze, this.zzf, this.zzg, zzch2, zzsw2, list2, this.zzk, this.zzl, this.zzm, this.zzn, this.zzq, j14, j15, this.zzo, this.zzp);
    }

    @CheckResult
    public final zzif zzc(boolean z11) {
        zzcd zzcd = this.zza;
        return new zzif(zzcd, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzq, this.zzr, this.zzs, z11, this.zzp);
    }

    @CheckResult
    public final zzif zzd(boolean z11, int i11) {
        zzcd zzcd = this.zza;
        return new zzif(zzcd, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, z11, i11, this.zzn, this.zzq, this.zzr, this.zzs, this.zzo, this.zzp);
    }

    @CheckResult
    public final zzif zze(@Nullable zzgg zzgg) {
        zzcd zzcd = this.zza;
        return new zzif(zzcd, this.zzb, this.zzc, this.zzd, this.zze, zzgg, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzq, this.zzr, this.zzs, this.zzo, this.zzp);
    }

    @CheckResult
    public final zzif zzf(int i11) {
        zzcd zzcd = this.zza;
        return new zzif(zzcd, this.zzb, this.zzc, this.zzd, i11, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzq, this.zzr, this.zzs, this.zzo, this.zzp);
    }

    @CheckResult
    public final zzif zzg(zzcd zzcd) {
        return new zzif(zzcd, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzq, this.zzr, this.zzs, this.zzo, this.zzp);
    }
}
