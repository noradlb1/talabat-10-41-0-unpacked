package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbv  reason: invalid package */
public final class zzbv {
    public static zzbu zza(String str) throws GeneralSecurityException {
        zzbu zzbu = (zzbu) zzcq.zze().get(str);
        if (zzbu != null) {
            return zzbu;
        }
        throw new GeneralSecurityException("cannot find key template: ".concat(str));
    }
}
