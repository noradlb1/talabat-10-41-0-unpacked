package com.huawei.secure.android.common.encrypt.rsa;

import android.text.TextUtils;
import android.util.Base64;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;

public abstract class RSAEncrypt {

    /* renamed from: a  reason: collision with root package name */
    private static final String f33786a = "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";

    /* renamed from: b  reason: collision with root package name */
    private static final String f33787b = "RSAEncrypt";

    /* renamed from: c  reason: collision with root package name */
    private static final String f33788c = "UTF-8";

    /* renamed from: d  reason: collision with root package name */
    private static final String f33789d = "";

    /* renamed from: e  reason: collision with root package name */
    private static final int f33790e = 2048;

    /* renamed from: f  reason: collision with root package name */
    private static final String f33791f = "RSA";

    public static String decrypt(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return decrypt(str, EncryptUtil.getPrivateKey(str2));
        }
        b.b(f33787b, "content or private key is null");
        return "";
    }

    public static String encrypt(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return encrypt(str, (PublicKey) EncryptUtil.getPublicKey(str2));
        }
        b.b(f33787b, "content or public key is null");
        return "";
    }

    public static Map<String, Key> generateRSAKeyPair(int i11) throws NoSuchAlgorithmException {
        HashMap hashMap = new HashMap(2);
        if (i11 < 2048) {
            b.b(f33787b, "generateRSAKeyPair: key length is too short");
            return hashMap;
        }
        SecureRandom genSecureRandom = EncryptUtil.genSecureRandom();
        KeyPairGenerator instance = KeyPairGenerator.getInstance(f33791f);
        instance.initialize(i11, genSecureRandom);
        KeyPair generateKeyPair = instance.generateKeyPair();
        PublicKey publicKey = generateKeyPair.getPublic();
        PrivateKey privateKey = generateKeyPair.getPrivate();
        hashMap.put("publicKey", publicKey);
        hashMap.put("privateKey", privateKey);
        return hashMap;
    }

    public static boolean isPrivateKeyLengthRight(RSAPrivateKey rSAPrivateKey) {
        return rSAPrivateKey != null && rSAPrivateKey.getModulus().bitLength() >= 2048;
    }

    public static boolean isPublicKeyLengthRight(RSAPublicKey rSAPublicKey) {
        return rSAPublicKey != null && rSAPublicKey.getModulus().bitLength() >= 2048;
    }

    public static String decrypt(String str, PrivateKey privateKey) {
        if (TextUtils.isEmpty(str) || privateKey == null || !isPrivateKeyLengthRight((RSAPrivateKey) privateKey)) {
            b.b(f33787b, "content or privateKey is null , or length is too short");
            return "";
        }
        try {
            return new String(decrypt(Base64.decode(str, 0), privateKey), "UTF-8");
        } catch (UnsupportedEncodingException e11) {
            b.b(f33787b, "RSA decrypt exception : " + e11.getMessage());
            return "";
        } catch (Exception e12) {
            b.b(f33787b, "exception : " + e12.getMessage());
            return "";
        }
    }

    public static String encrypt(String str, PublicKey publicKey) {
        if (TextUtils.isEmpty(str) || publicKey == null || !isPublicKeyLengthRight((RSAPublicKey) publicKey)) {
            b.b(f33787b, "content or PublicKey is null , or length is too short");
            return "";
        }
        try {
            return Base64.encodeToString(encrypt(str.getBytes("UTF-8"), publicKey), 0);
        } catch (UnsupportedEncodingException unused) {
            b.b(f33787b, "encrypt: UnsupportedEncodingException");
            return "";
        } catch (Exception e11) {
            b.b(f33787b, "exception : " + e11.getMessage());
            return "";
        }
    }

    public static byte[] decrypt(byte[] bArr, PrivateKey privateKey) {
        byte[] bArr2 = new byte[0];
        if (bArr == null || privateKey == null || !isPrivateKeyLengthRight((RSAPrivateKey) privateKey)) {
            b.b(f33787b, "content or privateKey is null , or length is too short");
            return bArr2;
        }
        try {
            Cipher instance = Cipher.getInstance(f33786a);
            instance.init(2, privateKey);
            return instance.doFinal(bArr);
        } catch (GeneralSecurityException e11) {
            b.b(f33787b, "RSA decrypt exception : " + e11.getMessage());
            return bArr2;
        }
    }

    public static byte[] encrypt(byte[] bArr, PublicKey publicKey) {
        byte[] bArr2 = new byte[0];
        if (bArr == null || publicKey == null || !isPublicKeyLengthRight((RSAPublicKey) publicKey)) {
            b.b(f33787b, "content or PublicKey is null , or length is too short");
            return bArr2;
        }
        try {
            Cipher instance = Cipher.getInstance(f33786a);
            instance.init(1, publicKey);
            return instance.doFinal(bArr);
        } catch (GeneralSecurityException e11) {
            b.b(f33787b, "RSA encrypt exception : " + e11.getMessage());
            return bArr2;
        }
    }
}
