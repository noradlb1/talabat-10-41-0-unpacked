package com.google.android.gms.internal.ads;

import java.lang.Thread;

final class zzccr implements Thread.UncaughtExceptionHandler {
    final /* synthetic */ Thread.UncaughtExceptionHandler zza;
    final /* synthetic */ zzcct zzb;

    public zzccr(zzcct zzcct, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.zzb = zzcct;
        this.zza = uncaughtExceptionHandler;
    }

    public final void uncaughtException(Thread thread, Throwable th2) {
        try {
            this.zzb.zzc(thread, th2);
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.zza;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th2);
            }
        } catch (Throwable th3) {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.zza;
            if (uncaughtExceptionHandler2 != null) {
                uncaughtExceptionHandler2.uncaughtException(thread, th2);
            }
            throw th3;
        }
    }
}
