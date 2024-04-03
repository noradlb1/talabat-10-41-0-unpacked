package com.google.android.gms.internal.places;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;

final class zzdv implements Iterator<String>, j$.util.Iterator {
    private Iterator<String> zzmk;
    private final /* synthetic */ zzdt zzml;

    public zzdv(zzdt zzdt) {
        this.zzml = zzdt;
        this.zzmk = zzdt.zzmj.iterator();
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public final boolean hasNext() {
        return this.zzmk.hasNext();
    }

    public final /* synthetic */ Object next() {
        return this.zzmk.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
