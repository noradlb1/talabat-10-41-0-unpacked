package com.google.android.libraries.places.internal;

import com.google.firebase.analytics.FirebaseAnalytics;

final class zzgr<E> extends zzge<E> {
    static final zzge<Object> zza = new zzgr(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    public zzgr(Object[] objArr, int i11) {
        this.zzb = objArr;
        this.zzc = i11;
    }

    public final E get(int i11) {
        zzfm.zza(i11, this.zzc, FirebaseAnalytics.Param.INDEX);
        E e11 = this.zzb[i11];
        e11.getClass();
        return e11;
    }

    public final int size() {
        return this.zzc;
    }

    public final int zza(Object[] objArr, int i11) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzc);
        return this.zzc;
    }

    public final int zzb() {
        return this.zzc;
    }

    public final int zzc() {
        return 0;
    }

    public final boolean zzf() {
        return false;
    }

    public final Object[] zzg() {
        return this.zzb;
    }
}
