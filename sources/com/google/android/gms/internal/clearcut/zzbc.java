package com.google.android.gms.internal.clearcut;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class zzbc implements Iterator, j$.util.Iterator {
    private final int limit;
    private int position = 0;
    private final /* synthetic */ zzbb zzfl;

    public zzbc(zzbb zzbb) {
        this.zzfl = zzbb;
        this.limit = zzbb.size();
    }

    private final byte nextByte() {
        try {
            zzbb zzbb = this.zzfl;
            int i11 = this.position;
            this.position = i11 + 1;
            return zzbb.zzj(i11);
        } catch (IndexOutOfBoundsException e11) {
            throw new NoSuchElementException(e11.getMessage());
        }
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public final boolean hasNext() {
        return this.position < this.limit;
    }

    public final /* synthetic */ Object next() {
        return Byte.valueOf(nextByte());
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
