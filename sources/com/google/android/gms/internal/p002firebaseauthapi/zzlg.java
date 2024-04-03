package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlg  reason: invalid package */
public abstract class zzlg {
    private final Class zza;
    private final Class zzb;

    public /* synthetic */ zzlg(Class cls, Class cls2, zzlf zzlf) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public static zzlg zzb(zzle zzle, Class cls, Class cls2) {
        return new zzld(cls, cls2, zzle);
    }

    public abstract zzlw zza(zzce zzce) throws GeneralSecurityException;

    public final Class zzc() {
        return this.zza;
    }

    public final Class zzd() {
        return this.zzb;
    }
}
