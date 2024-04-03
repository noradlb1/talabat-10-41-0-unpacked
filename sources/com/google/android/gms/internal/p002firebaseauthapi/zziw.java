package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zziw  reason: invalid package */
final class zziw implements zziy {
    public final int zza() {
        return 32;
    }

    public final byte[] zzb() {
        return zzjk.zzk;
    }

    public final byte[] zzc(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) throws GeneralSecurityException {
        if (bArr.length == 32) {
            return new zzhc(bArr).zzc(bArr2, bArr3, bArr4);
        }
        throw new InvalidAlgorithmParameterException("Unexpected key length: 32");
    }
}
