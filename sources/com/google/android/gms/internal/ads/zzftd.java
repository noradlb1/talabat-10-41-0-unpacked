package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

final class zzftd extends zzfuu {
    boolean zza;
    final /* synthetic */ Object zzb;

    public zzftd(Object obj) {
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
