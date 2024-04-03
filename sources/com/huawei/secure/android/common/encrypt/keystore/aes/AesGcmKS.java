package com.huawei.secure.android.common.encrypt.keystore.aes;

import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import com.google.android.gms.stats.CodePackage;
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
import javax.crypto.spec.GCMParameterSpec;

public class AesGcmKS {

    /* renamed from: a  reason: collision with root package name */
    private static final String f33767a = "GCMKS";

    /* renamed from: b  reason: collision with root package name */
    private static final String f33768b = "AndroidKeyStore";

    /* renamed from: c  reason: collision with root package name */
    private static final String f33769c = "AES/GCM/NoPadding";

    /* renamed from: d  reason: collision with root package name */
    private static final String f33770d = "";

    /* renamed from: e  reason: collision with root package name */
    private static final int f33771e = 12;

    /* renamed from: f  reason: collision with root package name */
    private static final int f33772f = 256;

    /* renamed from: g  reason: collision with root package name */
    private static Map<String, SecretKey> f33773g = new HashMap();

    private static SecretKey a(String str) {
        b.c(f33767a, "load key");
        SecretKey secretKey = null;
        try {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            instance.load((KeyStore.LoadStoreParameter) null);
            Key key = instance.getKey(str, (char[]) null);
            if (key instanceof SecretKey) {
                secretKey = (SecretKey) key;
            } else {
                b.c(f33767a, "generate key");
                KeyGenerator instance2 = KeyGenerator.getInstance("AES", "AndroidKeyStore");
                instance2.init(new KeyGenParameterSpec.Builder(str, 3).setBlockModes(new String[]{CodePackage.GCM}).setEncryptionPaddings(new String[]{"NoPadding"}).setKeySize(256).build());
                secretKey = instance2.generateKey();
            }
        } catch (KeyStoreException e11) {
            b.b(f33767a, "KeyStoreException : " + e11.getMessage());
        } catch (IOException e12) {
            b.b(f33767a, "IOException : " + e12.getMessage());
        } catch (CertificateException e13) {
            b.b(f33767a, "CertificateException : " + e13.getMessage());
        } catch (NoSuchAlgorithmException e14) {
            b.b(f33767a, "NoSuchAlgorithmException : " + e14.getMessage());
        } catch (UnrecoverableKeyException e15) {
            b.b(f33767a, "UnrecoverableKeyException : " + e15.getMessage());
        } catch (InvalidAlgorithmParameterException e16) {
            b.b(f33767a, "InvalidAlgorithmParameterException : " + e16.getMessage());
        } catch (NoSuchProviderException e17) {
            b.b(f33767a, "NoSuchProviderException : " + e17.getMessage());
        } catch (Exception e18) {
            b.b(f33767a, "Exception: " + e18.getMessage());
        }
        f33773g.put(str, secretKey);
        return secretKey;
    }

    private static boolean a() {
        return true;
    }

