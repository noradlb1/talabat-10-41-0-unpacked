package com.google.android.recaptcha.internal;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;

final class zzka implements Iterator, j$.util.Iterator {
    final Iterator zza;
    final /* synthetic */ zzkb zzb;

    public zzka(zzkb zzkb) {
        this.zzb = zzkb;
        this.zza = zzkb.zza.iterator();
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
