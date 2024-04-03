package com.google.android.gms.internal.measurement;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;

final class zzno implements Iterator, j$.util.Iterator {
    final Iterator zza;
    final /* synthetic */ zznp zzb;

    public zzno(zznp zznp) {
        this.zzb = zznp;
        this.zza = zznp.zza.iterator();
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

    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.zza.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
