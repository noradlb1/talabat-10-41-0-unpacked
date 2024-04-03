package com.google.android.gms.internal.ads;

final class zzys implements zzxp {
    final /* synthetic */ zzxp zza;
    final /* synthetic */ zzyt zzb;

    public zzys(zzyt zzyt, zzxp zzxp) {
        this.zzb = zzyt;
        this.zza = zzxp;
    }

    public final long zze() {
        return this.zza.zze();
    }

    public final zzxn zzg(long j11) {
        zzxn zzg = this.zza.zzg(j11);
        zzxq zzxq = zzg.zza;
        zzxq zzxq2 = new zzxq(zzxq.zzb, zzxq.zzc + this.zzb.zzb);
        zzxq zzxq3 = zzg.zzb;
        return new zzxn(zzxq2, new zzxq(zzxq3.zzb, zzxq3.zzc + this.zzb.zzb));
    }

    public final boolean zzh() {
        return this.zza.zzh();
    }
}
