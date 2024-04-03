package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.analytics.FirebaseAnalytics;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzas  reason: invalid package */
final class zzas extends zzam {
    static final zzam zza = new zzas(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    public zzas(Object[] objArr, int i11) {
        this.zzb = objArr;
        this.zzc = i11;
    }

    public final Object get(int i11) {
        zzu.zza(i11, this.zzc, FirebaseAnalytics.Param.INDEX);
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

    public final Object[] zze() {
        return this.zzb;
    }
}
