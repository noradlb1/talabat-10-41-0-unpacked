package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzlo implements Runnable {
    public final /* synthetic */ zzls zza;
    public final /* synthetic */ Exception zzb;

    public /* synthetic */ zzlo(zzls zzls, Exception exc) {
        this.zza = zzls;
        this.zzb = exc;
    }

    public final void run() {
        this.zza.zzi(this.zzb);
    }
}
