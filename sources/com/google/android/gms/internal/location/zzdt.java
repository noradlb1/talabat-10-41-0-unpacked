package com.google.android.gms.internal.location;

import com.google.firebase.analytics.FirebaseAnalytics;

final class zzdt extends zzds {
    static final zzds zza = new zzdt(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    public zzdt(Object[] objArr, int i11) {
        this.zzb = objArr;
        this.zzc = i11;
    }

    public final Object get(int i11) {
        zzdm.zza(i11, this.zzc, FirebaseAnalytics.Param.INDEX);
        Object obj = this.zzb[i11];
        obj.getClass();
        return obj;
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
