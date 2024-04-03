package com.google.android.gms.internal.p002firebaseauthapi;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.ListIterator;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzajo  reason: invalid package */
final class zzajo implements ListIterator, Iterator {
    final ListIterator zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ zzajq zzc;

    public zzajo(zzajq zzajq, int i11) {
        this.zzc = zzajq;
        this.zzb = i11;
        this.zza = zzajq.zza.listIterator(i11);
    }

    public final /* synthetic */ void add(Object obj) {
        String str = (String) obj;
        throw new UnsupportedOperationException();
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

    public final boolean hasPrevious() {
        return this.zza.hasPrevious();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.zza.next();
    }

    public final int nextIndex() {
        return this.zza.nextIndex();
    }

    public final /* bridge */ /* synthetic */ Object previous() {
        return (String) this.zza.previous();
    }

    public final int previousIndex() {
        return this.zza.previousIndex();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void set(Object obj) {
        String str = (String) obj;
        throw new UnsupportedOperationException();
    }
}
