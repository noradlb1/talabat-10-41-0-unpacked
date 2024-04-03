package com.google.android.gms.internal.gtm;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.ListIterator;

final class zztv implements ListIterator<String>, Iterator {
    private ListIterator<String> zzbep;
    private final /* synthetic */ int zzbeq;
    private final /* synthetic */ zztu zzber;

    public zztv(zztu zztu, int i11) {
        this.zzber = zztu;
        this.zzbeq = i11;
        this.zzbep = zztu.zzbeo.listIterator(i11);
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
        return this.zzbep.hasNext();
    }

    public final boolean hasPrevious() {
        return this.zzbep.hasPrevious();
    }

    public final /* synthetic */ Object next() {
        return this.zzbep.next();
    }

    public final int nextIndex() {
        return this.zzbep.nextIndex();
    }

    public final /* synthetic */ Object previous() {
        return this.zzbep.previous();
    }

    public final int previousIndex() {
        return this.zzbep.previousIndex();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
