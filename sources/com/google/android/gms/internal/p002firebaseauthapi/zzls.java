package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzls  reason: invalid package */
public abstract class zzls extends zzkl {
    private final Class zza;

    @SafeVarargs
    public zzls(Class cls, Class cls2, zzll... zzllArr) {
        super(cls, zzllArr);
        this.zza = cls2;
    }

    public abstract zzaif zzg(zzaif zzaif) throws GeneralSecurityException;
}
