package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.InvalidKeyException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzha  reason: invalid package */
public final class zzha extends zzhb {
    public zzha(byte[] bArr, int i11) throws InvalidKeyException {
        super(bArr, i11);
    }

    public final int zza() {
        return 12;
    }

    public final int[] zzb(int[] iArr, int i11) {
        int length = iArr.length;
        if (length == 3) {
            int[] iArr2 = new int[16];
            zzgx.zzb(iArr2, this.zza);
            iArr2[12] = i11;
            System.arraycopy(iArr, 0, iArr2, 13, 3);
            return iArr2;
        }
        throw new IllegalArgumentException(String.format("ChaCha20 uses 96-bit nonces, but got a %d-bit nonce", new Object[]{Integer.valueOf(length * 32)}));
    }
}
