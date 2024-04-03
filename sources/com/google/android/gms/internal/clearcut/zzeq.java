package com.google.android.gms.internal.clearcut;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.Map;

final class zzeq implements Iterator, j$.util.Iterator {
    private int pos;
    private Iterator zzor;
    private final /* synthetic */ zzei zzos;
    private boolean zzow;

    private zzeq(zzei zzei) {
        this.zzos = zzei;
        this.pos = -1;
    }

    public /* synthetic */ zzeq(zzei zzei, zzej zzej) {
        this(zzei);
    }

    private final Iterator zzdw() {
        if (this.zzor == null) {
            this.zzor = this.zzos.zzon.entrySet().iterator();
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
        return this.pos + 1 < this.zzos.zzom.size() || (!this.zzos.zzon.isEmpty() && zzdw().hasNext());
    }

    public final /* synthetic */ Object next() {
        this.zzow = true;
        int i11 = this.pos + 1;
        this.pos = i11;
        return (Map.Entry) (i11 < this.zzos.zzom.size() ? this.zzos.zzom.get(this.pos) : zzdw().next());
    }

    public final void remove() {
        if (this.zzow) {
            this.zzow = false;
            this.zzos.zzdu();
            if (this.pos < this.zzos.zzom.size()) {
                zzei zzei = this.zzos;
                int i11 = this.pos;
                this.pos = i11 - 1;
                Object unused = zzei.zzal(i11);
                return;
            }
            zzdw().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }
}
