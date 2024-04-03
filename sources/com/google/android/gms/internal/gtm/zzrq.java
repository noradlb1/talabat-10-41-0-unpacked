package com.google.android.gms.internal.gtm;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.Map;

final class zzrq<K> implements Iterator<Map.Entry<K, Object>>, j$.util.Iterator {
    private Iterator<Map.Entry<K, Object>> zzbca;

    public zzrq(Iterator<Map.Entry<K, Object>> it) {
        this.zzbca = it;
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public final boolean hasNext() {
        return this.zzbca.hasNext();
    }

    public final /* synthetic */ Object next() {
        Map.Entry next = this.zzbca.next();
        if (next.getValue() instanceof zzrn) {
            return new zzrp(next);
        }
        return next;
    }

    public final void remove() {
        this.zzbca.remove();
    }
}
