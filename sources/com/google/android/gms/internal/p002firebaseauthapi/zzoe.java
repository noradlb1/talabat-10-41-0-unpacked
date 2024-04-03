package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzoe  reason: invalid package */
public final class zzoe implements zzmz {
    private final zzng zza;

    public zzoe(zzng zzng) throws GeneralSecurityException {
        if (zzhj.zza(2)) {
            this.zza = zzng;
            return;
        }
        throw new GeneralSecurityException("Can not use HMAC in FIPS-mode, as BoringCrypto module is not available.");
    }
}
