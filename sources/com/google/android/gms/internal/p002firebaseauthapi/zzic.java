package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzic  reason: invalid package */
public final class zzic {
    public static final String zza = "type.googleapis.com/google.crypto.tink.AesSivKey";
    @Deprecated
    static final zzug zzb = zzug.zzb();
    @Deprecated
    static final zzug zzc = zzug.zzb();

    static {
        new zzhr();
        try {
            zza();
        } catch (GeneralSecurityException e11) {
            throw new ExceptionInInitializerError(e11);
        }
    }

    public static void zza() throws GeneralSecurityException {
        zzig.zze();
        if (!zzhk.zzb()) {
            zzcq.zzg(new zzhr(), true);
            int i11 = zzib.zza;
            zzib.zzd(zzky.zzc());
        }
    }
}
