package com.google.android.gms.internal.gtm;

import j$.util.concurrent.ConcurrentHashMap;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;

final class zzph {
    private final ConcurrentHashMap<zzpi, List<Throwable>> zzavl = new ConcurrentHashMap<>(16, 0.75f, 10);
    private final ReferenceQueue<Throwable> zzavm = new ReferenceQueue<>();

    public final List<Throwable> zza(Throwable th2, boolean z11) {
        Reference<? extends Throwable> poll = this.zzavm.poll();
        while (poll != null) {
            this.zzavl.remove(poll);
            poll = this.zzavm.poll();
        }
        return this.zzavl.get(new zzpi(th2, (ReferenceQueue<Throwable>) null));
    }
}
