package com.google.android.gms.measurement.internal;

final class zzgc implements Runnable {
    final /* synthetic */ zzhi zza;
    final /* synthetic */ zzgd zzb;

    public zzgc(zzgd zzgd, zzhi zzhi) {
        this.zzb = zzgd;
        this.zza = zzhi;
    }

    public final void run() {
        zzgd.zzA(this.zzb, this.zza);
        this.zzb.zzH(this.zza.zzg);
    }
}
