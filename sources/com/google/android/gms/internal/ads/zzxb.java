package com.google.android.gms.internal.ads;

public final class zzxb implements zzxp {
    private final zzxd zza;
    private final long zzb;

    public zzxb(zzxd zzxd, long j11) {
        this.zza = zzxd;
        this.zzb = j11;
    }

    private final zzxq zza(long j11, long j12) {
        return new zzxq((j11 * 1000000) / ((long) this.zza.zze), this.zzb + j12);
    }

    public final long zze() {
        return this.zza.zza();
    }

    public final zzxn zzg(long j11) {
        long j12;
        zzdy.zzb(this.zza.zzk);
        zzxd zzxd = this.zza;
        zzxc zzxc = zzxd.zzk;
        long[] jArr = zzxc.zza;
        long[] jArr2 = zzxc.zzb;
        int zzd = zzfn.zzd(jArr, zzxd.zzb(j11), true, false);
        long j13 = 0;
        if (zzd == -1) {
            j12 = 0;
        } else {
            j12 = jArr[zzd];
        }
        if (zzd != -1) {
            j13 = jArr2[zzd];
        }
        zzxq zza2 = zza(j12, j13);
        if (zza2.zzb == j11 || zzd == jArr.length - 1) {
            return new zzxn(zza2, zza2);
        }
        int i11 = zzd + 1;
        return new zzxn(zza2, zza(jArr[i11], jArr2[i11]));
    }

    public final boolean zzh() {
        return true;
    }
}
