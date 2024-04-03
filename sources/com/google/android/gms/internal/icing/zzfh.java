package com.google.android.gms.internal.icing;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;

final class zzfh implements Iterator<String>, j$.util.Iterator {
    final Iterator<String> zza;
    final /* synthetic */ zzfi zzb;

    public zzfh(zzfi zzfi) {
        this.zzb = zzfi;
        this.zza = zzfi.zza.iterator();
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
        return this.zza.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
