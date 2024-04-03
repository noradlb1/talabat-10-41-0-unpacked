package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhr  reason: invalid package */
public final class zzhr extends zzkl {
    public zzhr() {
        super(zzql.class, new zzhp(zzbj.class));
    }

    public final zzkk zza() {
        return new zzhq(this, zzqo.class);
    }

    public final zzsw zzb() {
        return zzsw.SYMMETRIC;
    }

    public final /* synthetic */ zzaif zzc(zzafv zzafv) throws zzahi {
        return zzql.zzd(zzafv, zzagn.zza());
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.AesSivKey";
    }

    public final /* bridge */ /* synthetic */ void zze(zzaif zzaif) throws GeneralSecurityException {
        zzql zzql = (zzql) zzaif;
        zzwc.zzc(zzql.zza(), 0);
        if (zzql.zze().zzd() != 64) {
            int zzd = zzql.zze().zzd();
            throw new InvalidKeyException("invalid key size: " + zzd + ". Valid keys must have 64 bytes.");
        }
    }
}
