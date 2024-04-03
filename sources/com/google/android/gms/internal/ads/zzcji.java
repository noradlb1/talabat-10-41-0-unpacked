package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class zzcji implements ThreadFactory {
    final /* synthetic */ String zza;
    private final AtomicInteger zzb = new AtomicInteger(1);

    public zzcji(String str) {
        this.zza = str;
    }

    public final Thread newThread(Runnable runnable) {
        String str = this.zza;
        int andIncrement = this.zzb.getAndIncrement();
        StringBuilder sb2 = new StringBuilder(str.length() + 23);
        sb2.append("AdWorker(");
        sb2.append(str);
        sb2.append(") #");
        sb2.append(andIncrement);
        return new Thread(runnable, sb2.toString());
    }
}
