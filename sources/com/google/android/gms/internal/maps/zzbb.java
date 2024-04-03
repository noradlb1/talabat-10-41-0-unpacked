package com.google.android.gms.internal.maps;

import java.util.NoSuchElementException;

final class zzbb extends zzbf {
    boolean zza;
    final /* synthetic */ Object zzb;

    public zzbb(Object obj) {
        this.zzb = obj;
    }

    public final boolean hasNext() {
        return !this.zza;
    }

    public final Object next() {
        if (!this.zza) {
            this.zza = true;
            return this.zzb;
        }
        throw new NoSuchElementException();
    }
}
