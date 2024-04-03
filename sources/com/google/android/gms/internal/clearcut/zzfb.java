package com.google.android.gms.internal.clearcut;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.ListIterator;

final class zzfb implements ListIterator<String>, Iterator {
    private ListIterator<String> zzpc;
    private final /* synthetic */ int zzpd;
    private final /* synthetic */ zzfa zzpe;

    public zzfb(zzfa zzfa, int i11) {
        this.zzpe = zzfa;
        this.zzpd = i11;
        this.zzpc = zzfa.zzpb.listIterator(i11);
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
        return this.zzpc.hasNext();
    }

    public final boolean hasPrevious() {
        return this.zzpc.hasPrevious();
    }

    public final /* synthetic */ Object next() {
        return this.zzpc.next();
    }

    public final int nextIndex() {
        return this.zzpc.nextIndex();
    }

    public final /* synthetic */ Object previous() {
        return this.zzpc.previous();
    }

    public final int previousIndex() {
        return this.zzpc.previousIndex();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
