package com.google.android.gms.measurement.internal;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;

final class zzar implements Iterator, j$.util.Iterator {
    final Iterator zza;
    final /* synthetic */ zzas zzb;

    public zzar(zzas zzas) {
        this.zzb = zzas;
        this.zza = zzas.zza.keySet().iterator();
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }

    /* renamed from: zza */
    public final String next() {
        return (String) this.zza.next();
    }
}
