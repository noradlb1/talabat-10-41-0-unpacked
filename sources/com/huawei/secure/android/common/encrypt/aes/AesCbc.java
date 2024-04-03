package com.huawei.secure.android.common.encrypt.aes;

import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class AesCbc {

    /* renamed from: a  reason: collision with root package name */
    private static final String f33715a = "security:";

    /* renamed from: b  reason: collision with root package name */
    private static final String f33716b = "AES/CBC/PKCS5Padding";

    /* renamed from: c  reason: collision with root package name */
    private static final String f33717c = "AES";

    /* renamed from: d  reason: collision with root package name */
    private static final String f33718d = "CBC";

    /* renamed from: e  reason: collision with root package name */
    private static final String f33719e = "";

    /* renamed from: f  reason: collision with root package name */
    private static final int f33720f = 16;

    /* renamed from: g  reason: collision with root package name */
    private static final int f33721g = 16;

    private AesCbc() {
    }

    private static byte[] a(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            b.b(f33718d, "encrypt 5 content is null");
            return new byte[0];
        } else if (bArr == null) {
            b.b(f33718d, "encrypt 5 key is null");
            return new byte[0];
        } else if (bArr.length < 16) {
            b.b(f33718d, "encrypt 5 key error: 5 key length less than 16 bytes.");
            return new byte[0];
        } else if (bArr2 == null) {
            b.b(f33718d, "encrypt 5 iv is null");
            return new byte[0];
        } else if (bArr2.length < 16) {
            b.b(f33718d, "encrypt 5 iv error: 5 iv length less than 16 bytes.");
            return new byte[0];
        } else {
            try {
                return encrypt(str.getBytes("UTF-8"), bArr, bArr2);
            } catch (UnsupportedEncodingException e11) {
                b.b(f33718d, " cbc encrypt data error" + e11.getMessage());
                return new byte[0];
            }
        }
    }

    private static byte[] b(byte[] bArr) {
        byte[] bArr2 = new byte[(bArr.length - 16)];
        System.arraycopy(bArr, 16, bArr2, 0, bArr.length - 16);
        return bArr2;
    }

    private static byte[] c(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        System.arraycopy(bArr, 0, bArr2, 0, 16);
        return bArr2;
    }

    public static byte[] d(byte[] bArr) {
        String str;
        try {
            str = new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e11) {
            b.b(f33718d, "stripCryptHead: exception : " + e11.getMessage());
            str = "";
        }
        if (!str.startsWith(f33715a)) {
            return new byte[0];
        }
        if (bArr.length <= 9) {
            return new byte[0];
        }
        int length = bArr.length - 9;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 9, bArr2, 0, length);
        return bArr2;
    }

    public static String decrypt(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            b.b(f33718d, "decrypt 1 content is null");
            return "";
        } else if (TextUtils.isEmpty(str2)) {
            b.b(f33718d, "decrypt 1 key is null");
            return "";
        } else {
            byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str2);
            if (hexStr2ByteArray.length >= 16) {
                return decrypt(str, hexStr2ByteArray);
            }
            b.b(f33718d, "decrypt 1 key error: 1 key length less than 16 bytes.");
            return "";
        }
    }

    public static String decryptWithCryptHead(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str) && bArr != null && bArr.length >= 16) {
            String c11 = c(str);
            if ("".equals(c11)) {
                return "";
            }
            int indexOf = c11.indexOf(58);
            if (indexOf >= 0) {
                return decrypt(HexUtil.byteArray2HexStr(HexUtil.hexStr2ByteArray(c11.substring(indexOf + 1))), bArr, HexUtil.hexStr2ByteArray(c11.substring(0, indexOf)));
            }
            b.b(f33718d, " cbc cipherText data missing colon");
        }
        return "";
    }

    public static byte[] decryptWithCryptHeadReturnByte(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr2.length < 16) {
            return new byte[0];
        }
        byte[] d11 = d(bArr);
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
        b.b(f33718d, " cbc cipherText data missing colon");
        return new byte[0];
    }

    public static String encrypt(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            b.b(f33718d, "encrypt 1 content is null");
            return "";
        } else if (TextUtils.isEmpty(str2)) {
            b.b(f33718d, "encrypt 1 key is null");
            return "";
        } else {
            byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str2);
            if (hexStr2ByteArray.length >= 16) {
                return encrypt(str, hexStr2ByteArray);
            }
            b.b(f33718d, "encrypt 1 key error: 1 key length less than 16 bytes.");
            return "";
        }
    }

    public static String c(String str) {
        if (!TextUtils.isEmpty(str) && str.indexOf(f33715a) != -1) {
            return str.substring(9);
        }
        return "";
    }

    private static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return str.substring(6, 12) + str.substring(16, 26) + str.substring(32, 48);
        } catch (Exception e11) {
            b.b(f33718d, "getIv exception : " + e11.getMessage());
            return "";
        }
    }

    public static String decrypt(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            b.b(f33718d, "decrypt 2 content is null");
            return "";
        } else if (bArr == null) {
            b.b(f33718d, "decrypt 2 key is null");
            return "";
        } else if (bArr.length < 16) {
            b.b(f33718d, "decrypt 2 key error: 2 key length less than 16 bytes.");
            return "";
        } else {
            String b11 = b(str);
            String a11 = a(str);
            if (TextUtils.isEmpty(b11)) {
                b.b(f33718d, "decrypt 2 iv is null");
                return "";
            } else if (!TextUtils.isEmpty(a11)) {
                return decrypt(a11, bArr, HexUtil.hexStr2ByteArray(b11));
            } else {
                b.b(f33718d, "decrypt 2 encrypt content is null");
                return "";
            }
        }
    }

    public static String decryptWithCryptHead(byte[] bArr, byte[] bArr2) {
        try {
            return new String(decryptWithCryptHeadReturnByte(bArr, bArr2), "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            b.b(f33718d, "decryptWithCryptHead UnsupportedEncodingException ");
            return "";
        }
    }

    public static String encrypt(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            b.b(f33718d, "encrypt 2 content is null");
            return "";
        } else if (bArr == null) {
            b.b(f33718d, "encrypt 2 key is null");
            return "";
        } else if (bArr.length < 16) {
            b.b(f33718d, "encrypt 2 key error: 2 key length less than 16 bytes.");
            return "";
        } else {
            byte[] generateSecureRandom = EncryptUtil.generateSecureRandom(16);
            byte[] a11 = a(str, bArr, generateSecureRandom);
            if (a11 == null || a11.length == 0) {
                return "";
            }
            return a(HexUtil.byteArray2HexStr(generateSecureRandom), HexUtil.byteArray2HexStr(a11));
        }
    }

    private static String a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                return str2.substring(0, 6) + str.substring(0, 6) + str2.substring(6, 10) + str.substring(6, 16) + str2.substring(10, 16) + str.substring(16) + str2.substring(16);
            } catch (Exception e11) {
                b.b(f33718d, "mix exception: " + e11.getMessage());
            }
        }
        return "";
    }

    public static String encrypt(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            b.b(f33718d, "encrypt 3 content is null");
            return "";
        } else if (TextUtils.isEmpty(str2)) {
            b.b(f33718d, "encrypt 3 key is null");
            return "";
        } else if (TextUtils.isEmpty(str3)) {
            b.b(f33718d, "encrypt 3 iv is null");
            return "";
        } else {
            byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str2);
            byte[] hexStr2ByteArray2 = HexUtil.hexStr2ByteArray(str3);
            if (hexStr2ByteArray.length < 16) {
                b.b(f33718d, "encrypt 3 key error: 3 key length less than 16 bytes.");
                return "";
            } else if (hexStr2ByteArray2.length >= 16) {
                return encrypt(str, hexStr2ByteArray, hexStr2ByteArray2);
            } else {
                b.b(f33718d, "encrypt 3 iv error: 3 iv length less than 16 bytes.");
                return "";
            }
        }
    }

    public static String decrypt(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            b.b(f33718d, "decrypt 3 content is null");
            return "";
        } else if (TextUtils.isEmpty(str2)) {
            b.b(f33718d, "decrypt 3 key is null");
            return "";
        } else if (TextUtils.isEmpty(str3)) {
            b.b(f33718d, "decrypt 3 iv is null");
            return "";
        } else {
            byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str2);
            byte[] hexStr2ByteArray2 = HexUtil.hexStr2ByteArray(str3);
            if (hexStr2ByteArray.length < 16) {
                b.b(f33718d, "decrypt 3 key error: 3 key length less than 16 bytes.");
                return "";
            } else if (hexStr2ByteArray2.length >= 16) {
                return decrypt(str, hexStr2ByteArray, hexStr2ByteArray2);
            } else {
                b.b(f33718d, "decrypt 3 iv error: 3 iv length less than 16 bytes.");
                return "";
            }
        }
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return str.substring(0, 6) + str.substring(12, 16) + str.substring(26, 32) + str.substring(48);
        } catch (Exception e11) {
            b.b(f33718d, "get encryptword exception : " + e11.getMessage());
            return "";
        }
    }

    private static int a(byte[] bArr) {
        return bArr[16] == 58 ? 16 : -1;
    }

    public static String encrypt(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            b.b(f33718d, "encrypt 4 content is null");
            return "";
        } else if (bArr == null) {
            b.b(f33718d, "encrypt 4 key is null");
            return "";
        } else if (bArr.length < 16) {
            b.b(f33718d, "encrypt 4 key error: 4 key length less than 16 bytes.");
            return "";
        } else if (bArr2 == null) {
            b.b(f33718d, "encrypt 4 iv is null");
            return "";
        } else if (bArr2.length >= 16) {
            return HexUtil.byteArray2HexStr(a(str, bArr, bArr2));
        } else {
            b.b(f33718d, "encrypt 4 iv error: 4 iv length less than 16 bytes.");
            return "";
        }
    }

    public static String decrypt(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            b.b(f33718d, "decrypt 4 content is null");
            return "";
        } else if (bArr == null) {
            b.b(f33718d, "decrypt 4 key is null");
            return "";
        } else if (bArr.length < 16) {
            b.b(f33718d, "decrypt 4 key error: 4 key length less than 16 bytes.");
            return "";
        } else if (bArr2 == null) {
            b.b(f33718d, "decrypt 4 iv is null");
            return "";
        } else if (bArr2.length < 16) {
            b.b(f33718d, "decrypt 4 iv error: 4 iv length less than 16 bytes.");
            return "";
        } else {
            try {
                return new String(decrypt(HexUtil.hexStr2ByteArray(str), bArr, bArr2), "UTF-8");
            } catch (UnsupportedEncodingException e11) {
                b.b(f33718d, " cbc decrypt data error" + e11.getMessage());
                return "";
            }
        }
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null) {
            b.b(f33718d, "encrypt 6 content is null");
            return new byte[0];
        } else if (bArr.length == 0) {
            b.b(f33718d, "encrypt 6 content length is 0");
            return new byte[0];
        } else if (bArr2 == null) {
            b.b(f33718d, "encrypt 6 key is null");
            return new byte[0];
        } else if (bArr2.length < 16) {
            b.b(f33718d, "encrypt 6 key error: 6 key length less than 16 bytes.");
            return new byte[0];
        } else if (bArr3 == null) {
            b.b(f33718d, "encrypt 6 iv is null");
            return new byte[0];
        } else if (bArr3.length < 16) {
            b.b(f33718d, "encrypt 6 iv error: 6 iv length less than 16 bytes.");
            return new byte[0];
        } else {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            try {
                Cipher instance = Cipher.getInstance(f33716b);
                instance.init(1, secretKeySpec, new IvParameterSpec(bArr3));
                return instance.doFinal(bArr);
            } catch (NoSuchAlgorithmException e11) {
                b.b(f33718d, "NoSuchAlgorithmException: " + e11.getMessage());
                return new byte[0];
            } catch (NoSuchPaddingException e12) {
                b.b(f33718d, "NoSuchPaddingException: " + e12.getMessage());
                return new byte[0];
            } catch (InvalidKeyException e13) {
                b.b(f33718d, "InvalidKeyException: " + e13.getMessage());
                return new byte[0];
            } catch (InvalidAlgorithmParameterException e14) {
                b.b(f33718d, "InvalidAlgorithmParameterException: " + e14.getMessage());
                return new byte[0];
            } catch (IllegalBlockSizeException e15) {
                b.b(f33718d, "IllegalBlockSizeException: " + e15.getMessage());
                return new byte[0];
            } catch (BadPaddingException e16) {
                b.b(f33718d, "BadPaddingException: " + e16.getMessage());
                return new byte[0];
            } catch (NullPointerException e17) {
                b.b(f33718d, "NullPointerException: " + e17.getMessage());
                return new byte[0];
            }
        }
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null) {
            b.b(f33718d, "decrypt 6 content is null");
            return new byte[0];
        } else if (bArr.length == 0) {
            b.b(f33718d, "decrypt 6 content length is 0");
            return new byte[0];
        } else if (bArr2 == null) {
            b.b(f33718d, "decrypt 6 key is null");
            return new byte[0];
        } else if (bArr2.length < 16) {
            b.b(f33718d, "decrypt 6 key error: 6 key length less than 16 bytes.");
            return new byte[0];
        } else if (bArr3 == null) {
            b.b(f33718d, "decrypt 6 iv is null");
            return new byte[0];
        } else if (bArr3.length < 16) {
            b.b(f33718d, "decrypt 6 iv error: 6 iv length less than 16 bytes.");
            return new byte[0];
        } else {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            try {
                Cipher instance = Cipher.getInstance(f33716b);
                instance.init(2, secretKeySpec, new IvParameterSpec(bArr3));
                return instance.doFinal(bArr);
            } catch (NoSuchAlgorithmException e11) {
                b.b(f33718d, "NoSuchAlgorithmException: " + e11.getMessage());
                return new byte[0];
            } catch (NoSuchPaddingException e12) {
                b.b(f33718d, "NoSuchPaddingException: " + e12.getMessage());
                return new byte[0];
            } catch (InvalidKeyException e13) {
                b.b(f33718d, "InvalidKeyException: " + e13.getMessage());
                return new byte[0];
            } catch (InvalidAlgorithmParameterException e14) {
                b.b(f33718d, "InvalidAlgorithmParameterException: " + e14.getMessage());
                return new byte[0];
            } catch (IllegalBlockSizeException e15) {
                b.b(f33718d, "IllegalBlockSizeException: " + e15.getMessage());
                return new byte[0];
            } catch (BadPaddingException e16) {
                b.b(f33718d, "BadPaddingException: " + e16.getMessage());
                b.b(f33718d, "key is not right");
                return new byte[0];
            } catch (NullPointerException e17) {
                b.b(f33718d, "NullPointerException: " + e17.getMessage());
                return new byte[0];
            }
        }
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2) {
        byte[] generateSecureRandom = EncryptUtil.generateSecureRandom(16);
        return a(generateSecureRandom, encrypt(bArr, bArr2, generateSecureRandom));
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2) {
        return decrypt(b(bArr), bArr2, c(bArr));
    }
}
