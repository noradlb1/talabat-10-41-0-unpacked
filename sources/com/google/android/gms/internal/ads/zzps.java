package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import java.io.IOException;

public final class zzps implements zzpy, zzpx {
    public final zzpz zza;
    private final long zzb;
    private zzqb zzc;
    private zzpy zzd;
    @Nullable
    private zzpx zze;
    private long zzf = C.TIME_UNSET;
    private final zztk zzg;

    public zzps(zzpz zzpz, zztk zztk, long j11, byte[] bArr) {
        this.zza = zzpz;
        this.zzg = zztk;
        this.zzb = j11;
    }

    private final long zzv(long j11) {
        long j12 = this.zzf;
        return j12 != C.TIME_UNSET ? j12 : j11;
    }

    public final long zza(long j11, zzio zzio) {
        zzpy zzpy = this.zzd;
        int i11 = zzfn.zza;
        return zzpy.zza(j11, zzio);
    }

    public final long zzb() {
        zzpy zzpy = this.zzd;
        int i11 = zzfn.zza;
        return zzpy.zzb();
    }

    public final long zzc() {
        zzpy zzpy = this.zzd;
        int i11 = zzfn.zza;
        return zzpy.zzc();
    }

    public final long zzd() {
        zzpy zzpy = this.zzd;
        int i11 = zzfn.zza;
        return zzpy.zzd();
    }

    public final long zze(long j11) {
        zzpy zzpy = this.zzd;
        int i11 = zzfn.zza;
        return zzpy.zze(j11);
    }

    public final zzch zzf() {
        zzpy zzpy = this.zzd;
        int i11 = zzfn.zza;
        return zzpy.zzf();
    }

    public final /* bridge */ /* synthetic */ void zzg(zzrp zzrp) {
        zzpy zzpy = (zzpy) zzrp;
        zzpx zzpx = this.zze;
        int i11 = zzfn.zza;
        zzpx.zzg(this);
    }

    public final void zzh(long j11, boolean z11) {
        zzpy zzpy = this.zzd;
        int i11 = zzfn.zza;
        zzpy.zzh(j11, false);
    }

    public final void zzi(zzpy zzpy) {
        zzpx zzpx = this.zze;
        int i11 = zzfn.zza;
        zzpx.zzi(this);
    }

    public final void zzj() throws IOException {
        try {
            zzpy zzpy = this.zzd;
            if (zzpy != null) {
                zzpy.zzj();
                return;
            }
            zzqb zzqb = this.zzc;
            if (zzqb != null) {
                zzqb.zzv();
            }
        } catch (IOException e11) {
            throw e11;
        }
    }

    public final void zzk(zzpx zzpx, long j11) {
        this.zze = zzpx;
        zzpy zzpy = this.zzd;
        if (zzpy != null) {
            zzpy.zzk(this, zzv(this.zzb));
        }
    }

    public final void zzl(long j11) {
        zzpy zzpy = this.zzd;
        int i11 = zzfn.zza;
        zzpy.zzl(j11);
    }

    public final long zzm() {
        return this.zzf;
    }

    public final boolean zzn(long j11) {
        zzpy zzpy = this.zzd;
        return zzpy != null && zzpy.zzn(j11);
    }

    public final boolean zzo() {
        zzpy zzpy = this.zzd;
        return zzpy != null && zzpy.zzo();
    }

    public final long zzp() {
        return this.zzb;
    }

    public final long zzq(zzsb[] zzsbArr, boolean[] zArr, zzrn[] zzrnArr, boolean[] zArr2, long j11) {
        long j12;
        long j13 = this.zzf;
        if (j13 == C.TIME_UNSET || j11 != this.zzb) {
            j12 = j11;
        } else {
            this.zzf = C.TIME_UNSET;
            j12 = j13;
        }
        zzpy zzpy = this.zzd;
        int i11 = zzfn.zza;
        return zzpy.zzq(zzsbArr, zArr, zzrnArr, zArr2, j12);
    }

    public final void zzr(zzpz zzpz) {
        long zzv = zzv(this.zzb);
        zzqb zzqb = this.zzc;
        zzqb.getClass();
        zzpy zzC = zzqb.zzC(zzpz, this.zzg, zzv);
        this.zzd = zzC;
        if (this.zze != null) {
            zzC.zzk(this, zzv);
        }
    }

    public final void zzs(long j11) {
        this.zzf = j11;
    }

    public final void zzt() {
        zzpy zzpy = this.zzd;
        if (zzpy != null) {
            zzqb zzqb = this.zzc;
            zzqb.getClass();
            zzqb.zzA(zzpy);
        }
    }

    public final void zzu(zzqb zzqb) {
        zzdy.zzf(this.zzc == null);
        this.zzc = zzqb;
    }
}
