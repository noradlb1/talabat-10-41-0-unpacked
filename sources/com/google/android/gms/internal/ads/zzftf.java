package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.NoSuchElementException;

enum zzftf implements Iterator<Object>, j$.util.Iterator {
    INSTANCE;

    public final boolean hasNext() {
        return false;
    }

    public final Object next() {
        throw new NoSuchElementException();
    }

    public final void remove() {
        zzfqg.zzg(false, "no calls to next() since the last call to remove()");
    }
}
