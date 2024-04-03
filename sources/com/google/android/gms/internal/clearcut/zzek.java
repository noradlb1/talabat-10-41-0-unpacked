package com.google.android.gms.internal.clearcut;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class zzek implements Iterator, j$.util.Iterator {
    private int pos;
    private Iterator zzor;
    private final /* synthetic */ zzei zzos;

    private zzek(zzei zzei) {
        this.zzos = zzei;
        this.pos = zzei.zzom.size();
    }

    public /* synthetic */ zzek(zzei zzei, zzej zzej) {
        this(zzei);
    }

    private final Iterator zzdw() {
        if (this.zzor == null) {
            this.zzor = this.zzos.zzop.entrySet().iterator();
        }
        return this.zzor;
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public final boolean hasNext() {
        int i11 = this.pos;
        return (i11 > 0 && i11 <= this.zzos.zzom.size()) || zzdw().hasNext();
    }

    public final /* synthetic */ Object next() {
        Object obj;
        if (zzdw().hasNext()) {
            obj = zzdw().next();
        } else {
            List zzb = this.zzos.zzom;
            int i11 = this.pos - 1;
            this.pos = i11;
            obj = zzb.get(i11);
        }
        return (Map.Entry) obj;
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
