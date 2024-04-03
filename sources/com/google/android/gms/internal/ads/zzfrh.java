package com.google.android.gms.internal.ads;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

class zzfrh extends zzfrc implements SortedSet {
    final /* synthetic */ zzfrm zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzfrh(zzfrm zzfrm, SortedMap sortedMap) {
        super(zzfrm, sortedMap);
        this.zzc = zzfrm;
    }

    @CheckForNull
    public final Comparator comparator() {
        return zza().comparator();
    }

    public final Object first() {
        return zza().firstKey();
    }

    public SortedSet headSet(Object obj) {
        return new zzfrh(this.zzc, zza().headMap(obj));
    }

    public final Object last() {
        return zza().lastKey();
    }

    public SortedSet subSet(Object obj, Object obj2) {
        return new zzfrh(this.zzc, zza().subMap(obj, obj2));
    }

    public SortedSet tailSet(Object obj) {
        return new zzfrh(this.zzc, zza().tailMap(obj));
    }

    public SortedMap zza() {
        return (SortedMap) this.zzd;
    }
}
