package com.huawei.secure.android.common.encrypt.keystore.aes;

import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class AesCbcKS {

    /* renamed from: a  reason: collision with root package name */
    private static final String f33760a = "CBCKS";

    /* renamed from: b  reason: collision with root package name */
    private static final String f33761b = "AndroidKeyStore";

    /* renamed from: c  reason: collision with root package name */
    private static final String f33762c = "AES/CBC/PKCS7Padding";

    /* renamed from: d  reason: collision with root package name */
    private static final String f33763d = "";

    /* renamed from: e  reason: collision with root package name */
    private static final int f33764e = 16;

    /* renamed from: f  reason: collision with root package name */
    private static final int f33765f = 256;

    /* renamed from: g  reason: collision with root package name */
    private static Map<String, SecretKey> f33766g = new HashMap();

    private static synchronized SecretKey a(String str) {
        SecretKey secretKey;
        synchronized (AesCbcKS.class) {
            b.c(f33760a, "load key");
            secretKey = null;
            try {
                KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
                instance.load((KeyStore.LoadStoreParameter) null);
                Key key = instance.getKey(str, (char[]) null);
                if (key == null || !(key instanceof SecretKey)) {
                    b.c(f33760a, "generate key");
                    KeyGenerator instance2 = KeyGenerator.getInstance("AES", "AndroidKeyStore");
                    instance2.init(new KeyGenParameterSpec.Builder(str, 3).setBlockModes(new String[]{"CBC"}).setEncryptionPaddings(new String[]{"PKCS7Padding"}).setKeySize(256).build());
                    secretKey = instance2.generateKey();
                } else {
                    secretKey = (SecretKey) key;
                }
            } catch (KeyStoreException e11) {
                b.b(f33760a, "KeyStoreException: " + e11.getMessage());
            } catch (IOException e12) {
                b.b(f33760a, "IOException: " + e12.getMessage());
            } catch (CertificateException e13) {
                b.b(f33760a, "CertificateException: " + e13.getMessage());
            } catch (NoSuchAlgorithmException e14) {
                b.b(f33760a, "NoSuchAlgorithmException: " + e14.getMessage());
            } catch (UnrecoverableKeyException e15) {
                b.b(f33760a, "UnrecoverableKeyException: " + e15.getMessage());
            } catch (InvalidAlgorithmParameterException e16) {
                b.b(f33760a, "InvalidAlgorithmParameterException: " + e16.getMessage());
            } catch (NoSuchProviderException e17) {
                b.b(f33760a, "NoSuchProviderException: " + e17.getMessage());
            } catch (Exception e18) {
                b.b(f33760a, "Exception: " + e18.getMessage());
            }
            f33766g.put(str, secretKey);
        }
        return secretKey;
    }

    private static boolean a() {
        return true;
    }

    private static SecretKey b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (f33766g.get(str) == null) {
            a(str);
        }
        return f33766g.get(str);
    }

    public static String decrypt(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            b.b(f33760a, "alias or encrypt content is null");
            return "";
        }
        try {
            return new String(decrypt(str, HexUtil.hexStr2ByteArray(str2)), "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            b.b(f33760a, "encrypt: UnsupportedEncodingException");
            return "";
        }
    }

    public static String encrypt(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            b.b(f33760a, "encrypt 1 content is null");
            return "";
        }
        try {
            return HexUtil.byteArray2HexStr(encrypt(str, str2.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException unused) {
            b.b(f33760a, "encrypt: UnsupportedEncodingException");
            return "";
        }
    }

    public static byte[] encrypt(String str, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (TextUtils.isEmpty(str) || bArr == null) {
            b.b(f33760a, "alias or encrypt content is null");
            return bArr2;
        } else if (!a()) {
            b.b(f33760a, "sdk version is too low");
            return bArr2;
        } else {
            try {
                Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
                SecretKey b11 = b(str);
                if (b11 == null) {
                    b.b(f33760a, "encrypt secret key is null");
                    return bArr2;
                }
                instance.init(1, b11);
                byte[] doFinal = instance.doFinal(bArr);
                byte[] iv2 = instance.getIV();
                if (iv2 != null) {
                    if (iv2.length == 16) {
                        byte[] copyOf = Arrays.copyOf(iv2, iv2.length + doFinal.length);
                        System.arraycopy(doFinal, 0, copyOf, iv2.length, doFinal.length);
                        return copyOf;
                    }
                }
                b.b(f33760a, "IV is invalid.");
                return bArr2;
            } catch (NoSuchAlgorithmException e11) {
                b.b(f33760a, "NoSuchAlgorithmException: " + e11.getMessage());
                return bArr2;
            } catch (NoSuchPaddingException e12) {
                b.b(f33760a, "NoSuchPaddingException: " + e12.getMessage());
                return bArr2;
            } catch (BadPaddingException e13) {
                b.b(f33760a, "BadPaddingException: " + e13.getMessage());
                return bArr2;
            } catch (IllegalBlockSizeException e14) {
                b.b(f33760a, "IllegalBlockSizeException: " + e14.getMessage());
                return bArr2;
            } catch (InvalidKeyException e15) {
                b.b(f33760a, "InvalidKeyException: " + e15.getMessage());
                return bArr2;
            } catch (Exception e16) {
                b.b(f33760a, "Exception: " + e16.getMessage());
                return bArr2;
            }
        }
    }

    public static byte[] decrypt(String str, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (TextUtils.isEmpty(str) || bArr == null) {
            b.b(f33760a, "alias or encrypt content is null");
            return bArr2;
        } else if (!a()) {
            b.b(f33760a, "sdk version is too low");
            return bArr2;
        } else if (bArr.length <= 16) {
            b.b(f33760a, "Decrypt source data is invalid.");
            return bArr2;
        } else {
            SecretKey b11 = b(str);
            if (b11 == null) {
                b.b(f33760a, "decrypt secret key is null");
                return bArr2;
            }
            byte[] copyOf = Arrays.copyOf(bArr, 16);
            try {
                Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
                instance.init(2, b11, new IvParameterSpec(copyOf));
                return instance.doFinal(bArr, 16, bArr.length - 16);
            } catch (NoSuchAlgorithmException e11) {
                b.b(f33760a, "NoSuchAlgorithmException: " + e11.getMessage());
                return bArr2;
            } catch (NoSuchPaddingException e12) {
                b.b(f33760a, "NoSuchPaddingException: " + e12.getMessage());
                return bArr2;
            } catch (InvalidKeyException e13) {
                b.b(f33760a, "InvalidKeyException: " + e13.getMessage());
                return bArr2;
            } catch (InvalidAlgorithmParameterException e14) {
                b.b(f33760a, "InvalidAlgorithmParameterException: " + e14.getMessage());
                return bArr2;
            } catch (IllegalBlockSizeException e15) {
                b.b(f33760a, "IllegalBlockSizeException: " + e15.getMessage());
                return bArr2;
            } catch (BadPaddingException e16) {
                b.b(f33760a, "BadPaddingException: " + e16.getMessage());
                return bArr2;
            } catch (Exception e17) {
                b.b(f33760a, "Exception: " + e17.getMessage());
                return bArr2;
            }
        }
    }
}
