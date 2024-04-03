package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

class zzfqz extends zzftq {
    final transient Map zza;
    final /* synthetic */ zzfrm zzb;

    public zzfqz(zzfrm zzfrm, Map map) {
        this.zzb = zzfrm;
        this.zza = map;
    }

    public final void clear() {
        if (this.zza == this.zzb.zza) {
            this.zzb.zzp();
        } else {
            zzftg.zzb(new zzfqy(this));
        }
    }

    public final boolean containsKey(@CheckForNull Object obj) {
        Map map = this.zza;
        map.getClass();
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public final boolean equals(@CheckForNull Object obj) {
        return this == obj || this.zza.equals(obj);
    }

    @CheckForNull
    public final /* bridge */ /* synthetic */ Object get(@CheckForNull Object obj) {
        Collection collection = (Collection) zzftr.zza(this.zza, obj);
        if (collection == null) {
            return null;
        }
        return this.zzb.zzc(obj, collection);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public Set keySet() {
        return this.zzb.zzt();
    }

    @CheckForNull
    public final /* bridge */ /* synthetic */ Object remove(@CheckForNull Object obj) {
        Collection collection = (Collection) this.zza.remove(obj);
        if (collection == null) {
            return null;
        }
        Collection zza2 = this.zzb.zza();
        zza2.addAll(collection);
        zzfrm zzfrm = this.zzb;
        zzfrm.zzb = zzfrm.zzb - collection.size();
        collection.clear();
        return zza2;
    }

    public final int size() {
        return this.zza.size();
    }

    public final String toString() {
        return this.zza.toString();
    }

    public final Map.Entry zza(Map.Entry entry) {
        Object key = entry.getKey();
        return new zzfso(key, this.zzb.zzc(key, (Collection) entry.getValue()));
    }

    public final Set<Map.Entry> zzb() {
        return new zzfqx(this);
    }
}
