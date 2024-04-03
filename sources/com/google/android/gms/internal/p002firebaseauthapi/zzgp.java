package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgp  reason: invalid package */
public final class zzgp extends zzkl {
    public zzgp() {
        super(zzuj.class, new zzgn(zzbd.class));
    }

    public final zzkk zza() {
        return new zzgo(this, zzum.class);
    }

    public final zzsw zzb() {
        return zzsw.SYMMETRIC;
    }

    public final /* synthetic */ zzaif zzc(zzafv zzafv) throws zzahi {
        return zzuj.zzd(zzafv, zzagn.zza());
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key";
    }

    public final /* bridge */ /* synthetic */ void zze(zzaif zzaif) throws GeneralSecurityException {
        zzuj zzuj = (zzuj) zzaif;
        zzwc.zzc(zzuj.zza(), 0);
        if (zzuj.zze().zzd() != 32) {
            throw new GeneralSecurityException("invalid XChaCha20Poly1305Key: incorrect key length");
        }
    }
}
