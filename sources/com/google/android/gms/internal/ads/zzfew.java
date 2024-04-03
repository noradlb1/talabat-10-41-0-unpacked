package com.google.android.gms.internal.ads;

import java.util.Deque;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingDeque;
import javax.annotation.concurrent.GuardedBy;

public final class zzfew<T> {
    @GuardedBy("this")
    private final Deque<zzfxa<T>> zza = new LinkedBlockingDeque();
    private final Callable<T> zzb;
    private final zzfxb zzc;

    public zzfew(Callable<T> callable, zzfxb zzfxb) {
        this.zzb = callable;
        this.zzc = zzfxb;
    }

    public final synchronized zzfxa<T> zza() {
        zzc(1);
        return this.zza.poll();
    }

    public final synchronized void zzb(zzfxa<T> zzfxa) {
        this.zza.addFirst(zzfxa);
    }

    public final synchronized void zzc(int i11) {
        int size = i11 - this.zza.size();
        for (int i12 = 0; i12 < size; i12++) {
            this.zza.add(this.zzc.zzb(this.zzb));
        }
    }
}
