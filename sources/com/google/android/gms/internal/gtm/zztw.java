package com.google.android.gms.internal.gtm;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;

final class zztw implements Iterator<String>, j$.util.Iterator {
    private final /* synthetic */ zztu zzber;
    private Iterator<String> zzbes;

    public zztw(zztu zztu) {
        this.zzber = zztu;
        this.zzbes = zztu.zzbeo.iterator();
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public final boolean hasNext() {
        return this.zzbes.hasNext();
    }

    public final /* synthetic */ Object next() {
        return this.zzbes.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
