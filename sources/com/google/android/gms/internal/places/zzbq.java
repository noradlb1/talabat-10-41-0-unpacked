package com.google.android.gms.internal.places;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.Map;

final class zzbq<K> implements Iterator<Map.Entry<K, Object>>, j$.util.Iterator {
    private Iterator<Map.Entry<K, Object>> zzjx;

    public zzbq(Iterator<Map.Entry<K, Object>> it) {
        this.zzjx = it;
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public final boolean hasNext() {
        return this.zzjx.hasNext();
    }

    public final /* synthetic */ Object next() {
        Map.Entry next = this.zzjx.next();
        if (next.getValue() instanceof zzbl) {
            return new zzbn(next);
        }
        return next;
    }

    public final void remove() {
        this.zzjx.remove();
    }
}
