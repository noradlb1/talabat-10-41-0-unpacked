package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

public final class zzgbm {
    @Deprecated
    public static final zzggm zza;
    @Deprecated
    public static final zzggm zzb;
    @Deprecated
    public static final zzggm zzc;

    static {
        new zzgbl();
        zzggm zzc2 = zzggm.zzc();
        zza = zzc2;
        zzb = zzc2;
        zzc = zzc2;
        try {
            zza();
        } catch (GeneralSecurityException e11) {
            throw new ExceptionInInitializerError(e11);
        }
    }

    public static void zza() throws GeneralSecurityException {
        zzfza.zzn(new zzgbp());
        zzfza.zzm(new zzgbl(), true);
        if (!zzgal.zzb()) {
            zzfza.zzm(new zzgbi(), true);
        }
    }
}
