package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzln implements Runnable {
    public final /* synthetic */ zzls zza;
    public final /* synthetic */ Exception zzb;

    public /* synthetic */ zzln(zzls zzls, Exception exc) {
        this.zza = zzls;
        this.zzb = exc;
    }

    public final void run() {
        this.zza.zzh(this.zzb);
    }
}
