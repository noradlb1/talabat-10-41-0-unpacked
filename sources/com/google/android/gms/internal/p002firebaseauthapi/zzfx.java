package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfx  reason: invalid package */
public final class zzfx extends zzkl {
    public zzfx() {
        super(zzqr.class, new zzfv(zzbd.class));
    }

    public final zzkk zza() {
        return new zzfw(this, zzqu.class);
    }

    public final zzsw zzb() {
        return zzsw.SYMMETRIC;
    }

    public final /* synthetic */ zzaif zzc(zzafv zzafv) throws zzahi {
        return zzqr.zzd(zzafv, zzagn.zza());
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key";
    }

    public final /* bridge */ /* synthetic */ void zze(zzaif zzaif) throws GeneralSecurityException {
        zzqr zzqr = (zzqr) zzaif;
        zzwc.zzc(zzqr.zza(), 0);
        if (zzqr.zze().zzd() != 32) {
            throw new GeneralSecurityException("invalid ChaCha20Poly1305Key: incorrect key length");
        }
    }
}
