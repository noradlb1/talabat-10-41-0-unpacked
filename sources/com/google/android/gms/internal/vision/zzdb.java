package com.google.android.gms.internal.vision;

import java.util.NoSuchElementException;

abstract class zzdb<E> extends zzdq<E> {
    private int position;
    private final int size;

    public zzdb(int i11, int i12) {
        zzct.zzd(i12, i11);
        this.size = i11;
        this.position = i12;
    }

    public abstract E get(int i11);

    public final boolean hasNext() {
        return this.position < this.size;
    }

    public final boolean hasPrevious() {
        return this.position > 0;
    }

    public final E next() {
        if (hasNext()) {
            int i11 = this.position;
            this.position = i11 + 1;
            return get(i11);
        }
        throw new NoSuchElementException();
    }

    public final int nextIndex() {
        return this.position;
    }

    public final E previous() {
        if (hasPrevious()) {
            int i11 = this.position - 1;
            this.position = i11;
            return get(i11);
        }
        throw new NoSuchElementException();
    }

    public final int previousIndex() {
        return this.position - 1;
    }
}
