package com.google.android.gms.internal.places;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class zzdt extends AbstractList<String> implements zzbr, RandomAccess {
    /* access modifiers changed from: private */
    public final zzbr zzmj;

    public zzdt(zzbr zzbr) {
        this.zzmj = zzbr;
    }

    public final /* synthetic */ Object get(int i11) {
        return (String) this.zzmj.get(i11);
    }

    public final Iterator<String> iterator() {
        return new zzdv(this);
    }

    public final ListIterator<String> listIterator(int i11) {
        return new zzdw(this, i11);
    }

    public final int size() {
        return this.zzmj.size();
    }

    public final Object zzae(int i11) {
        return this.zzmj.zzae(i11);
    }

    public final List<?> zzby() {
        return this.zzmj.zzby();
    }

    public final zzbr zzbz() {
        return this;
    }
}
