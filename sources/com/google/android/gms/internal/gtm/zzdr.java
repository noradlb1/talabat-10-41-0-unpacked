package com.google.android.gms.internal.gtm;

import android.support.annotation.WorkerThread;

final class zzdr implements Runnable {
    private final /* synthetic */ zzdq zzanc;

    public zzdr(zzdq zzdq) {
        this.zzanc = zzdq;
    }

    @WorkerThread
    public final void run() {
        if (this.zzanc.state == 2) {
            this.zzanc.zzamz.dispatch();
        }
    }
}
