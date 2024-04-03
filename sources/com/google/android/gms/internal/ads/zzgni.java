package com.google.android.gms.internal.ads;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.ListIterator;

final class zzgni implements ListIterator<String>, Iterator {
    final ListIterator<String> zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ zzgnk zzc;

    public zzgni(zzgnk zzgnk, int i11) {
        this.zzc = zzgnk;
        this.zzb = i11;
        this.zza = zzgnk.zza.listIterator(i11);
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
        return this.zza.next();
    }

    public final int nextIndex() {
        return this.zza.nextIndex();
    }

    public final /* bridge */ /* synthetic */ Object previous() {
        return this.zza.previous();
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
