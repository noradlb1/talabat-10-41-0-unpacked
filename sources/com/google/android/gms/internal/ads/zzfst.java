package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class zzfst<K, V> extends zzfsy<K, V> {
    public final zzfst<K, V> zza(K k11, V... vArr) {
        List asList = Arrays.asList(vArr);
        Collection collection = this.zza.get(k11);
        if (collection != null) {
            for (Object next : asList) {
                zzfrr.zzb(k11, next);
                collection.add(next);
            }
        } else {
            Iterator it = asList.iterator();
            if (it.hasNext()) {
                ArrayList arrayList = new ArrayList();
                while (it.hasNext()) {
                    Object next2 = it.next();
                    zzfrr.zzb(k11, next2);
                    arrayList.add(next2);
                }
                this.zza.put(k11, arrayList);
            }
        }
        return this;
    }

    public final zzfsu<K, V> zzb() {
        Set<Map.Entry<K, Collection<V>>> entrySet = this.zza.entrySet();
        if (entrySet.isEmpty()) {
            return zzfsi.zza;
        }
        zzfsv zzfsv = new zzfsv(entrySet.size());
        int i11 = 0;
        for (Map.Entry next : entrySet) {
            Object key = next.getKey();
            zzfss zzm = zzfss.zzm((Collection) next.getValue());
            if (!zzm.isEmpty()) {
                zzfsv.zza(key, zzm);
                i11 += zzm.size();
            }
        }
        return new zzfsu<>(zzfsv.zzc(), i11);
    }
}
