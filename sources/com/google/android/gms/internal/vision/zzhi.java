package com.google.android.gms.internal.vision;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.Map;

final class zzhi<K> implements Iterator<Map.Entry<K, Object>>, j$.util.Iterator {
    private Iterator<Map.Entry<K, Object>> zzya;

    public zzhi(Iterator<Map.Entry<K, Object>> it) {
        this.zzya = it;
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public final boolean hasNext() {
        return this.zzya.hasNext();
    }

    public final /* synthetic */ Object next() {
        Map.Entry next = this.zzya.next();
        if (next.getValue() instanceof zzhd) {
            return new zzhf(next);
        }
        return next;
    }

    public final void remove() {
        this.zzya.remove();
    }
}
