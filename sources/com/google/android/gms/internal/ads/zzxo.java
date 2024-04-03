package com.google.android.gms.internal.ads;

public class zzxo implements zzxp {
    private final long zza;
    private final zzxn zzb;

    public zzxo(long j11, long j12) {
        this.zza = j11;
        zzxq zzxq = j12 == 0 ? zzxq.zza : new zzxq(0, j12);
        this.zzb = new zzxn(zzxq, zzxq);
    }

    public final long zze() {
        return this.zza;
    }

    public final zzxn zzg(long j11) {
        return this.zzb;
    }

    public final boolean zzh() {
        return false;
    }
}
