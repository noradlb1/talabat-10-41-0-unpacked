package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzod  reason: invalid package */
public final class zzod implements zzmz {
    private final zzmk zza;

    public zzod(zzmk zzmk) throws GeneralSecurityException {
        if (zzhj.zza(1)) {
            this.zza = zzmk;
            return;
        }
        throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
    }
}
