package com.google.android.gms.internal.gtm;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class zzte implements Iterator, j$.util.Iterator {
    private int pos;
    private Iterator zzbee;
    private final /* synthetic */ zztc zzbef;

    private zzte(zztc zztc) {
        this.zzbef = zztc;
        this.pos = zztc.zzbdz.size();
    }

    private final Iterator zzrf() {
        if (this.zzbee == null) {
            this.zzbee = this.zzbef.zzbec.entrySet().iterator();
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
        int i11 = this.pos;
        return (i11 > 0 && i11 <= this.zzbef.zzbdz.size()) || zzrf().hasNext();
    }

    public final /* synthetic */ Object next() {
        if (zzrf().hasNext()) {
            return (Map.Entry) zzrf().next();
        }
        List zzb = this.zzbef.zzbdz;
        int i11 = this.pos - 1;
        this.pos = i11;
        return (Map.Entry) zzb.get(i11);
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ zzte(zztc zztc, zztd zztd) {
        this(zztc);
    }
}
