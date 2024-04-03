package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class zzche implements ThreadFactory {
    private final AtomicInteger zza = new AtomicInteger(1);

    public zzche(zzchh zzchh) {
    }

    public final Thread newThread(@NonNull Runnable runnable) {
        int andIncrement = this.zza.getAndIncrement();
        StringBuilder sb2 = new StringBuilder(42);
        sb2.append("AdWorker(SCION_TASK_EXECUTOR) #");
        sb2.append(andIncrement);
        return new Thread(runnable, sb2.toString());
    }
}
