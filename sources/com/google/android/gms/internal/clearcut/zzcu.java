package com.google.android.gms.internal.clearcut;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.Map;

final class zzcu<K> implements Iterator<Map.Entry<K, Object>>, j$.util.Iterator {
    private Iterator<Map.Entry<K, Object>> zzlm;

    public zzcu(Iterator<Map.Entry<K, Object>> it) {
        this.zzlm = it;
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public final boolean hasNext() {
        return this.zzlm.hasNext();
    }

    public final /* synthetic */ Object next() {
        Map.Entry next = this.zzlm.next();
        return next.getValue() instanceof zzcr ? new zzct(next) : next;
    }

    public final void remove() {
        this.zzlm.remove();
    }
}
