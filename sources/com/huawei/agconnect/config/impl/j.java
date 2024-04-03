package com.huawei.agconnect.config.impl;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class j {
    public static SecretKey a(d dVar) throws NoSuchAlgorithmException, InvalidKeySpecException {
        if (dVar == null || !dVar.a()) {
            throw new IllegalArgumentException("invalid data for generating the key.");
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("build aes key, iterationCount:");
        sb2.append(dVar.g());
        return new SecretKeySpec(SecretKeyFactory.getInstance(dVar.f()).generateSecret(new PBEKeySpec(Hex.encodeHexString(a(Hex.decodeHexString(dVar.b()), Hex.decodeHexString(dVar.c()), Hex.decodeHexString(dVar.d()))).toCharArray(), Hex.decodeHexString(dVar.e()), dVar.g(), dVar.h() * 8)).getEncoded(), "AES");
    }

    public static byte[] a(SecretKey secretKey, byte[] bArr) throws GeneralSecurityException {
        if (secretKey == null || bArr == null) {
            throw new NullPointerException("key or cipherText must not be null.");
        }
        byte[] copyOfRange = Arrays.copyOfRange(bArr, 1, 17);
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(2, secretKey, new IvParameterSpec(copyOfRange));
        return instance.doFinal(bArr, copyOfRange.length + 1, (bArr.length - copyOfRange.length) - 1);
    }

    private static byte[] a(byte[] bArr, int i11) {
        if (bArr != null) {
            for (int i12 = 0; i12 < bArr.length; i12++) {
                if (i11 < 0) {
                    bArr[i12] = (byte) (bArr[i12] << (-i11));
                } else {
                    bArr[i12] = (byte) (bArr[i12] >> i11);
                }
            }
            return bArr;
        }
        throw new NullPointerException("bytes must not be null.");
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            throw new NullPointerException("left or right must not be null.");
        } else if (bArr.length == bArr2.length) {
            byte[] bArr3 = new byte[bArr.length];
            for (int i11 = 0; i11 < bArr.length; i11++) {
                bArr3[i11] = (byte) (bArr[i11] ^ bArr2[i11]);
            }
            return bArr3;
        } else {
            throw new IllegalArgumentException("left and right must be the same length.");
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return a(a(a(a(bArr, -4), bArr2), 6), bArr3);
    }
}
