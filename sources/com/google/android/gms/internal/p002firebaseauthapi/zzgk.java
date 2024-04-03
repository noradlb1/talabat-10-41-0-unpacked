package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgk  reason: invalid package */
final class zzgk extends zzkk {
    final /* synthetic */ zzgl zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzgk(zzgl zzgl, Class cls) {
        super(cls);
        this.zza = zzgl;
    }

    public final /* bridge */ /* synthetic */ zzaif zza(zzaif zzaif) throws GeneralSecurityException {
        zztx zzb = zzty.zzb();
        zzb.zza((zzub) zzaif);
        zzb.zzb(0);
        return (zzty) zzb.zzi();
    }

    public final /* synthetic */ zzaif zzb(zzafv zzafv) throws zzahi {
        return zzub.zzd(zzafv, zzagn.zza());
    }

    public final /* bridge */ /* synthetic */ void zzd(zzaif zzaif) throws GeneralSecurityException {
        zzub zzub = (zzub) zzaif;
        if (!zzgi.zzc(zzub.zza().zzg())) {
            String zzg = zzub.zza().zzg();
            throw new GeneralSecurityException("Unsupported DEK key type: " + zzg + ". Only Tink AEAD key types are supported.");
        } else if (zzub.zze().isEmpty() || !zzub.zzf()) {
            throw new GeneralSecurityException("invalid key format: missing KEK URI or DEK template");
        }
    }
}
