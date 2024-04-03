package com.google.android.gms.internal.ads;

import java.security.InvalidKeyException;

final class zzghd extends zzghe {
    public zzghd(byte[] bArr, int i11) throws InvalidKeyException {
        super(bArr, i11);
    }

    public final int zzb() {
        return 12;
    }

    public final int[] zzc(int[] iArr, int i11) {
        int length = iArr.length;
        if (length == 3) {
            int[] iArr2 = new int[16];
            zzghe.zzg(iArr2, this.zza);
            iArr2[12] = i11;
            System.arraycopy(iArr, 0, iArr2, 13, 3);
            return iArr2;
        }
        throw new IllegalArgumentException(String.format("ChaCha20 uses 96-bit nonces, but got a %d-bit nonce", new Object[]{Integer.valueOf(length * 32)}));
    }
}
