package com.google.android.gms.internal.gtm;

final class zzct implements zzbw {
    private final /* synthetic */ Runnable zzacj;
    private final /* synthetic */ zzcq zzack;

    public zzct(zzcq zzcq, Runnable runnable) {
        this.zzack = zzcq;
        this.zzacj = runnable;
    }

    public final void zza(Throwable th2) {
        this.zzack.handler.post(this.zzacj);
    }
}
