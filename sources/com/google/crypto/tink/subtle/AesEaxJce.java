package com.google.crypto.tink.subtle;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.AEADBadTagException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class AesEaxJce implements Aead {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int BLOCK_SIZE_IN_BYTES = 16;
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS;
    static final int TAG_SIZE_IN_BYTES = 16;
    private static final ThreadLocal<Cipher> localCtrCipher = new ThreadLocal<Cipher>() {
        public Cipher initialValue() {
            try {
                return EngineFactory.CIPHER.getInstance("AES/CTR/NOPADDING");
            } catch (GeneralSecurityException e11) {
                throw new IllegalStateException(e11);
            }
        }
    };
    private static final ThreadLocal<Cipher> localEcbCipher = new ThreadLocal<Cipher>() {
        public Cipher initialValue() {
            try {
                return EngineFactory.CIPHER.getInstance("AES/ECB/NOPADDING");
            } catch (GeneralSecurityException e11) {
                throw new IllegalStateException(e11);
            }
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f47305b;
    private final int ivSizeInBytes;
    private final SecretKeySpec keySpec;

    /* renamed from: p  reason: collision with root package name */
    private final byte[] f47306p;

    public AesEaxJce(byte[] bArr, int i11) throws GeneralSecurityException {
        if (!FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use AES-EAX in FIPS-mode.");
        } else if (i11 == 12 || i11 == 16) {
            this.ivSizeInBytes = i11;
            Validators.validateAesKeySize(bArr.length);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            this.keySpec = secretKeySpec;
            Cipher cipher = localEcbCipher.get();
            cipher.init(1, secretKeySpec);
            byte[] multiplyByX = multiplyByX(cipher.doFinal(new byte[16]));
            this.f47305b = multiplyByX;
            this.f47306p = multiplyByX(multiplyByX);
        } else {
            throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
        }
    }

    private static byte[] multiplyByX(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i11 = 0;
        while (i11 < 15) {
            int i12 = i11 + 1;
            bArr2[i11] = (byte) (((bArr[i11] << 1) ^ ((bArr[i12] & 255) >>> 7)) & 255);
            i11 = i12;
        }
        bArr2[15] = (byte) (((bArr[0] >> 7) & 135) ^ (bArr[15] << 1));
        return bArr2;
    }

    private byte[] omac(Cipher cipher, int i11, byte[] bArr, int i12, int i13) throws IllegalBlockSizeException, BadPaddingException {
        byte[] bArr2 = new byte[16];
        bArr2[15] = (byte) i11;
        if (i13 == 0) {
            return cipher.doFinal(xor(bArr2, this.f47305b));
        }
        byte[] doFinal = cipher.doFinal(bArr2);
        int i14 = 0;
        while (i13 - i14 > 16) {
            for (int i15 = 0; i15 < 16; i15++) {
                doFinal[i15] = (byte) (doFinal[i15] ^ bArr[(i12 + i14) + i15]);
            }
            doFinal = cipher.doFinal(doFinal);
            i14 += 16;
        }
        return cipher.doFinal(xor(doFinal, pad(Arrays.copyOfRange(bArr, i14 + i12, i12 + i13))));
    }

    private byte[] pad(byte[] bArr) {
        if (bArr.length == 16) {
            return xor(bArr, this.f47305b);
        }
        byte[] copyOf = Arrays.copyOf(this.f47306p, 16);
        for (int i11 = 0; i11 < bArr.length; i11++) {
            copyOf[i11] = (byte) (copyOf[i11] ^ bArr[i11]);
        }
        copyOf[bArr.length] = (byte) (copyOf[bArr.length] ^ 128);
        return copyOf;
    }

    private static byte[] xor(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        byte[] bArr3 = new byte[length];
        for (int i11 = 0; i11 < length; i11++) {
            bArr3[i11] = (byte) (bArr[i11] ^ bArr2[i11]);
        }
        return bArr3;
    }

    public byte[] decrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = (bArr.length - this.ivSizeInBytes) - 16;
        if (length >= 0) {
            Cipher cipher = localEcbCipher.get();
            cipher.init(1, this.keySpec);
            byte[] omac = omac(cipher, 0, bArr, 0, this.ivSizeInBytes);
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            byte[] bArr3 = bArr2;
            byte[] omac2 = omac(cipher, 1, bArr3, 0, bArr3.length);
            byte[] omac3 = omac(cipher, 2, bArr, this.ivSizeInBytes, length);
            int length2 = bArr.length - 16;
            byte b11 = 0;
            for (int i11 = 0; i11 < 16; i11++) {
                b11 = (byte) (b11 | (((bArr[length2 + i11] ^ omac2[i11]) ^ omac[i11]) ^ omac3[i11]));
            }
            if (b11 == 0) {
                Cipher cipher2 = localCtrCipher.get();
                cipher2.init(1, this.keySpec, new IvParameterSpec(omac));
                return cipher2.doFinal(bArr, this.ivSizeInBytes, length);
            }
            throw new AEADBadTagException("tag mismatch");
        }
        throw new GeneralSecurityException("ciphertext too short");
    }

    public byte[] encrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3;
        byte[] bArr4 = bArr;
        int length = bArr4.length;
        int i11 = this.ivSizeInBytes;
        if (length <= (Integer.MAX_VALUE - i11) - 16) {
            byte[] bArr5 = new byte[(bArr4.length + i11 + 16)];
            byte[] randBytes = Random.randBytes(i11);
            System.arraycopy(randBytes, 0, bArr5, 0, this.ivSizeInBytes);
            Cipher cipher = localEcbCipher.get();
            cipher.init(1, this.keySpec);
            byte[] omac = omac(cipher, 0, randBytes, 0, randBytes.length);
            if (bArr2 == null) {
                bArr3 = new byte[0];
            } else {
                bArr3 = bArr2;
            }
            byte[] omac2 = omac(cipher, 1, bArr3, 0, bArr3.length);
            Cipher cipher2 = localCtrCipher.get();
            cipher2.init(1, this.keySpec, new IvParameterSpec(omac));
            cipher2.doFinal(bArr, 0, bArr4.length, bArr5, this.ivSizeInBytes);
            byte[] omac3 = omac(cipher, 2, bArr5, this.ivSizeInBytes, bArr4.length);
            int length2 = bArr4.length + this.ivSizeInBytes;
            for (int i12 = 0; i12 < 16; i12++) {
                bArr5[length2 + i12] = (byte) ((omac2[i12] ^ omac[i12]) ^ omac3[i12]);
            }
            return bArr5;
        }
        throw new GeneralSecurityException("plaintext too long");
    }
}