    private static SecretKey b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (f33773g.get(str) == null) {
            a(str);
        }
        return f33773g.get(str);
    }

    public static String decrypt(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            b.b(f33767a, "alias or encrypt content is null");
            return "";
        }
        try {
            return new String(decrypt(str, HexUtil.hexStr2ByteArray(str2)), "UTF-8");
        } catch (UnsupportedEncodingException e11) {
            b.b(f33767a, "decrypt: UnsupportedEncodingException : " + e11.getMessage());
            return "";
        }
    }

    public static String encrypt(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            b.b(f33767a, "alias or encrypt content is null");
            return "";
        }
        try {
            return HexUtil.byteArray2HexStr(encrypt(str, str2.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e11) {
            b.b(f33767a, "encrypt: UnsupportedEncodingException : " + e11.getMessage());
            return "";
        }
    }

    public static byte[] decrypt(String str, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (TextUtils.isEmpty(str) || bArr == null) {
            b.b(f33767a, "alias or encrypt content is null");
            return bArr2;
        } else if (!a()) {
            b.b(f33767a, "sdk version is too low");
            return bArr2;
        } else if (bArr.length > 12) {
            return decrypt(b(str), bArr);
        } else {
            b.b(f33767a, "Decrypt source data is invalid.");
            return bArr2;
        }
    }

    public static byte[] encrypt(String str, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (TextUtils.isEmpty(str) || bArr == null) {
            b.b(f33767a, "alias or encrypt content is null");
            return bArr2;
        } else if (a()) {
            return encrypt(b(str), bArr);
        } else {
            b.b(f33767a, "sdk version is too low");
            return bArr2;
        }
    }

    public static byte[] encrypt(SecretKey secretKey, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (bArr == null) {
            b.b(f33767a, "content is null");
            return bArr2;
        } else if (secretKey == null) {
            b.b(f33767a, "secret key is null");
            return bArr2;
        } else if (!a()) {
            b.b(f33767a, "sdk version is too low");
            return bArr2;
        } else {
            try {
                Cipher instance = Cipher.getInstance(f33769c);
                instance.init(1, secretKey);
                byte[] doFinal = instance.doFinal(bArr);
                byte[] iv2 = instance.getIV();
                if (iv2 != null) {
                    if (iv2.length == 12) {
                        byte[] copyOf = Arrays.copyOf(iv2, iv2.length + doFinal.length);
                        System.arraycopy(doFinal, 0, copyOf, iv2.length, doFinal.length);
                        return copyOf;
                    }
                }
                b.b(f33767a, "IV is invalid.");
                return bArr2;
            } catch (NoSuchAlgorithmException e11) {
                b.b(f33767a, "NoSuchAlgorithmException : " + e11.getMessage());
                return bArr2;
            } catch (NoSuchPaddingException e12) {
                b.b(f33767a, "NoSuchPaddingException : " + e12.getMessage());
                return bArr2;
            } catch (BadPaddingException e13) {
                b.b(f33767a, "BadPaddingException : " + e13.getMessage());
                return bArr2;
            } catch (IllegalBlockSizeException e14) {
                b.b(f33767a, "IllegalBlockSizeException : " + e14.getMessage());
                return bArr2;
            } catch (InvalidKeyException e15) {
                b.b(f33767a, "InvalidKeyException : " + e15.getMessage());
                return bArr2;
            } catch (Exception e16) {
                b.b(f33767a, "Exception: " + e16.getMessage());
                return bArr2;
            }
        }
    }

    public static byte[] decrypt(SecretKey secretKey, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (secretKey == null) {
            b.b(f33767a, "Decrypt secret key is null");
            return bArr2;
        } else if (bArr == null) {
            b.b(f33767a, "content is null");
            return bArr2;
        } else if (!a()) {
            b.b(f33767a, "sdk version is too low");
            return bArr2;
        } else if (bArr.length <= 12) {
            b.b(f33767a, "Decrypt source data is invalid.");
            return bArr2;
        } else {
            byte[] copyOf = Arrays.copyOf(bArr, 12);
            try {
                Cipher instance = Cipher.getInstance(f33769c);
                instance.init(2, secretKey, new GCMParameterSpec(128, copyOf));
                return instance.doFinal(bArr, 12, bArr.length - 12);
            } catch (NoSuchAlgorithmException e11) {
                b.b(f33767a, "NoSuchAlgorithmException : " + e11.getMessage());
                return bArr2;
            } catch (NoSuchPaddingException e12) {
                b.b(f33767a, "NoSuchPaddingException : " + e12.getMessage());
                return bArr2;
            } catch (InvalidKeyException e13) {
                b.b(f33767a, "InvalidKeyException : " + e13.getMessage());
                return bArr2;
            } catch (InvalidAlgorithmParameterException e14) {
                b.b(f33767a, "InvalidAlgorithmParameterException : " + e14.getMessage());
                return bArr2;
            } catch (IllegalBlockSizeException e15) {
                b.b(f33767a, "IllegalBlockSizeException : " + e15.getMessage());
                return bArr2;
            } catch (BadPaddingException e16) {
                b.b(f33767a, "BadPaddingException : " + e16.getMessage());
                return bArr2;
            } catch (Exception e17) {
                b.b(f33767a, "Exception: " + e17.getMessage());
                return bArr2;
            }
        }
    }
}
