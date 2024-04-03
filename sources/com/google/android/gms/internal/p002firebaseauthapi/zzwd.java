package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.common.primitives.SignedBytes;
import java.security.InvalidKeyException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwd  reason: invalid package */
public final class zzwd {
    public static byte[] zza(byte[] bArr, byte[] bArr2) throws InvalidKeyException {
        if (bArr.length == 32) {
            long[] jArr = new long[11];
            byte[] copyOf = Arrays.copyOf(bArr, 32);
            copyOf[0] = (byte) (copyOf[0] & 248);
            byte b11 = copyOf[31] & Byte.MAX_VALUE;
            copyOf[31] = (byte) b11;
            copyOf[31] = (byte) (b11 | SignedBytes.MAX_POWER_OF_TWO);
            zzjx.zza(jArr, copyOf, bArr2);
            return zzjz.zzj(jArr);
        }
        throw new InvalidKeyException("Private key must have 32 bytes.");
    }

    public static byte[] zzb(byte[] bArr) throws InvalidKeyException {
        if (bArr.length == 32) {
            byte[] bArr2 = new byte[32];
            bArr2[0] = 9;
            return zza(bArr, bArr2);
        }
        throw new InvalidKeyException("Private key must have 32 bytes.");
    }
}
