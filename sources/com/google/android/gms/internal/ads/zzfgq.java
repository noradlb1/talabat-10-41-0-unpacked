package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class zzfgq implements ThreadFactory {
    private final AtomicInteger zza = new AtomicInteger(1);

    public final Thread newThread(Runnable runnable) {
        int andIncrement = this.zza.getAndIncrement();
        StringBuilder sb2 = new StringBuilder(25);
        sb2.append("AdWorker(NG) #");
        sb2.append(andIncrement);
        return new Thread(runnable, sb2.toString());
    }
}
