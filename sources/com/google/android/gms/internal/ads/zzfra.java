package com.google.android.gms.internal.ads;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

class zzfra<T> implements Iterator<T>, j$.util.Iterator {
    final Iterator<Map.Entry> zza;
    @CheckForNull
    Object zzb = null;
    @CheckForNull
    Collection zzc = null;
    Iterator zzd = zzftf.INSTANCE;
    final /* synthetic */ zzfrm zze;

    public zzfra(zzfrm zzfrm) {
        this.zze = zzfrm;
        this.zza = zzfrm.zza.entrySet().iterator();
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public final boolean hasNext() {
        return this.zza.hasNext() || this.zzd.hasNext();
    }

    public final T next() {
        if (!this.zzd.hasNext()) {
            Map.Entry next = this.zza.next();
            this.zzb = next.getKey();
            Collection collection = (Collection) next.getValue();
            this.zzc = collection;
            this.zzd = collection.iterator();
        }
        return this.zzd.next();
    }

    public final void remove() {
        this.zzd.remove();
        Collection collection = this.zzc;
        collection.getClass();
        if (collection.isEmpty()) {
            this.zza.remove();
        }
        zzfrm zzfrm = this.zze;
        zzfrm.zzb = zzfrm.zzb - 1;
    }
}
