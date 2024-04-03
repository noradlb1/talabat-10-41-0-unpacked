package com.google.android.libraries.places.internal;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

final class zzgj<F, T> extends AbstractList<T> implements RandomAccess, Serializable {
    final List<F> zza;
    final zzi zzb;

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.android.libraries.places.internal.zzi, java.util.List<F>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzgj(java.util.List r1, java.util.List<F> r2, com.google.android.libraries.places.internal.zzi r3) {
        /*
            r0 = this;
            r0.<init>()
            r1.getClass()
            r0.zza = r1
            r0.zzb = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzgj.<init>(java.util.List, com.google.android.libraries.places.internal.zzi, byte[]):void");
    }

    public final void clear() {
        this.zza.clear();
    }

    public final T get(int i11) {
        return ((zzj) this.zza.get(i11)).toString();
    }

    public final boolean isEmpty() {
        return this.zza.isEmpty();
    }

    public final Iterator<T> iterator() {
        return listIterator();
    }

    public final ListIterator<T> listIterator(int i11) {
        return new zzgi(this, this.zza.listIterator(i11));
    }

    public final T remove(int i11) {
        return ((zzj) this.zza.remove(i11)).toString();
    }

    public final int size() {
        return this.zza.size();
    }
}
