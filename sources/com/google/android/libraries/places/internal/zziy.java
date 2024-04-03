package com.google.android.libraries.places.internal;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class zziy implements Iterator, j$.util.Iterator {
    final /* synthetic */ zziz zza;
    private int zzb = 0;

    public zziy(zziz zziz) {
        this.zza = zziz;
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public final boolean hasNext() {
        int i11 = this.zzb;
        zziz zziz = this.zza;
        return i11 < zziz.zza() - zziz.zzb();
    }

    public final Object next() {
        int i11 = this.zzb;
        zziz zziz = this.zza;
        if (i11 < zziz.zza() - zziz.zzb()) {
            Object obj = this.zza.zzb.zzb[this.zza.zzb() + i11];
            this.zzb = i11 + 1;
            return obj;
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
