package com.google.crypto.tink.subtle;

import com.google.common.primitives.SignedBytes;
import com.google.crypto.tink.annotations.Alpha;
import java.security.InvalidKeyException;
import java.util.Arrays;
import okio.Utf8;

@Alpha
public final class X25519 {
    private X25519() {
    }

    public static byte[] computeSharedSecret(byte[] bArr, byte[] bArr2) throws InvalidKeyException {
        if (bArr.length == 32) {
            long[] jArr = new long[11];
            byte[] copyOf = Arrays.copyOf(bArr, 32);
            copyOf[0] = (byte) (copyOf[0] & 248);
            byte b11 = (byte) (copyOf[31] & Byte.MAX_VALUE);
            copyOf[31] = b11;
            copyOf[31] = (byte) (b11 | SignedBytes.MAX_POWER_OF_TWO);
            Curve25519.curveMult(jArr, copyOf, bArr2);
            return Field25519.contract(jArr);
        }
        throw new InvalidKeyException("Private key must have 32 bytes.");
    }

    public static byte[] generatePrivateKey() {
        byte[] randBytes = Random.randBytes(32);
        randBytes[0] = (byte) (randBytes[0] | 7);
        byte b11 = (byte) (randBytes[31] & Utf8.REPLACEMENT_BYTE);
        randBytes[31] = b11;
        randBytes[31] = (byte) (b11 | 128);
        return randBytes;
    }

    public static byte[] publicFromPrivate(byte[] bArr) throws InvalidKeyException {
        if (bArr.length == 32) {
            byte[] bArr2 = new byte[32];
            bArr2[0] = 9;
            return computeSharedSecret(bArr, bArr2);
        }
        throw new InvalidKeyException("Private key must have 32 bytes.");
    }
}
