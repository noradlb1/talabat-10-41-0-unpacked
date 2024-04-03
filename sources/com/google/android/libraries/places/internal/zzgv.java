package com.google.android.libraries.places.internal;

import com.google.firebase.analytics.FirebaseAnalytics;

final class zzgv extends zzge<Object> {
    private final transient Object[] zza;
    private final transient int zzb;
    private final transient int zzc;

    public zzgv(Object[] objArr, int i11, int i12) {
        this.zza = objArr;
        this.zzb = i11;
        this.zzc = i12;
    }

    public final Object get(int i11) {
        zzfm.zza(i11, this.zzc, FirebaseAnalytics.Param.INDEX);
        Object obj = this.zza[i11 + i11 + this.zzb];
        obj.getClass();
        return obj;
    }

    public final int size() {
        return this.zzc;
    }

    public final boolean zzf() {
        return true;
    }
}
