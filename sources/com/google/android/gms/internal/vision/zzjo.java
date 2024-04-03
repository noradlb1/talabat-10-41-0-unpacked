package com.google.android.gms.internal.vision;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class zzjo extends AbstractList<String> implements zzhj, RandomAccess {
    /* access modifiers changed from: private */
    public final zzhj zzaao;

    public zzjo(zzhj zzhj) {
        this.zzaao = zzhj;
    }

    public final /* synthetic */ Object get(int i11) {
        return (String) this.zzaao.get(i11);
    }

    public final Object getRaw(int i11) {
        return this.zzaao.getRaw(i11);
    }

    public final Iterator<String> iterator() {
        return new zzjq(this);
    }

    public final ListIterator<String> listIterator(int i11) {
        return new zzjn(this, i11);
    }

    public final int size() {
        return this.zzaao.size();
    }

    public final void zzc(zzfh zzfh) {
        throw new UnsupportedOperationException();
    }

    public final List<?> zzgx() {
        return this.zzaao.zzgx();
    }

    public final zzhj zzgy() {
        return this;
    }
}
