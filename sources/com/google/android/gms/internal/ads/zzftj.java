package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.List;
import java.util.ListIterator;

final class zzftj<F, T> extends AbstractSequentialList<T> implements Serializable {
    final List<F> zza;
    final zzfpv<? super F, ? extends T> zzb;

    public zzftj(List<F> list, zzfpv<? super F, ? extends T> zzfpv) {
        this.zza = list;
        this.zzb = zzfpv;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final ListIterator<T> listIterator(int i11) {
        return new zzfti(this, this.zza.listIterator(i11));
    }

    public final int size() {
        return this.zza.size();
    }
}
