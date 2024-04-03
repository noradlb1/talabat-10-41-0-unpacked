package com.google.android.gms.internal.places;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class zzdd implements Iterator, j$.util.Iterator {
    private int pos;
    private Iterator zzlz;
    private final /* synthetic */ zzdb zzma;

    private zzdd(zzdb zzdb) {
        this.zzma = zzdb;
        this.pos = zzdb.zzlq.size();
    }

    private final Iterator zzde() {
        if (this.zzlz == null) {
            this.zzlz = this.zzma.zzlt.entrySet().iterator();
        }
        return this.zzlz;
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public final boolean hasNext() {
        int i11 = this.pos;
        return (i11 > 0 && i11 <= this.zzma.zzlq.size()) || zzde().hasNext();
    }

    public final /* synthetic */ Object next() {
        if (zzde().hasNext()) {
            return (Map.Entry) zzde().next();
        }
        List zzc = this.zzma.zzlq;
        int i11 = this.pos - 1;
        this.pos = i11;
        return (Map.Entry) zzc.get(i11);
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ zzdd(zzdb zzdb, zzde zzde) {
        this(zzdb);
    }
}
