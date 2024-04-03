package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzje  reason: invalid package */
final class zzje {
    public static zziy zza(zzsm zzsm) throws GeneralSecurityException {
        if (zzsm.zzd() == 3) {
            return new zziv(16);
        }
        if (zzsm.zzd() == 4) {
            return new zziv(32);
        }
        if (zzsm.zzd() == 5) {
            return new zziw();
        }
        throw new IllegalArgumentException("Unrecognized HPKE AEAD identifier");
    }

    public static zzjc zzb(zzsm zzsm) throws GeneralSecurityException {
        if (zzsm.zzf() == 3) {
            return new zzjn(new zzix("HmacSha256"));
        }
        if (zzsm.zzf() == 4) {
            return zzjl.zzc(1);
        }
        if (zzsm.zzf() == 5) {
            return zzjl.zzc(2);
        }
        if (zzsm.zzf() == 6) {
            return zzjl.zzc(3);
        }
        throw new IllegalArgumentException("Unrecognized HPKE KEM identifier");
    }

    public static zzix zzc(zzsm zzsm) {
        if (zzsm.zze() == 3) {
            return new zzix("HmacSha256");
        }
        if (zzsm.zze() == 4) {
            return new zzix("HmacSha384");
        }
        if (zzsm.zze() == 5) {
            return new zzix("HmacSha512");
        }
        throw new IllegalArgumentException("Unrecognized HPKE KDF identifier");
    }
}
