package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjj  reason: invalid package */
public final class zzjj extends zzkl {
    public zzjj() {
        super(zzss.class, new zzji(zzbl.class));
    }

    public final zzsw zzb() {
        return zzsw.ASYMMETRIC_PUBLIC;
    }

    public final /* synthetic */ zzaif zzc(zzafv zzafv) throws zzahi {
        return zzss.zzf(zzafv, zzagn.zza());
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.HpkePublicKey";
    }

    public final /* bridge */ /* synthetic */ void zze(zzaif zzaif) throws GeneralSecurityException {
        zzss zzss = (zzss) zzaif;
        zzwc.zzc(zzss.zza(), 0);
        if (zzss.zzl()) {
            zzjk.zza(zzss.zzb());
            return;
        }
        throw new GeneralSecurityException("Missing HPKE key params.");
    }
}
