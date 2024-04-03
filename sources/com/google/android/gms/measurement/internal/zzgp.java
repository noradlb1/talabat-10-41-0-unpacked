package com.google.android.gms.measurement.internal;

final class zzgp implements Runnable {
    final /* synthetic */ zzau zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzgv zzc;

    public zzgp(zzgv zzgv, zzau zzau, String str) {
        this.zzc = zzgv;
        this.zza = zzau;
        this.zzb = str;
    }

    public final void run() {
        this.zzc.zza.zzA();
        this.zzc.zza.zzF(this.zza, this.zzb);
    }
}
