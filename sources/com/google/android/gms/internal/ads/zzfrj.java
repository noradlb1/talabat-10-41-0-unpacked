package com.google.android.gms.internal.ads;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import javax.annotation.CheckForNull;

class zzfrj extends AbstractCollection {
    final Object zza;
    Collection zzb;
    @CheckForNull
    final zzfrj zzc;
    @CheckForNull
    final Collection zzd;
    final /* synthetic */ zzfrm zze;

    public zzfrj(zzfrm zzfrm, Object obj, @CheckForNull Collection collection, zzfrj zzfrj) {
        this.zze = zzfrm;
        this.zza = obj;
        this.zzb = collection;
        this.zzc = zzfrj;
        this.zzd = zzfrj == null ? null : zzfrj.zzb;
    }

    public final boolean add(Object obj) {
        zzb();
        boolean isEmpty = this.zzb.isEmpty();
        boolean add = this.zzb.add(obj);
        if (add) {
            zzfrm zzfrm = this.zze;
            zzfrm.zzb = zzfrm.zzb + 1;
            if (isEmpty) {
                zza();
                return true;
            }
        }
        return add;
    }

    public final boolean addAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean addAll = this.zzb.addAll(collection);
        if (!addAll) {
            return addAll;
        }
        int size2 = this.zzb.size();
        zzfrm zzfrm = this.zze;
        zzfrm.zzb = zzfrm.zzb + (size2 - size);
        if (size != 0) {
            return addAll;
        }
        zza();
        return true;
    }

    public final void clear() {
        int size = size();
        if (size != 0) {
            this.zzb.clear();
            zzfrm zzfrm = this.zze;
            zzfrm.zzb = zzfrm.zzb - size;
            zzc();
        }
    }

    public final boolean contains(@CheckForNull Object obj) {
        zzb();
        return this.zzb.contains(obj);
    }

    public final boolean containsAll(Collection<?> collection) {
        zzb();
        return this.zzb.containsAll(collection);
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        zzb();
        return this.zzb.equals(obj);
    }

    public final int hashCode() {
        zzb();
        return this.zzb.hashCode();
    }

    public final Iterator iterator() {
        zzb();
        return new zzfri(this);
    }

    public final boolean remove(@CheckForNull Object obj) {
        zzb();
        boolean remove = this.zzb.remove(obj);
        if (remove) {
            zzfrm zzfrm = this.zze;
            zzfrm.zzb = zzfrm.zzb - 1;
            zzc();
        }
        return remove;
    }

    public final boolean removeAll(Collection<?> collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean removeAll = this.zzb.removeAll(collection);
        if (removeAll) {
            int size2 = this.zzb.size();
            zzfrm zzfrm = this.zze;
            zzfrm.zzb = zzfrm.zzb + (size2 - size);
            zzc();
        }
        return removeAll;
    }

    public final boolean retainAll(Collection<?> collection) {
        collection.getClass();
        int size = size();
        boolean retainAll = this.zzb.retainAll(collection);
        if (retainAll) {
            int size2 = this.zzb.size();
            zzfrm zzfrm = this.zze;
            zzfrm.zzb = zzfrm.zzb + (size2 - size);
            zzc();
        }
        return retainAll;
    }

    public final int size() {
        zzb();
        return this.zzb.size();
    }

    public final String toString() {
        zzb();
        return this.zzb.toString();
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        zzfrj zzfrj = this.zzc;
        if (zzfrj != null) {
            zzfrj.zza();
        } else {
            this.zze.zza.put(this.zza, this.zzb);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb() {
        Collection collection;
        zzfrj zzfrj = this.zzc;
        if (zzfrj != null) {
            zzfrj.zzb();
            if (this.zzc.zzb != this.zzd) {
                throw new ConcurrentModificationException();
            }
        } else if (this.zzb.isEmpty() && (collection = (Collection) this.zze.zza.get(this.zza)) != null) {
            this.zzb = collection;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzc() {
        zzfrj zzfrj = this.zzc;
        if (zzfrj != null) {
            zzfrj.zzc();
        } else if (this.zzb.isEmpty()) {
            this.zze.zza.remove(this.zza);
        }
    }
}
