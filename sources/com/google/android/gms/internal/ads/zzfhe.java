package com.google.android.gms.internal.ads;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

public final class zzfhe implements zzgpr<ScheduledExecutorService> {
    private final zzgqe<ThreadFactory> zza;

    public zzfhe(zzgqe<ThreadFactory> zzgqe) {
        this.zza = zzgqe;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfpi.zza();
        ScheduledExecutorService unconfigurableScheduledExecutorService = Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1, this.zza.zzb()));
        zzgpz.zzb(unconfigurableScheduledExecutorService);
        return unconfigurableScheduledExecutorService;
    }
}
