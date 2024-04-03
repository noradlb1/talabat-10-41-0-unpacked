package com.google.android.gms.internal.gtm;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class zzon implements Iterator<zzoa<?>>, j$.util.Iterator {
    private int currentIndex = 0;
    private final /* synthetic */ zzom zzauw;

    public zzon(zzom zzom) {
        this.zzauw = zzom;
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public final boolean hasNext() {
        return this.currentIndex < this.zzauw.value.length();
    }

    public final /* synthetic */ Object next() {
        if (this.currentIndex < this.zzauw.value.length()) {
            int i11 = this.currentIndex;
            this.currentIndex = i11 + 1;
            return new zzoe(Double.valueOf((double) i11));
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
