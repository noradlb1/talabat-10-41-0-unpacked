package com.google.android.gms.internal.ads;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.List;

final class zzgph implements Iterator, j$.util.Iterator {
    int zza = 0;
    final /* synthetic */ zzgpi zzb;

    public zzgph(zzgpi zzgpi) {
        this.zzb = zzgpi;
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public final boolean hasNext() {
        return this.zza < this.zzb.zza.size() || this.zzb.zzb.hasNext();
    }

    public final Object next() {
        if (this.zza < this.zzb.zza.size()) {
            List<E> list = this.zzb.zza;
            int i11 = this.zza;
            this.zza = i11 + 1;
            return list.get(i11);
        }
        zzgpi zzgpi = this.zzb;
        zzgpi.zza.add(zzgpi.zzb.next());
        return next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
