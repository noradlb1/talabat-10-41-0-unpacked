package com.google.android.gms.internal.ads;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

final class zzfqy implements Iterator<Map.Entry>, j$.util.Iterator {
    final Iterator<Map.Entry> zza;
    @CheckForNull
    Collection zzb;
    final /* synthetic */ zzfqz zzc;

    public zzfqy(zzfqz zzfqz) {
        this.zzc = zzfqz;
        this.zza = zzfqz.zza.entrySet().iterator();
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        Map.Entry next = this.zza.next();
        this.zzb = (Collection) next.getValue();
        return this.zzc.zza(next);
    }

    public final void remove() {
        boolean z11;
        if (this.zzb != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzfqg.zzg(z11, "no calls to next() since the last call to remove()");
        this.zza.remove();
        zzfrm zzfrm = this.zzc.zzb;
        zzfrm.zzb = zzfrm.zzb - this.zzb.size();
        this.zzb.clear();
        this.zzb = null;
    }
}
