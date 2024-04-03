package com.google.android.gms.internal.ads;

import java.security.InvalidKeyException;
import java.util.Arrays;

final class zzgij extends zzghe {
    public zzgij(byte[] bArr, int i11) throws InvalidKeyException {
        super(bArr, i11);
    }

    public final int zzb() {
        return 24;
    }

    public final int[] zzc(int[] iArr, int i11) {
        int length = iArr.length;
        if (length == 6) {
            int[] iArr2 = new int[16];
            int[] iArr3 = new int[16];
            zzghe.zzg(iArr3, this.zza);
            iArr3[12] = iArr[0];
            iArr3[13] = iArr[1];
            iArr3[14] = iArr[2];
            iArr3[15] = iArr[3];
            zzghe.zzh(iArr3);
            iArr3[4] = iArr3[12];
            iArr3[5] = iArr3[13];
            iArr3[6] = iArr3[14];
            iArr3[7] = iArr3[15];
            zzghe.zzg(iArr2, Arrays.copyOf(iArr3, 8));
            iArr2[12] = i11;
            iArr2[13] = 0;
            iArr2[14] = iArr[4];
            iArr2[15] = iArr[5];
            return iArr2;
        }
        throw new IllegalArgumentException(String.format("XChaCha20 uses 192-bit nonces, but got a %d-bit nonce", new Object[]{Integer.valueOf(length * 32)}));
    }
}
