package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgh  reason: invalid package */
public final class zzgh extends zzkl {
    public zzgh() {
        super(zzts.class, new zzgf(zzbd.class));
    }

    public final zzkk zza() {
        return new zzgg(this, zztv.class);
    }

    public final zzsw zzb() {
        return zzsw.REMOTE;
    }

    public final /* synthetic */ zzaif zzc(zzafv zzafv) throws zzahi {
        return zzts.zzd(zzafv, zzagn.zza());
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.KmsAeadKey";
    }

    public final /* bridge */ /* synthetic */ void zze(zzaif zzaif) throws GeneralSecurityException {
        zzwc.zzc(((zzts) zzaif).zza(), 0);
    }
}
