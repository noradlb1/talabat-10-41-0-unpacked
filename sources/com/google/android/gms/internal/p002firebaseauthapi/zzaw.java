package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.analytics.FirebaseAnalytics;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaw  reason: invalid package */
final class zzaw extends zzam {
    private final transient Object[] zza;
    private final transient int zzb;
    private final transient int zzc;

    public zzaw(Object[] objArr, int i11, int i12) {
        this.zza = objArr;
        this.zzb = i11;
        this.zzc = i12;
    }

    public final Object get(int i11) {
        zzu.zza(i11, this.zzc, FirebaseAnalytics.Param.INDEX);
        Object obj = this.zza[i11 + i11 + this.zzb];
        obj.getClass();
        return obj;
    }

    public final int size() {
        return this.zzc;
    }
}
