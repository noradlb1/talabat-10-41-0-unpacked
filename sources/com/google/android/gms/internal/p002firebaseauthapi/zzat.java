package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.AbstractMap;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzat  reason: invalid package */
final class zzat extends zzam {
    final /* synthetic */ zzau zza;

    public zzat(zzau zzau) {
        this.zza = zzau;
    }

    public final /* bridge */ /* synthetic */ Object get(int i11) {
        zzu.zza(i11, this.zza.zzc, FirebaseAnalytics.Param.INDEX);
        zzau zzau = this.zza;
        int i12 = i11 + i11;
        Object obj = zzau.zzb[i12];
        obj.getClass();
        Object obj2 = zzau.zzb[i12 + 1];
        obj2.getClass();
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    public final int size() {
        return this.zza.zzc;
    }
}
