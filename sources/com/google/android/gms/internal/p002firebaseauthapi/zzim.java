package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzim  reason: invalid package */
final class zzim extends zzkl {
    public zzim() {
        super(zzrl.class, new zzil(zzbl.class));
    }

    public final zzsw zzb() {
        return zzsw.ASYMMETRIC_PUBLIC;
    }

    public final /* synthetic */ zzaif zzc(zzafv zzafv) throws zzahi {
        return zzrl.zzf(zzafv, zzagn.zza());
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey";
    }

    public final /* bridge */ /* synthetic */ void zze(zzaif zzaif) throws GeneralSecurityException {
        zzrl zzrl = (zzrl) zzaif;
        zzwc.zzc(zzrl.zza(), 0);
        zzit.zza(zzrl.zzb());
    }
}
