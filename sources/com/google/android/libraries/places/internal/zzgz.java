package com.google.android.libraries.places.internal;

import java.util.ListIterator;

abstract class zzgz<F, T> extends zzgy<F, T> implements ListIterator<T> {
    public zzgz(ListIterator<? extends F> listIterator) {
        super(listIterator);
    }

    public final void add(T t11) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.util.ListIterator, java.util.Iterator<? extends F>] */
    public final boolean hasPrevious() {
        return this.zzb.hasPrevious();
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.util.ListIterator, java.util.Iterator<? extends F>] */
    public final int nextIndex() {
        return this.zzb.nextIndex();
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.util.ListIterator, java.util.Iterator<? extends F>] */
    public final T previous() {
        return zza(this.zzb.previous());
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.util.ListIterator, java.util.Iterator<? extends F>] */
    public final int previousIndex() {
        return this.zzb.previousIndex();
    }

    public final void set(T t11) {
        throw new UnsupportedOperationException();
    }
}
