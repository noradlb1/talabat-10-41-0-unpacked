package com.google.crypto.tink.subtle;

import com.google.crypto.tink.config.internal.TinkFipsUtil;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class AesCtrJceCipher implements IndCpaCipher {
    private static final String CIPHER_ALGORITHM = "AES/CTR/NoPadding";
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    private static final String KEY_ALGORITHM = "AES";
    private static final int MIN_IV_SIZE_IN_BYTES = 12;
    private static final ThreadLocal<Cipher> localCipher = new ThreadLocal<Cipher>() {
        public Cipher initialValue() {
            try {
                return EngineFactory.CIPHER.getInstance(AesCtrJceCipher.CIPHER_ALGORITHM);
            } catch (GeneralSecurityException e11) {
                throw new IllegalStateException(e11);
            }
        }
    };
    private final int blockSize;
    private final int ivSize;
    private final SecretKeySpec keySpec;

    public AesCtrJceCipher(byte[] bArr, int i11) throws GeneralSecurityException {
        if (FIPS.isCompatible()) {
            Validators.validateAesKeySize(bArr.length);
            this.keySpec = new SecretKeySpec(bArr, "AES");
            int blockSize2 = localCipher.get().getBlockSize();
            this.blockSize = blockSize2;
            if (i11 < 12 || i11 > blockSize2) {
                throw new GeneralSecurityException("invalid IV size");
            }
            this.ivSize = i11;
            return;
        }
        throw new GeneralSecurityException("Can not use AES-CTR in FIPS-mode, as BoringCrypto module is not available.");
    }

    private void doCtr(byte[] bArr, int i11, int i12, byte[] bArr2, int i13, byte[] bArr3, boolean z11) throws GeneralSecurityException {
        Cipher cipher = localCipher.get();
        byte[] bArr4 = new byte[this.blockSize];
        System.arraycopy(bArr3, 0, bArr4, 0, this.ivSize);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr4);
        if (z11) {
            cipher.init(1, this.keySpec, ivParameterSpec);
        } else {
            cipher.init(2, this.keySpec, ivParameterSpec);
        }
        if (cipher.doFinal(bArr, i11, i12, bArr2, i13) != i12) {
            throw new GeneralSecurityException("stored output's length does not match input's length");
        }
    }

    public byte[] decrypt(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        int i11 = this.ivSize;
        if (length >= i11) {
            byte[] bArr2 = new byte[i11];
            System.arraycopy(bArr, 0, bArr2, 0, i11);
            int length2 = bArr.length;
            int i12 = this.ivSize;
            byte[] bArr3 = new byte[(length2 - i12)];
            doCtr(bArr, i12, bArr.length - i12, bArr3, 0, bArr2, false);
            return bArr3;
        }
        throw new GeneralSecurityException("ciphertext too short");
    }

    public byte[] encrypt(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        int i11 = this.ivSize;
        if (length <= Integer.MAX_VALUE - i11) {
            byte[] bArr2 = new byte[(bArr.length + i11)];
            byte[] randBytes = Random.randBytes(i11);
            System.arraycopy(randBytes, 0, bArr2, 0, this.ivSize);
            doCtr(bArr, 0, bArr.length, bArr2, this.ivSize, randBytes, true);
            return bArr2;
        }
        throw new GeneralSecurityException("plaintext length can not exceed " + (Integer.MAX_VALUE - this.ivSize));
    }
}
