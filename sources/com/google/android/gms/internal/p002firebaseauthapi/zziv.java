package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zziv  reason: invalid package */
final class zziv implements zziy {
    private final int zza;

    public zziv(int i11) throws InvalidAlgorithmParameterException {
        if (i11 == 16 || i11 == 32) {
            this.zza = i11;
            return;
        }
        throw new InvalidAlgorithmParameterException("Unsupported key length: " + i11);
    }

    public final int zza() {
        return this.zza;
    }

    public final byte[] zzb() throws GeneralSecurityException {
        int i11 = this.zza;
        if (i11 == 16) {
            return zzjk.zzi;
        }
        if (i11 == 32) {
            return zzjk.zzj;
        }
        throw new GeneralSecurityException("Could not determine HPKE AEAD ID");
    }

    public final byte[] zzc(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) throws GeneralSecurityException {
        int length = bArr.length;
        if (length == this.zza) {
            return new zzgz(bArr, false).zza(bArr2, bArr3, bArr4);
        }
        throw new InvalidAlgorithmParameterException("Unexpected key length: " + length);
    }
}
