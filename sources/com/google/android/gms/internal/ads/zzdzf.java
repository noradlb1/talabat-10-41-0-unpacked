package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzdzf implements Runnable {
    public final /* synthetic */ zzdzg zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzdzf(zzdzg zzdzg, String str) {
        this.zza = zzdzg;
        this.zzb = str;
    }

    public final void run() {
        zzdzg zzdzg = this.zza;
        zzdzg.zzd.zza(this.zzb);
    }
}
