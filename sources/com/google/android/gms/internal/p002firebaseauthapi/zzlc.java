package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlc  reason: invalid package */
public abstract class zzlc {
    private final zzwf zza;
    private final Class zzb;

    public /* synthetic */ zzlc(zzwf zzwf, Class cls, zzlb zzlb) {
        this.zza = zzwf;
        this.zzb = cls;
    }

    public static zzlc zzb(zzla zzla, zzwf zzwf, Class cls) {
        return new zzkz(zzwf, cls, zzla);
    }

    public abstract zzce zza(zzlw zzlw) throws GeneralSecurityException;

    public final zzwf zzc() {
        return this.zza;
    }

    public final Class zzd() {
        return this.zzb;
    }
}
