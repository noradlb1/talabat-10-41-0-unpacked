package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.ads.internal.util.zzf;
import com.google.android.gms.ads.internal.zzt;
import java.util.concurrent.Executor;

final class zzcjj implements Executor {
    private final Handler zza = new zzf(Looper.getMainLooper());

    public final void execute(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            try {
                runnable.run();
            } catch (Throwable th2) {
                zzt.zzp();
                com.google.android.gms.ads.internal.util.zzt.zzP(zzt.zzo().zzc(), th2);
                throw th2;
            }
        } else {
            this.zza.post(runnable);
        }
    }
}
