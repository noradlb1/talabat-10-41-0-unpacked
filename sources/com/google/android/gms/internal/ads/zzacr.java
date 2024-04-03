package com.google.android.gms.internal.ads;

final class zzacr implements zzacx {
    private final zzxd zza;
    private final zzxc zzb;
    private long zzc = -1;
    private long zzd = -1;

    public zzacr(zzxd zzxd, zzxc zzxc) {
        this.zza = zzxd;
        this.zzb = zzxc;
    }

    public final void zza(long j11) {
        this.zzc = j11;
    }

    public final long zzd(zzwq zzwq) {
        long j11 = this.zzd;
        if (j11 < 0) {
            return -1;
        }
        this.zzd = -1;
        return -(j11 + 2);
    }

    public final zzxp zze() {
        zzdy.zzf(this.zzc != -1);
        return new zzxb(this.zza, this.zzc);
    }

    public final void zzg(long j11) {
        long[] jArr = this.zzb.zza;
        this.zzd = jArr[zzfn.zzd(jArr, j11, true, true)];
    }
}
