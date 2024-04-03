package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznc  reason: invalid package */
public final class zznc implements zzcm {
    private static final zznc zza = new zznc();

    private zznc() {
    }

    public static void zzd() throws GeneralSecurityException {
        zzcq.zzh(zza);
    }

    public final Class zza() {
        return zzmz.class;
    }

    public final Class zzb() {
        return zzmz.class;
    }

    public final /* bridge */ /* synthetic */ Object zzc(zzcl zzcl) throws GeneralSecurityException {
        if (zzcl.zza() != null) {
            for (List<zzch> it : zzcl.zzd()) {
                for (zzch zzd : it) {
                    zzd.zzd();
                }
            }
            return new zznb(zzcl, (zzna) null);
        }
        throw new GeneralSecurityException("no primary in primitive set");
    }
}
