package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public final class zzgpi<E> extends AbstractList<E> {
    private static final zzgpj zzc = zzgpj.zzb(zzgpi.class);
    final List<E> zza;
    final Iterator<E> zzb;

    public zzgpi(List<E> list, Iterator<E> it) {
        this.zza = list;
        this.zzb = it;
    }

    public final E get(int i11) {
        if (this.zza.size() > i11) {
            return this.zza.get(i11);
        }
        if (this.zzb.hasNext()) {
            this.zza.add(this.zzb.next());
            return get(i11);
        }
        throw new NoSuchElementException();
    }

    public final Iterator<E> iterator() {
        return new zzgph(this);
    }

    public final int size() {
        zzgpj zzgpj = zzc;
        zzgpj.zza("potentially expensive size() call");
        zzgpj.zza("blowup running");
        while (this.zzb.hasNext()) {
            this.zza.add(this.zzb.next());
        }
        return this.zza.size();
    }
}
