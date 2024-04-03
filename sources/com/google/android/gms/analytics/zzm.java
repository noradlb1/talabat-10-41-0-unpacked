package com.google.android.gms.analytics;

import android.util.Log;
import com.google.android.gms.analytics.zzk;
import java.lang.Thread;
import java.util.concurrent.FutureTask;

final class zzm extends FutureTask {
    private final /* synthetic */ zzk.zza zzsy;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzm(zzk.zza zza, Runnable runnable, Object obj) {
        super(runnable, obj);
        this.zzsy = zza;
    }

    public final void setException(Throwable th2) {
        Thread.UncaughtExceptionHandler zzb = zzk.this.zzsv;
        if (zzb != null) {
            zzb.uncaughtException(Thread.currentThread(), th2);
        } else if (Log.isLoggable("GAv4", 6)) {
            String valueOf = String.valueOf(th2);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 37);
            sb2.append("MeasurementExecutor: job failed with ");
            sb2.append(valueOf);
            Log.e("GAv4", sb2.toString());
        }
        super.setException(th2);
    }
}
