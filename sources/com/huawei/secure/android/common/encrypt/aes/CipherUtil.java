package com.huawei.secure.android.common.encrypt.aes;

import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class CipherUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final String f33730a = "CipherUtil";

    /* renamed from: b  reason: collision with root package name */
    private static final String f33731b = "AES/GCM/NoPadding";

    /* renamed from: c  reason: collision with root package name */
    private static final String f33732c = "AES/CBC/PKCS5Padding";

    /* renamed from: d  reason: collision with root package name */
    private static final String f33733d = "AES";

    /* renamed from: e  reason: collision with root package name */
    private static final String f33734e = "";

    /* renamed from: f  reason: collision with root package name */
    private static final int f33735f = 16;

    /* renamed from: g  reason: collision with root package name */
    private static final int f33736g = 12;

    /* renamed from: h  reason: collision with root package name */
    private static final int f33737h = 16;

    private static Cipher a(byte[] bArr, byte[] bArr2, int i11) {
        return a(bArr, bArr2, i11, f33732c);
    }

    private static Cipher b(byte[] bArr, byte[] bArr2, int i11) {
        return a(bArr, bArr2, i11, f33731b);
    }

    public static Cipher getAesCbcDecryptCipher(byte[] bArr, Cipher cipher) {
        return getAesCbcDecryptCipher(bArr, cipher.getIV());
    }

    public static Cipher getAesCbcEncryptCipher(byte[] bArr) {
        return getAesCbcEncryptCipher(bArr, EncryptUtil.generateSecureRandom(16));
    }

    public static int getAesCbcEncryptContentLen(byte[] bArr, byte[] bArr2) {
        return getAesCbcEncryptContentLen(bArr, bArr2, EncryptUtil.generateSecureRandom(16));
    }

    public static Cipher getAesGcmDecryptCipher(byte[] bArr, Cipher cipher) {
        return getAesGcmDecryptCipher(bArr, cipher.getIV());
    }

    public static Cipher getAesGcmEncryptCipher(byte[] bArr) {
        byte[] generateSecureRandom = EncryptUtil.generateSecureRandom(12);
        b.a(f33730a, "getEncryptCipher: iv is : " + HexUtil.byteArray2HexStr(generateSecureRandom));
        return getAesGcmEncryptCipher(bArr, generateSecureRandom);
    }

    public static int getAesGcmEncryptContentLen(byte[] bArr, byte[] bArr2) {
        return getAesGcmEncryptContentLen(bArr, bArr2, EncryptUtil.generateSecureRandom(12));
    }

    public static int getContent(Cipher cipher, byte[] bArr, byte[] bArr2) {
        if (cipher == null || bArr == null) {
            b.b(f33730a, "getEncryptCOntent: cipher is null or content is null");
            return -1;
        }
        try {
            return cipher.doFinal(bArr, 0, bArr.length, bArr2);
        } catch (BadPaddingException unused) {
            b.b(f33730a, "getContent: BadPaddingException");
            return -1;
        } catch (IllegalBlockSizeException unused2) {
            b.b(f33730a, "getContent: IllegalBlockSizeException");
            return -1;
        } catch (ShortBufferException unused3) {
            b.b(f33730a, "getContent: ShortBufferException");
            return -1;
        }
    }

    private static Cipher a(byte[] bArr, byte[] bArr2, int i11, String str) {
        AlgorithmParameterSpec algorithmParameterSpec;
        if (bArr == null || bArr.length < 16 || bArr2 == null || bArr2.length < 12 || !AesGcm.isBuildVersionHigherThan19()) {
            b.b(f33730a, "gcm encrypt param is not right");
            return null;
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher instance = Cipher.getInstance(str);
            if (f33731b.equals(str)) {
                algorithmParameterSpec = AesGcm.getGcmAlgorithmParams(bArr2);
            } else {
                algorithmParameterSpec = new IvParameterSpec(bArr2);
            }
            instance.init(i11, secretKeySpec, algorithmParameterSpec);
            return instance;
        } catch (GeneralSecurityException e11) {
            b.b(f33730a, "GCM encrypt data error" + e11.getMessage());
            return null;
        }
    }

    public static Cipher getAesCbcDecryptCipher(byte[] bArr, byte[] bArr2) {
        return a(bArr, bArr2, 2);
    }

    public static Cipher getAesCbcEncryptCipher(byte[] bArr, byte[] bArr2) {
        return a(bArr, bArr2, 1);
    }

    public static int getAesCbcEncryptContentLen(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return a(getAesCbcEncryptCipher(bArr2, bArr3), bArr);
    }

    public static Cipher getAesGcmDecryptCipher(byte[] bArr, byte[] bArr2) {
        return b(bArr, bArr2, 2);
    }

    public static int getAesGcmEncryptContentLen(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return a(getAesGcmEncryptCipher(bArr2, bArr3), bArr);
    }

    public static Cipher getAesGcmEncryptCipher(byte[] bArr, byte[] bArr2) {
        return b(bArr, bArr2, 1);
    }

    public static int getContent(Cipher cipher, byte[] bArr, int i11, int i12, byte[] bArr2, int i13) throws BadPaddingException, IllegalBlockSizeException, ShortBufferException {
        if (cipher != null && bArr != null) {
            return cipher.doFinal(bArr, i11, i12, bArr2, i13);
        }
        b.b(f33730a, "getEncryptCOntent: cipher is null or content is null");
        return -1;
    }

    public static byte[] getContent(Cipher cipher, byte[] bArr) {
        if (cipher == null || bArr == null) {
            b.b(f33730a, "getEncryptCOntent: cipher is null or content is null");
            return new byte[0];
        }
        try {
            return cipher.doFinal(bArr, 0, bArr.length);
        } catch (BadPaddingException unused) {
            b.b(f33730a, "getContent: BadPaddingException");
            return new byte[0];
        } catch (IllegalBlockSizeException unused2) {
            b.b(f33730a, "getContent: IllegalBlockSizeException");
            return new byte[0];
        }
    }

    private static int a(Cipher cipher, byte[] bArr) {
        if (cipher == null || bArr == null) {
            return -1;
        }
        return cipher.getOutputSize(bArr.length);
    }
}
