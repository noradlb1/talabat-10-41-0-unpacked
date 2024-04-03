package com.google.android.gms.internal.auth;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;

final class zzhc implements Iterator, j$.util.Iterator {
    final Iterator zza;
    final /* synthetic */ zzhd zzb;

    public zzhc(zzhd zzhd) {
        this.zzb = zzhd;
        this.zza = zzhd.zza.iterator();
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
