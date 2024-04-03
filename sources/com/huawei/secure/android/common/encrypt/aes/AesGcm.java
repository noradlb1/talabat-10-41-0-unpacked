package com.huawei.secure.android.common.encrypt.aes;

import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class AesGcm {

    /* renamed from: a  reason: collision with root package name */
    private static final String f33722a = "security:";

    /* renamed from: b  reason: collision with root package name */
    private static final String f33723b = "AES/GCM/NoPadding";

    /* renamed from: c  reason: collision with root package name */
    private static final String f33724c = "AES";

    /* renamed from: d  reason: collision with root package name */
    private static final String f33725d = "GCM";

    /* renamed from: e  reason: collision with root package name */
    private static final String f33726e = "";

    /* renamed from: f  reason: collision with root package name */
    private static final int f33727f = 16;

    /* renamed from: g  reason: collision with root package name */
    private static final int f33728g = 12;

    /* renamed from: h  reason: collision with root package name */
    private static final int f33729h = 2;

    private AesGcm() {
    }

    private static byte[] a(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            b.b("GCM", "encrypt 5 content is null");
            return new byte[0];
        } else if (bArr == null) {
            b.b("GCM", "encrypt 5 key is null");
            return new byte[0];
        } else if (bArr.length < 16) {
            b.b("GCM", "encrypt 5 key error: 5 key length less than 16 bytes.");
            return new byte[0];
        } else if (bArr2 == null) {
            b.b("GCM", "encrypt 5 iv is null");
            return new byte[0];
        } else if (bArr2.length < 12) {
            b.b("GCM", "encrypt 5 iv error: 5 iv length less than 16 bytes.");
            return new byte[0];
        } else if (!isBuildVersionHigherThan19()) {
            b.b("GCM", "encrypt 5 build version not higher than 19");
            return new byte[0];
        } else {
            try {
                return encrypt(str.getBytes("UTF-8"), bArr, bArr2);
            } catch (UnsupportedEncodingException e11) {
                b.b("GCM", "GCM encrypt data error" + e11.getMessage());
                return new byte[0];
            }
        }
    }

    private static byte[] b(byte[] bArr) {
        byte[] bArr2 = new byte[(bArr.length - 12)];
        System.arraycopy(bArr, 12, bArr2, 0, bArr.length - 12);
        return bArr2;
    }

    private static byte[] c(byte[] bArr) {
        byte[] bArr2 = new byte[12];
        System.arraycopy(bArr, 0, bArr2, 0, 12);
        return bArr2;
    }

    public static String decrypt(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            b.b("GCM", "decrypt 1 content is null");
            return "";
        } else if (TextUtils.isEmpty(str2)) {
            b.b("GCM", "decrypt 1 key is null");
            return "";
        } else if (!isBuildVersionHigherThan19()) {
            b.b("GCM", "decrypt 1 build version not higher than 19");
            return "";
        } else {
            byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str2);
            if (hexStr2ByteArray.length >= 16) {
                return decrypt(str, hexStr2ByteArray);
            }
            b.b("GCM", "decrypt 1 key error: 1 key length less than 16 bytes.");
            return "";
        }
    }

    public static String decryptWithCryptHead(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str) && bArr != null && bArr.length >= 16) {
            String c11 = AesCbc.c(str);
            if ("".equals(c11)) {
                return "";
            }
            int indexOf = c11.indexOf(58);
            if (indexOf >= 0) {
                return decrypt(HexUtil.byteArray2HexStr(HexUtil.hexStr2ByteArray(c11.substring(indexOf + 1))), bArr, HexUtil.hexStr2ByteArray(c11.substring(0, indexOf)));
            }
            b.b("GCM", " gcm cipherText data missing colon");
        }
        return "";
    }

    public static byte[] decryptWithCryptHeadReturnByte(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr2.length < 16) {
            return new byte[0];
        }
        byte[] d11 = AesCbc.d(bArr);
        if (d11.length == 0) {
            return new byte[0];
        }
        int a11 = a(d11);
        if (a11 >= 0) {
            byte[] copyOf = Arrays.copyOf(d11, a11);
            int length = (d11.length - copyOf.length) - 1;
            byte[] bArr3 = new byte[length];
            System.arraycopy(d11, a11 + 1, bArr3, 0, length);
            return decrypt(bArr3, bArr2, copyOf);
        }
        b.b("GCM", " gcm cipherText data missing colon");
        return new byte[0];
    }

    public static String encrypt(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            b.b("GCM", "encrypt 1 content is null");
            return "";
        } else if (TextUtils.isEmpty(str2)) {
            b.b("GCM", "encrypt 1 key is null");
            return "";
        } else if (!isBuildVersionHigherThan19()) {
            b.b("GCM", "encrypt 1 build version not higher than 19");
            return "";
        } else {
            byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str2);
            if (hexStr2ByteArray.length >= 16) {
                return encrypt(str, hexStr2ByteArray);
            }
            b.b("GCM", "encrypt key error: key length less than 16 bytes.");
            return "";
        }
    }

    public static AlgorithmParameterSpec getGcmAlgorithmParams(byte[] bArr) {
        return new GCMParameterSpec(128, bArr);
    }

    public static boolean isBuildVersionHigherThan19() {
        return true;
    }

    private static String b(String str) {
        if (!TextUtils.isEmpty(str) && str.length() >= 24) {
            return str.substring(0, 24);
        }
        b.b("GCM", "IV is invalid.");
        return "";
    }

    public static String decryptWithCryptHead(byte[] bArr, byte[] bArr2) {
        try {
            return new String(decryptWithCryptHeadReturnByte(bArr, bArr2), "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            b.b("GCM", "UnsupportedEncodingException");
            return "";
        }
    }

    public static String decrypt(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            b.b("GCM", "decrypt 2 content is null");
            return "";
        } else if (bArr == null) {
            b.b("GCM", "decrypt 2 key is null");
            return "";
        } else if (bArr.length < 16) {
            b.b("GCM", "decrypt 2 key error: 2 key length less than 16 bytes.");
            return "";
        } else if (!isBuildVersionHigherThan19()) {
            b.b("GCM", "decrypt 2 build version not higher than 19");
            return "";
        } else {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
                Cipher instance = Cipher.getInstance(f33723b);
                String b11 = b(str);
                String a11 = a(str);
                if (TextUtils.isEmpty(b11)) {
                    b.b("GCM", "decrypt 2 iv is null");
                    return "";
                } else if (TextUtils.isEmpty(a11)) {
                    b.b("GCM", "decrypt 2 encrypt content is null");
                    return "";
                } else {
                    instance.init(2, secretKeySpec, getGcmAlgorithmParams(HexUtil.hexStr2ByteArray(b11)));
                    return new String(instance.doFinal(HexUtil.hexStr2ByteArray(a11)), "UTF-8");
                }
            } catch (UnsupportedEncodingException | NullPointerException | GeneralSecurityException e11) {
                b.b("GCM", "GCM decrypt data exception: " + e11.getMessage());
                return "";
            }
        }
    }

    public static String encrypt(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            b.b("GCM", "encrypt 2 content is null");
            return "";
        } else if (bArr == null) {
            b.b("GCM", "encrypt 2 key is null");
            return "";
        } else if (bArr.length < 16) {
            b.b("GCM", "encrypt 2 key error: 2 key length less than 16 bytes.");
            return "";
        } else if (!isBuildVersionHigherThan19()) {
            b.b("GCM", "encrypt 2 build version not higher than 19");
            return "";
        } else {
            byte[] generateSecureRandom = EncryptUtil.generateSecureRandom(12);
            byte[] a11 = a(str, bArr, generateSecureRandom);
            if (a11 == null || a11.length == 0) {
                return "";
            }
            String byteArray2HexStr = HexUtil.byteArray2HexStr(generateSecureRandom);
            String byteArray2HexStr2 = HexUtil.byteArray2HexStr(a11);
            return byteArray2HexStr + byteArray2HexStr2;
        }
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    private static String a(String str) {
        return (TextUtils.isEmpty(str) || str.length() < 24) ? "" : str.substring(24);
    }

    private static int a(byte[] bArr) {
        return bArr[12] == 58 ? 12 : -1;
    }

    public static String encrypt(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            b.b("GCM", "encrypt 3 content is null");
            return "";
        } else if (TextUtils.isEmpty(str2)) {
            b.b("GCM", "encrypt 3 key is null");
            return "";
        } else if (TextUtils.isEmpty(str3)) {
            b.b("GCM", "encrypt 3 iv is null");
            return "";
        } else if (!isBuildVersionHigherThan19()) {
            b.b("GCM", "encrypt 3 build version not higher than 19");
            return "";
        } else {
            byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str2);
            byte[] hexStr2ByteArray2 = HexUtil.hexStr2ByteArray(str3);
            if (hexStr2ByteArray.length < 16) {
                b.b("GCM", "encrypt 3 key error: 3 key length less than 16 bytes.");
                return "";
            } else if (hexStr2ByteArray2.length >= 12) {
                return encrypt(str, hexStr2ByteArray, hexStr2ByteArray2);
            } else {
                b.b("GCM", "encrypt 3 iv error: 3 iv length less than 16 bytes.");
                return "";
            }
        }
    }

    public static String decrypt(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            b.b("GCM", "decrypt 3 content is null");
            return "";
        } else if (TextUtils.isEmpty(str2)) {
            b.b("GCM", "decrypt 3 key is null");
            return "";
        } else if (TextUtils.isEmpty(str3)) {
            b.b("GCM", "decrypt 3 iv is null");
            return "";
        } else if (!isBuildVersionHigherThan19()) {
            b.b("GCM", "decrypt 3 build version not higher than 19");
            return "";
        } else {
            byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str2);
            byte[] hexStr2ByteArray2 = HexUtil.hexStr2ByteArray(str3);
            if (hexStr2ByteArray.length < 16) {
                b.b("GCM", "decrypt 3 key error: 3 key length less than 16 bytes.");
                return "";
            } else if (hexStr2ByteArray2.length >= 12) {
                return decrypt(str, hexStr2ByteArray, hexStr2ByteArray2);
            } else {
                b.b("GCM", "decrypt 3 iv error: 3 iv length less than 16 bytes.");
                return "";
            }
        }
    }

    public static String encrypt(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            b.b("GCM", "encrypt 4 content is null");
            return "";
        } else if (bArr == null) {
            b.b("GCM", "encrypt 4 key is null");
            return "";
        } else if (bArr.length < 16) {
            b.b("GCM", "encrypt 4 key error: 3 key length less than 16 bytes.");
            return "";
        } else if (bArr2 == null) {
            b.b("GCM", "encrypt 4 iv is null");
            return "";
        } else if (bArr2.length < 12) {
            b.b("GCM", "encrypt 3 iv error: 3 iv length less than 16 bytes.");
            return "";
        } else if (isBuildVersionHigherThan19()) {
            return HexUtil.byteArray2HexStr(a(str, bArr, bArr2));
        } else {
            b.b("GCM", "encrypt 4 build version not higher than 19");
            return "";
        }
    }

    public static String decrypt(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            b.b("GCM", "decrypt 4 content is null");
            return "";
        } else if (bArr == null) {
            b.b("GCM", "decrypt 4 key is null");
            return "";
        } else if (bArr.length < 16) {
            b.b("GCM", "decrypt 4 key error: 4 key length less than 16 bytes.");
            return "";
        } else if (bArr2 == null) {
            b.b("GCM", "decrypt 4 iv is null");
            return "";
        } else if (bArr2.length < 12) {
            b.b("GCM", "decrypt 4 iv error: 4 iv length less than 16 bytes.");
            return "";
        } else if (!isBuildVersionHigherThan19()) {
            b.b("GCM", "decrypt 4 build version not higher than 19");
            return "";
        } else {
            try {
                return new String(decrypt(HexUtil.hexStr2ByteArray(str), bArr, bArr2), "UTF-8");
            } catch (UnsupportedEncodingException e11) {
                b.b("GCM", "GCM decrypt data exception: " + e11.getMessage());
                return "";
            }
        }
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null) {
            b.b("GCM", "encrypt 6 content is null");
            return new byte[0];
        } else if (bArr.length == 0) {
            b.b("GCM", "encrypt 6 content length is 0");
            return new byte[0];
        } else if (bArr2 == null) {
            b.b("GCM", "encrypt 6 key is null");
            return new byte[0];
        } else if (bArr2.length < 16) {
            b.b("GCM", "encrypt 6 key error: 6 key length less than 16 bytes.");
            return new byte[0];
        } else if (bArr3 == null) {
            b.b("GCM", "encrypt 6 iv is null");
            return new byte[0];
        } else if (bArr3.length < 12) {
            b.b("GCM", "encrypt 6 iv error: 6 iv length less than 16 bytes.");
            return new byte[0];
        } else if (!isBuildVersionHigherThan19()) {
            b.b("GCM", "encrypt 6 build version not higher than 19");
            return new byte[0];
        } else {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
                Cipher instance = Cipher.getInstance(f33723b);
                instance.init(1, secretKeySpec, getGcmAlgorithmParams(bArr3));
                return instance.doFinal(bArr);
            } catch (GeneralSecurityException e11) {
                b.b("GCM", "GCM encrypt data error" + e11.getMessage());
                return new byte[0];
            } catch (NullPointerException e12) {
                b.b("GCM", "GCM encrypt data error" + e12.getMessage());
                return new byte[0];
            }
        }
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null) {
            b.b("GCM", "decrypt 6 content is null");
            return new byte[0];
        } else if (bArr.length == 0) {
            b.b("GCM", "decrypt 6 content length is 0");
            return new byte[0];
        } else if (bArr2 == null) {
            b.b("GCM", "decrypt 6 key is null");
            return new byte[0];
        } else if (bArr2.length < 16) {
            b.b("GCM", "decrypt 6 key error: 6 key length less than 16 bytes.");
            return new byte[0];
        } else if (bArr3 == null) {
            b.b("GCM", "decrypt 6 iv is null");
            return new byte[0];
        } else if (bArr3.length < 12) {
            b.b("GCM", "decrypt 6 iv error: 6 iv length less than 16 bytes.");
            return new byte[0];
        } else if (!isBuildVersionHigherThan19()) {
            b.b("GCM", "decrypt 6 build version not higher than 19");
            return new byte[0];
        } else {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
                Cipher instance = Cipher.getInstance(f33723b);
                instance.init(2, secretKeySpec, getGcmAlgorithmParams(bArr3));
                return instance.doFinal(bArr);
            } catch (GeneralSecurityException e11) {
                b.b("GCM", "GCM decrypt data exception: " + e11.getMessage());
                return new byte[0];
            }
        }
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2) {
        byte[] generateSecureRandom = EncryptUtil.generateSecureRandom(12);
        return a(generateSecureRandom, encrypt(bArr, bArr2, generateSecureRandom));
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2) {
        return decrypt(b(bArr), bArr2, c(bArr));
    }
}
