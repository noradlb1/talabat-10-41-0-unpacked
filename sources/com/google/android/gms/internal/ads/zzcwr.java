package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzcwr implements Runnable {
    public final /* synthetic */ zzcwu zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ int zzc;

    public /* synthetic */ zzcwr(zzcwu zzcwu, int i11, int i12) {
        this.zza = zzcwu;
        this.zzb = i11;
        this.zzc = i12;
    }

    public final void run() {
        this.zza.zzi(this.zzb, this.zzc);
    }
}
