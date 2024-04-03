package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

class zzfrc extends zzfto {
    final /* synthetic */ zzfrm zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzfrc(zzfrm zzfrm, Map map) {
        super(map);
        this.zza = zzfrm;
    }

    public final void clear() {
        zzftg.zzb(iterator());
    }

    public final boolean containsAll(Collection<?> collection) {
        return this.zzd.keySet().containsAll(collection);
    }

    public final boolean equals(@CheckForNull Object obj) {
        return this == obj || this.zzd.keySet().equals(obj);
    }

    public final int hashCode() {
        return this.zzd.keySet().hashCode();
    }

    public final Iterator iterator() {
        return new zzfrb(this, this.zzd.entrySet().iterator());
    }

    public final boolean remove(@CheckForNull Object obj) {
        Collection collection = (Collection) this.zzd.remove(obj);
        if (collection == null) {
            return false;
        }
        int size = collection.size();
        collection.clear();
        zzfrm zzfrm = this.zza;
        zzfrm.zzb = zzfrm.zzb - size;
        if (size > 0) {
            return true;
        }
        return false;
    }
}
