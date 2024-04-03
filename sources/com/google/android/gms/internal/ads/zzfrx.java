package com.google.android.gms.internal.ads;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class zzfrx<T> implements Iterator<T>, j$.util.Iterator {
    int zzb;
    int zzc;
    int zzd = -1;
    final /* synthetic */ zzfsb zze;

    public /* synthetic */ zzfrx(zzfsb zzfsb, zzfrw zzfrw) {
        this.zze = zzfsb;
        this.zzb = zzfsb.zzf;
        this.zzc = zzfsb.zze();
    }

    private final void zzb() {
        if (this.zze.zzf != this.zzb) {
            throw new ConcurrentModificationException();
        }
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public final boolean hasNext() {
        return this.zzc >= 0;
    }

    public final T next() {
        zzb();
        if (hasNext()) {
            int i11 = this.zzc;
            this.zzd = i11;
            T zza = zza(i11);
            this.zzc = this.zze.zzf(this.zzc);
            return zza;
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        boolean z11;
        zzb();
        if (this.zzd >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzfqg.zzg(z11, "no calls to next() since the last call to remove()");
        this.zzb += 32;
        zzfsb zzfsb = this.zze;
        zzfsb.remove(zzfsb.zzg(zzfsb, this.zzd));
        this.zzc--;
        this.zzd = -1;
    }

    public abstract T zza(int i11);
}
