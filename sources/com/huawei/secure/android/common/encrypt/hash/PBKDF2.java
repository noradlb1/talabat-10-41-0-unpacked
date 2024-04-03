package com.huawei.secure.android.common.encrypt.hash;

import android.os.Build;
import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public abstract class PBKDF2 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f33747a = "PBKDF2";

    /* renamed from: b  reason: collision with root package name */
    private static final String f33748b = "PBKDF2WithHmacSHA1";

    /* renamed from: c  reason: collision with root package name */
    private static final String f33749c = "PBKDF2WithHmacSHA256";

    /* renamed from: d  reason: collision with root package name */
    private static final String f33750d = "";

    /* renamed from: e  reason: collision with root package name */
    private static final int f33751e = 8;

    /* renamed from: f  reason: collision with root package name */
    private static final int f33752f = 16;

    /* renamed from: g  reason: collision with root package name */
    private static final int f33753g = 32;

    /* renamed from: h  reason: collision with root package name */
    private static final int f33754h = 10000;

    /* renamed from: i  reason: collision with root package name */
    private static final int f33755i = 1000;

    private static byte[] a(char[] cArr, byte[] bArr, int i11, int i12, boolean z11) {
        SecretKeyFactory secretKeyFactory;
        try {
            PBEKeySpec pBEKeySpec = new PBEKeySpec(cArr, bArr, i11, i12);
            if (z11) {
                secretKeyFactory = SecretKeyFactory.getInstance(f33749c);
            } else {
                secretKeyFactory = SecretKeyFactory.getInstance(f33748b);
            }
            return secretKeyFactory.generateSecret(pBEKeySpec).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e11) {
            String str = f33747a;
            b.b(str, "pbkdf exception : " + e11.getMessage());
            return new byte[0];
        }
    }

    public static byte[] pbkdf2(char[] cArr, byte[] bArr, int i11, int i12) {
        return a(cArr, bArr, i11, i12, false);
    }

    @Deprecated
    public static String pbkdf2Encrypt(String str) {
        return pbkdf2Encrypt(str, 10000);
    }

    public static String pbkdf2EncryptNew(String str) {
        return pbkdf2EncryptNew(str, 10000);
    }

    public static byte[] pbkdf2SHA256(char[] cArr, byte[] bArr, int i11, int i12) {
        byte[] bArr2 = new byte[0];
        if (Build.VERSION.SDK_INT >= 26) {
            return a(cArr, bArr, i11, i12, true);
        }
        b.b(f33747a, "system version not high than 26");
        return bArr2;
    }

    @Deprecated
    public static boolean validatePassword(String str, String str2) {
        return validatePassword(str, str2, 10000);
    }

    public static boolean validatePasswordNew(String str, String str2) {
        return validatePasswordNew(str, str2, 10000);
    }

    @Deprecated
    public static String pbkdf2Encrypt(String str, int i11) {
        return pbkdf2Encrypt(str, EncryptUtil.generateSecureRandom(8), i11, 32);
    }

    public static String pbkdf2EncryptNew(String str, int i11) {
        return pbkdf2EncryptNew(str, EncryptUtil.generateSecureRandom(16), i11, 32);
    }

    @Deprecated
    public static boolean validatePassword(String str, String str2, int i11) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str2.length() < 16) {
            return false;
        }
        return a(pbkdf2(str.toCharArray(), HexUtil.hexStr2ByteArray(str2.substring(0, 16)), i11, 256), HexUtil.hexStr2ByteArray(str2.substring(16)));
    }

    public static boolean validatePasswordNew(String str, String str2, int i11) {
        byte[] bArr;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str2.length() < 32) {
            return false;
        }
        String substring = str2.substring(0, 32);
        String substring2 = str2.substring(32);
        if (Build.VERSION.SDK_INT < 26) {
            bArr = pbkdf2(str.toCharArray(), HexUtil.hexStr2ByteArray(substring), i11, 256);
        } else {
            bArr = pbkdf2SHA256(str.toCharArray(), HexUtil.hexStr2ByteArray(substring), i11, 256);
        }
        return a(bArr, HexUtil.hexStr2ByteArray(substring2));
    }

    @Deprecated
    public static String pbkdf2Encrypt(String str, byte[] bArr, int i11, int i12) {
        if (TextUtils.isEmpty(str)) {
            b.b(f33747a, "pwd is null.");
            return "";
        } else if (i11 < 1000) {
            b.b(f33747a, "iterations times is not enough.");
            return "";
        } else if (bArr == null || bArr.length < 8) {
            b.b(f33747a, "salt parameter is null or length is not enough");
            return "";
        } else if (i12 < 32) {
            b.b(f33747a, "cipherLen length is not enough");
            return "";
        } else {
            byte[] pbkdf2 = pbkdf2(str.toCharArray(), bArr, i11, i12 * 8);
            return HexUtil.byteArray2HexStr(bArr) + HexUtil.byteArray2HexStr(pbkdf2);
        }
    }

    public static String pbkdf2EncryptNew(String str, byte[] bArr, int i11, int i12) {
        byte[] bArr2;
        if (TextUtils.isEmpty(str)) {
            b.b(f33747a, "pwd is null.");
            return "";
        } else if (i11 < 1000) {
            b.b(f33747a, "iterations times is not enough.");
            return "";
        } else if (bArr == null || bArr.length < 16) {
            b.b(f33747a, "salt parameter is null or length is not enough");
            return "";
        } else if (i12 < 32) {
            b.b(f33747a, "cipherLen length is not enough");
            return "";
        } else {
            if (Build.VERSION.SDK_INT < 26) {
                b.c(f33747a, "sha 1");
                bArr2 = pbkdf2(str.toCharArray(), bArr, i11, i12 * 8);
            } else {
                b.c(f33747a, "sha 256");
                bArr2 = pbkdf2SHA256(str.toCharArray(), bArr, i11, i12 * 8);
            }
            return HexUtil.byteArray2HexStr(bArr) + HexUtil.byteArray2HexStr(bArr2);
        }
    }

    private static boolean a(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return false;
        }
        byte length = bArr.length ^ bArr2.length;
        int i11 = 0;
        while (i11 < bArr.length && i11 < bArr2.length) {
            length |= bArr[i11] ^ bArr2[i11];
            i11++;
        }
        if (length == 0) {
            return true;
        }
        return false;
    }
}
