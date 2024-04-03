package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

public interface zzfxb extends ExecutorService {
    zzfxa<?> zza(Runnable runnable);

    <T> zzfxa<T> zzb(Callable<T> callable);
}
