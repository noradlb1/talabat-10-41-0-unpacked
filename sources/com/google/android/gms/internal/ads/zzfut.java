package com.google.android.gms.internal.ads;

import java.util.ListIterator;

abstract class zzfut<F, T> extends zzfus<F, T> implements ListIterator<T> {
    public zzfut(ListIterator<? extends F> listIterator) {
        super(listIterator);
    }

    public final void add(T t11) {
        throw new UnsupportedOperationException();
    }

    public final boolean hasPrevious() {
        return ((ListIterator) this.zzb).hasPrevious();
    }

    public final int nextIndex() {
        return ((ListIterator) this.zzb).nextIndex();
    }

    public final T previous() {
        return zza(((ListIterator) this.zzb).previous());
    }

    public final int previousIndex() {
        return ((ListIterator) this.zzb).previousIndex();
    }

    public final void set(T t11) {
        throw new UnsupportedOperationException();
    }
}
