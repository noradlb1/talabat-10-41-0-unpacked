package com.google.android.gms.internal.p002firebaseauthapi;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaiv  reason: invalid package */
final class zzaiv implements Iterator, j$.util.Iterator {
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public final boolean hasNext() {
        return false;
    }

    public final Object next() {
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
