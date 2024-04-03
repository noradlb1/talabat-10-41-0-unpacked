package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class zzgqc<T> implements zzgpr<Set<T>> {
    private static final zzgpr<Set<Object>> zza = zzgps.zza(Collections.emptySet());
    private final List<zzgqe<T>> zzb;
    private final List<zzgqe<Collection<T>>> zzc;

    public /* synthetic */ zzgqc(List list, List list2, zzgqa zzgqa) {
        this.zzb = list;
        this.zzc = list2;
    }

    public static <T> zzgqb<T> zza(int i11, int i12) {
        return new zzgqb<>(i11, i12, (zzgqa) null);
    }

    /* renamed from: zzc */
    public final Set<T> zzb() {
        int size = this.zzb.size();
        ArrayList arrayList = new ArrayList(this.zzc.size());
        int size2 = this.zzc.size();
        for (int i11 = 0; i11 < size2; i11++) {
            Collection collection = (Collection) this.zzc.get(i11).zzb();
            size += collection.size();
            arrayList.add(collection);
        }
        HashSet zza2 = zzgpo.zza(size);
        int size3 = this.zzb.size();
        for (int i12 = 0; i12 < size3; i12++) {
            Object zzb2 = this.zzb.get(i12).zzb();
            zzb2.getClass();
            zza2.add(zzb2);
        }
        int size4 = arrayList.size();
        for (int i13 = 0; i13 < size4; i13++) {
            for (Object next : (Collection) arrayList.get(i13)) {
                next.getClass();
                zza2.add(next);
            }
        }
        return Collections.unmodifiableSet(zza2);
    }
}
