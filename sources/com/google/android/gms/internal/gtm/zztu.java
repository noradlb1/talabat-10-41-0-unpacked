package com.google.android.gms.internal.gtm;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class zztu extends AbstractList<String> implements zzrt, RandomAccess {
    /* access modifiers changed from: private */
    public final zzrt zzbeo;

    public zztu(zzrt zzrt) {
        this.zzbeo = zzrt;
    }

    public final /* synthetic */ Object get(int i11) {
        return (String) this.zzbeo.get(i11);
    }

    public final Iterator<String> iterator() {
        return new zztw(this);
    }

    public final ListIterator<String> listIterator(int i11) {
        return new zztv(this, i11);
    }

    public final int size() {
        return this.zzbeo.size();
    }

    public final Object zzbn(int i11) {
        return this.zzbeo.zzbn(i11);
    }

    public final void zzc(zzps zzps) {
        throw new UnsupportedOperationException();
    }

    public final List<?> zzqa() {
        return this.zzbeo.zzqa();
    }

    public final zzrt zzqb() {
        return this;
    }
}
