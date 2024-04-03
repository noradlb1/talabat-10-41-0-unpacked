package com.google.android.gms.internal.gtm;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.Map;

final class zztk implements Iterator, j$.util.Iterator {
    private int pos;
    private Iterator zzbee;
    private final /* synthetic */ zztc zzbef;
    private boolean zzbej;

    private zztk(zztc zztc) {
        this.zzbef = zztc;
        this.pos = -1;
    }

    private final Iterator zzrf() {
        if (this.zzbee == null) {
            this.zzbee = this.zzbef.zzbea.entrySet().iterator();
        }
        return this.zzbee;
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public final boolean hasNext() {
        if (this.pos + 1 < this.zzbef.zzbdz.size() || (!this.zzbef.zzbea.isEmpty() && zzrf().hasNext())) {
            return true;
        }
        return false;
    }

    public final /* synthetic */ Object next() {
        this.zzbej = true;
        int i11 = this.pos + 1;
        this.pos = i11;
        if (i11 < this.zzbef.zzbdz.size()) {
            return (Map.Entry) this.zzbef.zzbdz.get(this.pos);
        }
        return (Map.Entry) zzrf().next();
    }

    public final void remove() {
        if (this.zzbej) {
            this.zzbej = false;
            this.zzbef.zzrd();
            if (this.pos < this.zzbef.zzbdz.size()) {
                zztc zztc = this.zzbef;
                int i11 = this.pos;
                this.pos = i11 - 1;
                Object unused = zztc.zzbw(i11);
                return;
            }
            zzrf().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }

    public /* synthetic */ zztk(zztc zztc, zztd zztd) {
        this(zztc);
    }
}
