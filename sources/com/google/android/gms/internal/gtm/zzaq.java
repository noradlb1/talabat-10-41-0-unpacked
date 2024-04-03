package com.google.android.gms.internal.gtm;

import java.lang.Thread;

final class zzaq implements Thread.UncaughtExceptionHandler {
    private final /* synthetic */ zzap zzwt;

    public zzaq(zzap zzap) {
        this.zzwt = zzap;
    }

    public final void uncaughtException(Thread thread, Throwable th2) {
        zzci zzdd = this.zzwt.zzdd();
        if (zzdd != null) {
            zzdd.zze("Job execution failed", th2);
        }
    }
}
