package com.google.android.gms.internal.consent_sdk;

import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

final class zzcg implements Executor {
    private final AtomicInteger zza = new AtomicInteger(1);
    private final ThreadPoolExecutor zzb;
    private WeakReference<Thread> zzc = new WeakReference<>((Object) null);

    public zzcg(String str) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), new zzcf(this, str));
        this.zzb = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    public final void execute(@NonNull Runnable runnable) {
        if (Thread.currentThread() == this.zzc.get()) {
            runnable.run();
        } else {
            this.zzb.execute(runnable);
        }
    }

    public final /* synthetic */ Thread zza(String str, Runnable runnable) {
        int andIncrement = this.zza.getAndIncrement();
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 13);
        sb2.append(str);
        sb2.append(" #");
        sb2.append(andIncrement);
        Thread thread = new Thread(runnable, sb2.toString());
        this.zzc = new WeakReference<>(thread);
        return thread;
    }
}
