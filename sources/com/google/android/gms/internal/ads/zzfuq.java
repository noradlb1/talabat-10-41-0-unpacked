package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public final class zzfuq {
    public static int zza(Set<?> set) {
        int i11;
        int i12 = 0;
        for (Object next : set) {
            if (next != null) {
                i11 = next.hashCode();
            } else {
                i11 = 0;
            }
            i12 += i11;
        }
        return i12;
    }

    public static boolean zzb(Set<?> set, Collection<?> collection) {
        collection.getClass();
        if (collection instanceof zzfuc) {
            collection = ((zzfuc) collection).zza();
        }
        if (!(collection instanceof Set) || collection.size() <= set.size()) {
            return zzc(set, collection.iterator());
        }
        Iterator<?> it = set.iterator();
        boolean z11 = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z11 = true;
            }
        }
        return z11;
    }

    public static boolean zzc(Set<?> set, Iterator<?> it) {
        boolean z11 = false;
        while (it.hasNext()) {
            z11 |= set.remove(it.next());
        }
        return z11;
    }
}
