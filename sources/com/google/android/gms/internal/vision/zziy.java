package com.google.android.gms.internal.vision;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class zziy implements Iterator, j$.util.Iterator {
    private int pos;
    private final /* synthetic */ zziw zzaab;
    private Iterator zzaac;

    private zziy(zziw zziw) {
        this.zzaab = zziw;
        this.pos = zziw.zzzw.size();
    }

    private final Iterator zzic() {
        if (this.zzaac == null) {
            this.zzaac = this.zzaab.zzzz.entrySet().iterator();
        }
        return this.zzaac;
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public final boolean hasNext() {
        int i11 = this.pos;
        return (i11 > 0 && i11 <= this.zzaab.zzzw.size()) || zzic().hasNext();
    }

    public final /* synthetic */ Object next() {
        if (zzic().hasNext()) {
            return (Map.Entry) zzic().next();
        }
        List zzb = this.zzaab.zzzw;
        int i11 = this.pos - 1;
        this.pos = i11;
        return (Map.Entry) zzb.get(i11);
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ zziy(zziw zziw, zziv zziv) {
        this(zziw);
    }
}
