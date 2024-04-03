package com.google.android.gms.internal.ads;

final class zzcku implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzckv zzb;

    public zzcku(zzckv zzckv, boolean z11) {
        this.zzb = zzckv;
        this.zza = z11;
    }

    public final void run() {
        this.zzb.zzI("windowVisibilityChanged", "isVisible", String.valueOf(this.zza));
    }
}
