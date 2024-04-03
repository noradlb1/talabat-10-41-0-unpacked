package com.google.android.gms.internal.ads;

final class zzaxq implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ zzaxu zzc;

    public zzaxq(zzaxu zzaxu, int i11, long j11) {
        this.zzc = zzaxu;
        this.zza = i11;
        this.zzb = j11;
    }

    public final void run() {
        this.zzc.zzb.zzl(this.zza, this.zzb);
    }
}
