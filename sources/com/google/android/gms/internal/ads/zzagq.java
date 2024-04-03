package com.google.android.gms.internal.ads;

final class zzagq implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ zzags zzc;

    public zzagq(zzags zzags, String str, long j11) {
        this.zzc = zzags;
        this.zza = str;
        this.zzb = j11;
    }

    public final void run() {
        this.zzc.zza.zza(this.zza, this.zzb);
        this.zzc.zza.zzb(this.zzc.toString());
    }
}
