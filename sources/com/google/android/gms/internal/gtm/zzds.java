package com.google.android.gms.internal.gtm;

final class zzds implements Runnable {
    private final /* synthetic */ zzdq zzanc;

    public zzds(zzdq zzdq) {
        this.zzanc = zzdq;
    }

    public final void run() {
        this.zzanc.zzamv.execute(new zzdw(this.zzanc, (zzdr) null));
    }
}
