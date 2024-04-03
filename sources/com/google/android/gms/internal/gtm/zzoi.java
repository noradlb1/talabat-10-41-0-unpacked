package com.google.android.gms.internal.gtm;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class zzoi implements Iterator<zzoa<?>>, j$.util.Iterator {
    private int currentIndex = 0;
    private final /* synthetic */ zzoh zzauq;

    public zzoi(zzoh zzoh) {
        this.zzauq = zzoh;
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public final boolean hasNext() {
        for (int i11 = this.currentIndex; i11 < this.zzauq.zzaup.size(); i11++) {
            if (this.zzauq.zzaup.get(i11) != null) {
                return true;
            }
        }
        return false;
    }

    public final /* synthetic */ Object next() {
        if (this.currentIndex < this.zzauq.zzaup.size()) {
            for (int i11 = this.currentIndex; i11 < this.zzauq.zzaup.size(); i11++) {
                if (this.zzauq.zzaup.get(i11) != null) {
                    this.currentIndex = i11;
                    int i12 = this.currentIndex;
                    this.currentIndex = i12 + 1;
                    return new zzoe(Double.valueOf((double) i12));
                }
            }
            throw new NoSuchElementException();
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
