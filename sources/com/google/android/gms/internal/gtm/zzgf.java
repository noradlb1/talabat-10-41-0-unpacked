package com.google.android.gms.internal.gtm;

final class zzgf implements Runnable {
    final /* synthetic */ zzfy zzaqb;

    public zzgf(zzfy zzfy) {
        this.zzaqb = zzfy;
    }

    public final void run() {
        this.zzaqb.zzamv.execute(new zzgg(this));
    }
}
