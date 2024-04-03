package com.google.android.recaptcha.internal;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.Map;

final class zzht implements Iterator, j$.util.Iterator {
    private final Iterator zza;

    public zzht(Iterator it) {
        this.zza = it;
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
        Map.Entry entry = (Map.Entry) this.zza.next();
        if (entry.getValue() instanceof zzhu) {
            return new zzhs(entry, (zzhr) null);
        }
        return entry;
    }

    public final void remove() {
        this.zza.remove();
    }
}
