package com.google.android.gms.internal.p002firebaseauthapi;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzajp  reason: invalid package */
final class zzajp implements Iterator, j$.util.Iterator {
    final Iterator zza;
    final /* synthetic */ zzajq zzb;

    public zzajp(zzajq zzajq) {
        this.zzb = zzajq;
        this.zza = zzajq.zza.iterator();
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.zza.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
