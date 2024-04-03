package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import java.io.IOException;

final class zzql implements zzpy, zzpx {
    /* access modifiers changed from: private */
    public final zzpy zza;
    private final long zzb;
    private zzpx zzc;

    public zzql(zzpy zzpy, long j11) {
        this.zza = zzpy;
        this.zzb = j11;
    }

    public final long zza(long j11, zzio zzio) {
        return this.zza.zza(j11 - this.zzb, zzio) + this.zzb;
    }

    public final long zzb() {
        long zzb2 = this.zza.zzb();
        if (zzb2 == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return zzb2 + this.zzb;
    }

    public final long zzc() {
        long zzc2 = this.zza.zzc();
        if (zzc2 == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return zzc2 + this.zzb;
    }

    public final long zzd() {
        long zzd = this.zza.zzd();
        return zzd == C.TIME_UNSET ? C.TIME_UNSET : zzd + this.zzb;
    }

    public final long zze(long j11) {
        return this.zza.zze(j11 - this.zzb) + this.zzb;
    }

    public final zzch zzf() {
        return this.zza.zzf();
    }

    public final /* bridge */ /* synthetic */ void zzg(zzrp zzrp) {
        zzpy zzpy = (zzpy) zzrp;
        zzpx zzpx = this.zzc;
        zzpx.getClass();
        zzpx.zzg(this);
    }

    public final void zzh(long j11, boolean z11) {
        this.zza.zzh(j11 - this.zzb, false);
    }

    public final void zzi(zzpy zzpy) {
        zzpx zzpx = this.zzc;
        zzpx.getClass();
        zzpx.zzi(this);
    }

    public final void zzj() throws IOException {
        this.zza.zzj();
    }

    public final void zzk(zzpx zzpx, long j11) {
        this.zzc = zzpx;
        this.zza.zzk(this, j11 - this.zzb);
    }

    public final void zzl(long j11) {
        this.zza.zzl(j11 - this.zzb);
    }

    public final boolean zzn(long j11) {
        return this.zza.zzn(j11 - this.zzb);
    }

    public final boolean zzo() {
        return this.zza.zzo();
    }

    public final long zzq(zzsb[] zzsbArr, boolean[] zArr, zzrn[] zzrnArr, boolean[] zArr2, long j11) {
        zzrn[] zzrnArr2 = zzrnArr;
        zzrn[] zzrnArr3 = new zzrn[zzrnArr2.length];
        int i11 = 0;
        while (true) {
            zzrn zzrn = null;
            if (i11 >= zzrnArr2.length) {
                break;
            }
            zzqm zzqm = (zzqm) zzrnArr2[i11];
            if (zzqm != null) {
                zzrn = zzqm.zzc();
            }
            zzrnArr3[i11] = zzrn;
            i11++;
        }
        long zzq = this.zza.zzq(zzsbArr, zArr, zzrnArr3, zArr2, j11 - this.zzb);
        for (int i12 = 0; i12 < zzrnArr2.length; i12++) {
            zzrn zzrn2 = zzrnArr3[i12];
            if (zzrn2 == null) {
                zzrnArr2[i12] = null;
            } else {
                zzrn zzrn3 = zzrnArr2[i12];
                if (zzrn3 == null || ((zzqm) zzrn3).zzc() != zzrn2) {
                    zzrnArr2[i12] = new zzqm(zzrn2, this.zzb);
                }
            }
        }
        return zzq + this.zzb;
    }
}
