package com.google.android.gms.internal.ads;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class zzamo implements ThreadFactory {
    private final ThreadFactory zza = Executors.defaultThreadFactory();
    private final AtomicInteger zzb = new AtomicInteger(1);

    public final Thread newThread(Runnable runnable) {
        Thread newThread = this.zza.newThread(runnable);
        int andIncrement = this.zzb.getAndIncrement();
        StringBuilder sb2 = new StringBuilder(16);
        sb2.append("gads-");
        sb2.append(andIncrement);
        newThread.setName(sb2.toString());
        return newThread;
    }
}
