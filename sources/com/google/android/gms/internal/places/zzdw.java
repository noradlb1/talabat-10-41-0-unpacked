package com.google.android.gms.internal.places;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.ListIterator;

final class zzdw implements ListIterator<String>, Iterator {
    private final /* synthetic */ int zzbp;
    private final /* synthetic */ zzdt zzml;
    private ListIterator<String> zzmm;

    public zzdw(zzdt zzdt, int i11) {
        this.zzml = zzdt;
        this.zzbp = i11;
        this.zzmm = zzdt.zzmj.listIterator(i11);
    }

    public final /* synthetic */ void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public final boolean hasNext() {
        return this.zzmm.hasNext();
    }

    public final boolean hasPrevious() {
        return this.zzmm.hasPrevious();
    }

    public final /* synthetic */ Object next() {
        return this.zzmm.next();
    }

    public final int nextIndex() {
        return this.zzmm.nextIndex();
    }

    public final /* synthetic */ Object previous() {
        return this.zzmm.previous();
    }

    public final int previousIndex() {
        return this.zzmm.previousIndex();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
