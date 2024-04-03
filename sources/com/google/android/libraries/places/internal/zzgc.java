package com.google.android.libraries.places.internal;

final class zzgc<E> extends zzfs<E> {
    private final zzge<E> zza;

    public zzgc(zzge<E> zzge, int i11) {
        super(zzge.size(), i11);
        this.zza = zzge;
    }

    public final E zza(int i11) {
        return this.zza.get(i11);
    }
}
