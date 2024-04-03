package com.google.android.gms.internal.ads;

final class zzaxr implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ int zzc;
    final /* synthetic */ float zzd;
    final /* synthetic */ zzaxu zze;

    public zzaxr(zzaxu zzaxu, int i11, int i12, int i13, float f11) {
        this.zze = zzaxu;
        this.zza = i11;
        this.zzb = i12;
        this.zzc = i13;
        this.zzd = f11;
    }

    public final void run() {
        this.zze.zzb.zzo(this.zza, this.zzb, this.zzc, this.zzd);
    }
}
