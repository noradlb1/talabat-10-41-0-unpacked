package com.google.android.gms.internal.vision;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.Map;

final class zzje implements Iterator, j$.util.Iterator {
    private int pos;
    private final /* synthetic */ zziw zzaab;
    private Iterator zzaac;
    private boolean zzaag;

    private zzje(zziw zziw) {
        this.zzaab = zziw;
        this.pos = -1;
    }

    private final Iterator zzic() {
        if (this.zzaac == null) {
            this.zzaac = this.zzaab.zzzx.entrySet().iterator();
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
        if (this.pos + 1 < this.zzaab.zzzw.size() || (!this.zzaab.zzzx.isEmpty() && zzic().hasNext())) {
            return true;
        }
        return false;
    }

    public final /* synthetic */ Object next() {
        this.zzaag = true;
        int i11 = this.pos + 1;
        this.pos = i11;
        if (i11 < this.zzaab.zzzw.size()) {
            return (Map.Entry) this.zzaab.zzzw.get(this.pos);
        }
        return (Map.Entry) zzic().next();
    }

    public final void remove() {
        if (this.zzaag) {
            this.zzaag = false;
            this.zzaab.zzia();
            if (this.pos < this.zzaab.zzzw.size()) {
                zziw zziw = this.zzaab;
                int i11 = this.pos;
                this.pos = i11 - 1;
                Object unused = zziw.zzbv(i11);
                return;
            }
            zzic().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }

    public /* synthetic */ zzje(zziw zziw, zziv zziv) {
        this(zziw);
    }
}
