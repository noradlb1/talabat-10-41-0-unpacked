package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznw  reason: invalid package */
public final class zznw {
    @Deprecated
    static final zzug zza;
    @Deprecated
    static final zzug zzb;
    @Deprecated
    static final zzug zzc;

    static {
        new zznk();
        zzug zzb2 = zzug.zzb();
        zza = zzb2;
        zzb = zzb2;
        zzc = zzb2;
        try {
            zza();
        } catch (GeneralSecurityException e11) {
            throw new ExceptionInInitializerError(e11);
        }
    }

    public static void zza() throws GeneralSecurityException {
        zzob.zze();
        zznc.zzd();
        zznk.zzh(true);
        if (!zzhk.zzb()) {
            zzmo.zzi(true);
        }
    }
}
