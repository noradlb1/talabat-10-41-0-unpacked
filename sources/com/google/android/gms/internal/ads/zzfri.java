package com.google.android.gms.internal.ads;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

class zzfri implements Iterator, j$.util.Iterator {
    final Iterator zza;
    final Collection zzb;
    final /* synthetic */ zzfrj zzc;

    public zzfri(zzfrj zzfrj) {
        Iterator it;
        this.zzc = zzfrj;
        Collection collection = zzfrj.zzb;
        this.zzb = collection;
        if (collection instanceof List) {
            it = ((List) collection).listIterator();
        } else {
            it = collection.iterator();
        }
        this.zza = it;
    }

    public zzfri(zzfrj zzfrj, Iterator it) {
        this.zzc = zzfrj;
        this.zzb = zzfrj.zzb;
        this.zza = it;
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public final boolean hasNext() {
        zza();
        return this.zza.hasNext();
    }

    public final Object next() {
        zza();
        return this.zza.next();
    }

    public final void remove() {
        this.zza.remove();
        zzfrm zzfrm = this.zzc.zze;
        zzfrm.zzb = zzfrm.zzb - 1;
        this.zzc.zzc();
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        this.zzc.zzb();
        if (this.zzc.zzb != this.zzb) {
            throw new ConcurrentModificationException();
        }
    }
}
