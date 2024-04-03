package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

final class zzfre extends zzfrh implements NavigableSet {
    final /* synthetic */ zzfrm zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzfre(zzfrm zzfrm, NavigableMap navigableMap) {
        super(zzfrm, navigableMap);
        this.zzb = zzfrm;
    }

    @CheckForNull
    public final Object ceiling(Object obj) {
        return ((NavigableMap) ((SortedMap) this.zzd)).ceilingKey(obj);
    }

    public final Iterator descendingIterator() {
        return descendingSet().iterator();
    }

    public final NavigableSet descendingSet() {
        return new zzfre(this.zzb, ((NavigableMap) ((SortedMap) this.zzd)).descendingMap());
    }

    @CheckForNull
    public final Object floor(Object obj) {
        return ((NavigableMap) ((SortedMap) this.zzd)).floorKey(obj);
    }

    public final /* synthetic */ SortedSet headSet(Object obj) {
        return headSet(obj, false);
    }

    @CheckForNull
    public final Object higher(Object obj) {
        return ((NavigableMap) ((SortedMap) this.zzd)).higherKey(obj);
    }

    @CheckForNull
    public final Object lower(Object obj) {
        return ((NavigableMap) ((SortedMap) this.zzd)).lowerKey(obj);
    }

    @CheckForNull
    public final Object pollFirst() {
        return zzftg.zza(iterator());
    }

    @CheckForNull
    public final Object pollLast() {
        return zzftg.zza(descendingIterator());
    }

    public final /* bridge */ /* synthetic */ SortedSet subSet(Object obj, Object obj2) {
        return subSet(obj, true, obj2, false);
    }

    public final /* synthetic */ SortedSet tailSet(Object obj) {
        return tailSet(obj, true);
    }

    public final /* synthetic */ SortedMap zza() {
        return (NavigableMap) ((SortedMap) this.zzd);
    }

    public final NavigableSet headSet(Object obj, boolean z11) {
        return new zzfre(this.zzb, ((NavigableMap) ((SortedMap) this.zzd)).headMap(obj, z11));
    }

    public final NavigableSet subSet(Object obj, boolean z11, Object obj2, boolean z12) {
        return new zzfre(this.zzb, ((NavigableMap) ((SortedMap) this.zzd)).subMap(obj, z11, obj2, z12));
    }

    public final NavigableSet tailSet(Object obj, boolean z11) {
        return new zzfre(this.zzb, ((NavigableMap) ((SortedMap) this.zzd)).tailMap(obj, z11));
    }
}
