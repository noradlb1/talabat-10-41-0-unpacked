package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzke  reason: invalid package */
public abstract class zzke {
    private final zzwf zza;
    private final Class zzb;

    public /* synthetic */ zzke(zzwf zzwf, Class cls, zzkd zzkd) {
        this.zza = zzwf;
        this.zzb = cls;
    }

    public static zzke zzb(zzkc zzkc, zzwf zzwf, Class cls) {
        return new zzkb(zzwf, cls, zzkc);
    }

    public abstract zzbm zza(zzlw zzlw, @Nullable zzcr zzcr) throws GeneralSecurityException;

    public final zzwf zzc() {
        return this.zza;
    }

    public final Class zzd() {
        return this.zzb;
    }
}
