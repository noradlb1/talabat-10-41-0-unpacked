package com.google.android.gms.internal.gtm;

final /* synthetic */ class zzcr implements Runnable {
    private final zzcq zzace;
    private final int zzacf;
    private final zzci zzacg;

    public zzcr(zzcq zzcq, int i11, zzci zzci) {
        this.zzace = zzcq;
        this.zzacf = i11;
        this.zzacg = zzci;
    }

    public final void run() {
        this.zzace.zza(this.zzacf, this.zzacg);
    }
}
