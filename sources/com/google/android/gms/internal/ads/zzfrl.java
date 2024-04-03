package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import javax.annotation.CheckForNull;

class zzfrl extends zzfrj implements List {
    final /* synthetic */ zzfrm zzf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzfrl(zzfrm zzfrm, Object obj, @CheckForNull List list, zzfrj zzfrj) {
        super(zzfrm, obj, list, zzfrj);
        this.zzf = zzfrm;
    }

    public final void add(int i11, Object obj) {
        zzb();
        boolean isEmpty = this.zzb.isEmpty();
        ((List) this.zzb).add(i11, obj);
        zzfrm zzfrm = this.zzf;
        zzfrm.zzb = zzfrm.zzb + 1;
        if (isEmpty) {
            zza();
        }
    }

    public final boolean addAll(int i11, Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean addAll = ((List) this.zzb).addAll(i11, collection);
        if (!addAll) {
            return addAll;
        }
        int size2 = this.zzb.size();
        zzfrm zzfrm = this.zzf;
        zzfrm.zzb = zzfrm.zzb + (size2 - size);
        if (size != 0) {
            return addAll;
        }
        zza();
        return true;
    }

    public final Object get(int i11) {
        zzb();
        return ((List) this.zzb).get(i11);
    }

    public final int indexOf(@CheckForNull Object obj) {
        zzb();
        return ((List) this.zzb).indexOf(obj);
    }

    public final int lastIndexOf(@CheckForNull Object obj) {
        zzb();
        return ((List) this.zzb).lastIndexOf(obj);
    }

    public final ListIterator listIterator() {
        zzb();
        return new zzfrk(this);
    }

    public final Object remove(int i11) {
        zzb();
        Object remove = ((List) this.zzb).remove(i11);
        zzfrm zzfrm = this.zzf;
        zzfrm.zzb = zzfrm.zzb - 1;
        zzc();
        return remove;
    }

    public final Object set(int i11, Object obj) {
        zzb();
        return ((List) this.zzb).set(i11, obj);
    }

    public final List subList(int i11, int i12) {
        zzb();
        zzfrm zzfrm = this.zzf;
        Object obj = this.zza;
        List subList = ((List) this.zzb).subList(i11, i12);
        zzfrj zzfrj = this.zzc;
        if (zzfrj == null) {
            zzfrj = this;
        }
        return zzfrm.zzh(obj, subList, zzfrj);
    }

    public final ListIterator listIterator(int i11) {
        zzb();
        return new zzfrk(this, i11);
    }
}
