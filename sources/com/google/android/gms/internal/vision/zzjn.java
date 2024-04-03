package com.google.android.gms.internal.vision;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.ListIterator;

final class zzjn implements ListIterator<String>, Iterator {
    private ListIterator<String> zzaal;
    private final /* synthetic */ int zzaam;
    private final /* synthetic */ zzjo zzaan;

    public zzjn(zzjo zzjo, int i11) {
        this.zzaan = zzjo;
        this.zzaam = i11;
        this.zzaal = zzjo.zzaao.listIterator(i11);
    }

    public final /* synthetic */ void add(Object obj) {
        String str = (String) obj;
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public final boolean hasNext() {
        return this.zzaal.hasNext();
    }

    public final boolean hasPrevious() {
        return this.zzaal.hasPrevious();
    }

    public final /* synthetic */ Object next() {
        return this.zzaal.next();
    }

    public final int nextIndex() {
        return this.zzaal.nextIndex();
    }

    public final /* synthetic */ Object previous() {
        return this.zzaal.previous();
    }

    public final int previousIndex() {
        return this.zzaal.previousIndex();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void set(Object obj) {
        String str = (String) obj;
        throw new UnsupportedOperationException();
    }
}
