package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

public final class zzfzc {
    public static final String zza = "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    public static final String zzb = "type.googleapis.com/google.crypto.tink.AesGcmKey";
    @Deprecated
    public static final zzggm zzc;
    @Deprecated
    public static final zzggm zzd;
    @Deprecated
    public static final zzggm zze;

    static {
        new zzfzi();
        new zzfzr();
        new zzfzu();
        new zzfzo();
        new zzgaa();
        new zzgae();
        new zzfzx();
        new zzgah();
        zzggm zzc2 = zzggm.zzc();
        zzc = zzc2;
        zzd = zzc2;
        zze = zzc2;
        try {
            zza();
        } catch (GeneralSecurityException e11) {
            throw new ExceptionInInitializerError(e11);
        }
    }

    public static void zza() throws GeneralSecurityException {
        zzfza.zzn(new zzfzf());
        zzgbm.zza();
        zzfza.zzm(new zzfzi(), true);
        zzfza.zzm(new zzfzr(), true);
        if (!zzgal.zzb()) {
            zzfza.zzm(new zzfzo(), true);
            zzfzu.zzk(true);
            zzfza.zzm(new zzfzx(), true);
            zzfza.zzm(new zzgaa(), true);
            zzfza.zzm(new zzgae(), true);
            zzfza.zzm(new zzgah(), true);
        }
    }
}
