package com.google.android.libraries.places.internal;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

abstract class zzex<T> implements Iterator<T>, j$.util.Iterator {
    @CheckForNull
    private T zza;
    private int zzb = 2;

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public final boolean hasNext() {
        boolean z11;
        if (this.zzb != 4) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzfm.zzh(z11);
        int i11 = this.zzb;
        int i12 = i11 - 1;
        if (i11 == 0) {
            throw null;
        } else if (i12 == 0) {
            return true;
        } else {
            if (i12 != 2) {
                this.zzb = 4;
                this.zza = zza();
                if (this.zzb != 3) {
                    this.zzb = 1;
                    return true;
                }
            }
            return false;
        }
    }

    public final T next() {
        if (hasNext()) {
            this.zzb = 2;
            T t11 = this.zza;
            this.zza = null;
            return t11;
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @CheckForNull
    public abstract T zza();

    @CheckForNull
    public final T zzb() {
        this.zzb = 3;
        return null;
    }
}
