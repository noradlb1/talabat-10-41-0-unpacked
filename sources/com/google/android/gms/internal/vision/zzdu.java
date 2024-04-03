package com.google.android.gms.internal.vision;

import j$.util.concurrent.ConcurrentHashMap;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;

final class zzdu {
    private final ConcurrentHashMap<zzdx, List<Throwable>> zzme = new ConcurrentHashMap<>(16, 0.75f, 10);
    private final ReferenceQueue<Throwable> zzmf = new ReferenceQueue<>();

    public final List<Throwable> zza(Throwable th2, boolean z11) {
        Reference<? extends Throwable> poll = this.zzmf.poll();
        while (poll != null) {
            this.zzme.remove(poll);
            poll = this.zzmf.poll();
        }
        List<Throwable> list = this.zzme.get(new zzdx(th2, (ReferenceQueue<Throwable>) null));
        if (!z11 || list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> putIfAbsent = this.zzme.putIfAbsent(new zzdx(th2, this.zzmf), vector);
        if (putIfAbsent == null) {
            return vector;
        }
        return putIfAbsent;
    }
}
