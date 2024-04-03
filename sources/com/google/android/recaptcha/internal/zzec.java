package com.google.android.recaptcha.internal;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;

final class zzec implements Iterator, j$.util.Iterator {
    boolean zza = true;
    final /* synthetic */ Iterator zzb;

    public zzec(zzed zzed, Iterator it) {
        this.zzb = it;
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public final boolean hasNext() {
        return this.zzb.hasNext();
    }

    public final Object next() {
        Object next = this.zzb.next();
        this.zza = false;
        return next;
    }

    public final void remove() {
        zzdr.zze(!this.zza, "no calls to next() since the last call to remove()");
        this.zzb.remove();
    }
}
