package com.google.android.gms.internal.ads;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

class zzfrg extends zzfqz implements SortedMap {
    @CheckForNull
    SortedSet zzd;
    final /* synthetic */ zzfrm zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzfrg(zzfrm zzfrm, SortedMap sortedMap) {
        super(zzfrm, sortedMap);
        this.zze = zzfrm;
    }

    @CheckForNull
    public final Comparator comparator() {
        return zzf().comparator();
    }

    public final Object firstKey() {
        return zzf().firstKey();
    }

    public SortedMap headMap(Object obj) {
        return new zzfrg(this.zze, zzf().headMap(obj));
    }

    public final Object lastKey() {
        return zzf().lastKey();
    }

    public SortedMap subMap(Object obj, Object obj2) {
        return new zzfrg(this.zze, zzf().subMap(obj, obj2));
    }

    public SortedMap tailMap(Object obj) {
        return new zzfrg(this.zze, zzf().tailMap(obj));
    }

    public SortedMap zzf() {
        return (SortedMap) this.zza;
    }

    /* renamed from: zzg */
    public SortedSet zze() {
        return new zzfrh(this.zze, zzf());
    }

    /* renamed from: zzh */
    public SortedSet keySet() {
        SortedSet sortedSet = this.zzd;
        if (sortedSet != null) {
            return sortedSet;
        }
        SortedSet zzg = zze();
        this.zzd = zzg;
        return zzg;
    }
}
