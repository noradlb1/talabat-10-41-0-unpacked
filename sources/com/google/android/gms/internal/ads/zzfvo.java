package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzfvo implements Runnable {
    public final /* synthetic */ zzfvp zza;
    public final /* synthetic */ zzfxa zzb;
    public final /* synthetic */ int zzc;

    public /* synthetic */ zzfvo(zzfvp zzfvp, zzfxa zzfxa, int i11) {
        this.zza = zzfvp;
        this.zzb = zzfxa;
        this.zzc = i11;
    }

    public final void run() {
        this.zza.zzy(this.zzb, this.zzc);
    }
}
