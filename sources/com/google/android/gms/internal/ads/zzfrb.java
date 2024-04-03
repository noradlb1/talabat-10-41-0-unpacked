package com.google.android.gms.internal.ads;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

final class zzfrb implements Iterator, j$.util.Iterator {
    @CheckForNull
    Map.Entry zza;
    final /* synthetic */ Iterator zzb;
    final /* synthetic */ zzfrc zzc;

    public zzfrb(zzfrc zzfrc, Iterator it) {
        this.zzc = zzfrc;
        this.zzb = it;
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public final boolean hasNext() {
        return this.zzb.hasNext();
    }

    public final Object next() {
        Map.Entry entry = (Map.Entry) this.zzb.next();
        this.zza = entry;
        return entry.getKey();
    }

    public final void remove() {
        boolean z11;
        if (this.zza != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzfqg.zzg(z11, "no calls to next() since the last call to remove()");
        Collection collection = (Collection) this.zza.getValue();
        this.zzb.remove();
        zzfrm zzfrm = this.zzc.zza;
        zzfrm.zzb = zzfrm.zzb - collection.size();
        collection.clear();
        this.zza = null;
    }
}
