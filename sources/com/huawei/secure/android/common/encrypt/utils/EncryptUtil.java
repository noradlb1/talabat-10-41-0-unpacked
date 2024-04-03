package com.huawei.secure.android.common.encrypt.utils;

import android.os.Build;
import android.util.Base64;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class EncryptUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final String f33803a = "EncryptUtil";

    /* renamed from: b  reason: collision with root package name */
    private static final String f33804b = "RSA";

    /* renamed from: c  reason: collision with root package name */
    private static boolean f33805c = true;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f33806d = true;

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.security.SecureRandom a() {
        /*
            java.lang.String r0 = "generateSecureRandomNew "
            java.lang.String r1 = "EncryptUtil"
            com.huawei.secure.android.common.encrypt.utils.b.a(r1, r0)
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ NoSuchAlgorithmException -> 0x0012 }
            r2 = 26
            if (r0 < r2) goto L_0x0017
            java.security.SecureRandom r0 = java.security.SecureRandom.getInstanceStrong()     // Catch:{ NoSuchAlgorithmException -> 0x0012 }
            goto L_0x0018
        L_0x0012:
            java.lang.String r0 = "getSecureRandomBytes: NoSuchAlgorithmException"
            com.huawei.secure.android.common.encrypt.utils.b.b(r1, r0)
        L_0x0017:
            r0 = 0
        L_0x0018:
            r2 = 0
            if (r0 != 0) goto L_0x0024
            java.lang.String r3 = "SHA1PRNG"
            java.security.SecureRandom r0 = java.security.SecureRandom.getInstance(r3)     // Catch:{ NoSuchAlgorithmException -> 0x0067, all -> 0x0022 }
            goto L_0x0024
        L_0x0022:
            r3 = move-exception
            goto L_0x0043
        L_0x0024:
            org.bouncycastle.crypto.engines.AESEngine r3 = new org.bouncycastle.crypto.engines.AESEngine     // Catch:{ NoSuchAlgorithmException -> 0x0067, all -> 0x0022 }
            r3.<init>()     // Catch:{ NoSuchAlgorithmException -> 0x0067, all -> 0x0022 }
            r4 = 32
            byte[] r4 = new byte[r4]     // Catch:{ NoSuchAlgorithmException -> 0x0067, all -> 0x0022 }
            r0.nextBytes(r4)     // Catch:{ NoSuchAlgorithmException -> 0x0067, all -> 0x0022 }
            org.bouncycastle.crypto.prng.SP800SecureRandomBuilder r5 = new org.bouncycastle.crypto.prng.SP800SecureRandomBuilder     // Catch:{ NoSuchAlgorithmException -> 0x0067, all -> 0x0022 }
            r6 = 1
            r5.<init>(r0, r6)     // Catch:{ NoSuchAlgorithmException -> 0x0067, all -> 0x0022 }
            r6 = 384(0x180, float:5.38E-43)
            org.bouncycastle.crypto.prng.SP800SecureRandomBuilder r5 = r5.setEntropyBitsRequired(r6)     // Catch:{ NoSuchAlgorithmException -> 0x0067, all -> 0x0022 }
            r6 = 256(0x100, float:3.59E-43)
            org.bouncycastle.crypto.prng.SP800SecureRandom r0 = r5.buildCTR(r3, r6, r4, r2)     // Catch:{ NoSuchAlgorithmException -> 0x0067, all -> 0x0022 }
            return r0
        L_0x0043:
            boolean r4 = f33806d
            if (r4 == 0) goto L_0x006c
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "exception : "
            r4.append(r5)
            java.lang.String r3 = r3.getMessage()
            r4.append(r3)
            java.lang.String r3 = " , you should implementation bcprov-jdk15on library"
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            com.huawei.secure.android.common.encrypt.utils.b.b(r1, r3)
            f33806d = r2
            goto L_0x006c
        L_0x0067:
            java.lang.String r2 = "NoSuchAlgorithmException"
            com.huawei.secure.android.common.encrypt.utils.b.b(r1, r2)
        L_0x006c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.encrypt.utils.EncryptUtil.a():java.security.SecureRandom");
    }

    public static SecureRandom genSecureRandom() {
        if (f33805c) {
            return a();
        }
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                return SecureRandom.getInstanceStrong();
            }
            return SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException unused) {
            b.b(f33803a, "genSecureRandom: NoSuchAlgorithmException");
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x001b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] generateSecureRandom(int r3) {
        /*
            java.lang.String r0 = "EncryptUtil"
            boolean r1 = f33805c
            if (r1 != 0) goto L_0x0048
            byte[] r3 = new byte[r3]
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ NoSuchAlgorithmException -> 0x0013 }
            r2 = 26
            if (r1 < r2) goto L_0x0018
            java.security.SecureRandom r1 = java.security.SecureRandom.getInstanceStrong()     // Catch:{ NoSuchAlgorithmException -> 0x0013 }
            goto L_0x0019
        L_0x0013:
            java.lang.String r1 = "getSecureRandomBytes: NoSuchAlgorithmException"
            com.huawei.secure.android.common.encrypt.utils.b.b(r0, r1)
        L_0x0018:
            r1 = 0
        L_0x0019:
            if (r1 != 0) goto L_0x0021
            java.lang.String r1 = "SHA1PRNG"
            java.security.SecureRandom r1 = java.security.SecureRandom.getInstance(r1)     // Catch:{ NoSuchAlgorithmException -> 0x003f, Exception -> 0x0025 }
        L_0x0021:
            r1.nextBytes(r3)     // Catch:{ NoSuchAlgorithmException -> 0x003f, Exception -> 0x0025 }
            return r3
        L_0x0025:
            r3 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "getSecureRandomBytes getInstance: exception : "
            r1.append(r2)
            java.lang.String r3 = r3.getMessage()
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            com.huawei.secure.android.common.encrypt.utils.b.b(r0, r3)
            goto L_0x0044
        L_0x003f:
            java.lang.String r3 = "getSecureRandomBytes getInstance: NoSuchAlgorithmException"
            com.huawei.secure.android.common.encrypt.utils.b.b(r0, r3)
        L_0x0044:
            r3 = 0
            byte[] r3 = new byte[r3]
            return r3
        L_0x0048:
            byte[] r3 = a(r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.encrypt.utils.EncryptUtil.generateSecureRandom(int):byte[]");
    }

    public static String generateSecureRandomStr(int i11) {
        return HexUtil.byteArray2HexStr(generateSecureRandom(i11));
    }

    public static PrivateKey getPrivateKey(String str) {
        try {
            try {
                return KeyFactory.getInstance(f33804b).generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str, 0)));
            } catch (GeneralSecurityException e11) {
                b.b(f33803a, "load Key Exception:" + e11.getMessage());
                return null;
            }
        } catch (IllegalArgumentException unused) {
            b.b(f33803a, "base64 decode IllegalArgumentException");
            return null;
        } catch (Exception e12) {
            b.b(f33803a, "base64 decode Exception" + e12.getMessage());
            return null;
        }
    }

    public static RSAPublicKey getPublicKey(String str) {
        try {
            try {
                return (RSAPublicKey) KeyFactory.getInstance(f33804b).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
            } catch (GeneralSecurityException e11) {
                b.b(f33803a, "load Key Exception:" + e11.getMessage());
                return null;
            }
        } catch (IllegalArgumentException unused) {
            b.b(f33803a, "base64 decode IllegalArgumentException");
            return null;
        } catch (Exception e12) {
            b.b(f33803a, "base64 decode Exception" + e12.getMessage());
            return null;
        }
    }

    public static boolean isBouncycastleFlag() {
        return f33805c;
    }

    public static void setBouncycastleFlag(boolean z11) {
        b.c(f33803a, "setBouncycastleFlag: " + z11);
        f33805c = z11;
    }

    private static byte[] a(int i11) {
        SecureRandom a11 = a();
        if (a11 == null) {
            return new byte[0];
        }
        byte[] bArr = new byte[i11];
        a11.nextBytes(bArr);
        return bArr;
    }
}
