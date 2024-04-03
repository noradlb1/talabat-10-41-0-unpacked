package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgl  reason: invalid package */
public final class zzgl extends zzkl {
    public zzgl() {
        super(zzty.class, new zzgj(zzbd.class));
    }

    public final zzkk zza() {
        return new zzgk(this, zzub.class);
    }

    public final zzsw zzb() {
        return zzsw.REMOTE;
    }

    public final /* synthetic */ zzaif zzc(zzafv zzafv) throws zzahi {
        return zzty.zzd(zzafv, zzagn.zza());
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey";
    }

    public final /* bridge */ /* synthetic */ void zze(zzaif zzaif) throws GeneralSecurityException {
        zzty zzty = (zzty) zzaif;
        zzwc.zzc(zzty.zza(), 0);
        if (!zzgi.zzc(zzty.zze().zza().zzg())) {
            String zzg = zzty.zze().zza().zzg();
            throw new GeneralSecurityException("Unsupported DEK key type: " + zzg + ". Only Tink AEAD key types are supported.");
        }
    }
}
