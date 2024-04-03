package com.google.android.gms.internal.ads;

public final class zzwa implements zzxp {
    private final zzwd zza;
    private final long zzb;
    /* access modifiers changed from: private */
    public final long zzc;
    /* access modifiers changed from: private */
    public final long zzd;
    /* access modifiers changed from: private */
    public final long zze;
    /* access modifiers changed from: private */
    public final long zzf;

    public zzwa(zzwd zzwd, long j11, long j12, long j13, long j14, long j15, long j16) {
        this.zza = zzwd;
        this.zzb = j11;
        this.zzc = j13;
        this.zzd = j14;
        this.zze = j15;
        this.zzf = j16;
    }

    public final long zze() {
        return this.zzb;
    }

    public final long zzf(long j11) {
        return this.zza.zza(j11);
    }

    public final zzxn zzg(long j11) {
        zzxq zzxq = new zzxq(j11, zzwc.zzf(this.zza.zza(j11), 0, this.zzc, this.zzd, this.zze, this.zzf));
        return new zzxn(zzxq, zzxq);
    }

    public final boolean zzh() {
        return true;
    }
}
