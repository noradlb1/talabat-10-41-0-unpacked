package com.google.android.gms.internal.p002firebaseauthapi;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaz  reason: invalid package */
public abstract class zzaz implements Iterator, j$.util.Iterator {
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    @Deprecated
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
