package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlk  reason: invalid package */
public abstract class zzlk {
    private final Class zza;
    private final Class zzb;

    public /* synthetic */ zzlk(Class cls, Class cls2, zzlj zzlj) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public static zzlk zzb(zzli zzli, Class cls, Class cls2) {
        return new zzlh(cls, cls2, zzli);
    }

    public abstract Object zza(zzbm zzbm) throws GeneralSecurityException;

    public final Class zzc() {
        return this.zza;
    }

    public final Class zzd() {
        return this.zzb;
    }
}
