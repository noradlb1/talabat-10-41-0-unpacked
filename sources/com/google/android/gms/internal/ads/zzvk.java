package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzvk implements Runnable {
    public final /* synthetic */ zzvo zza;
    public final /* synthetic */ Exception zzb;

    public /* synthetic */ zzvk(zzvo zzvo, Exception exc) {
        this.zza = zzvo;
        this.zzb = exc;
    }

    public final void run() {
        this.zza.zzo(this.zzb);
    }
}
