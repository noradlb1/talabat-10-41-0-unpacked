package com.google.crypto.tink.aead.internal;

import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.subtle.EngineFactory;
import com.google.crypto.tink.subtle.SubtleUtil;
import com.google.crypto.tink.subtle.Validators;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class InsecureNonceAesGcmJce {
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    public static final int IV_SIZE_IN_BYTES = 12;
    public static final int TAG_SIZE_IN_BYTES = 16;
    private static final ThreadLocal<Cipher> localCipher = new ThreadLocal<Cipher>() {
        public Cipher initialValue() {
            try {
                return EngineFactory.CIPHER.getInstance("AES/GCM/NoPadding");
            } catch (GeneralSecurityException e11) {
                throw new IllegalStateException(e11);
            }
        }
    };
    private final SecretKey keySpec;
    private final boolean prependIv;

    public InsecureNonceAesGcmJce(byte[] bArr, boolean z11) throws GeneralSecurityException {
        if (FIPS.isCompatible()) {
            Validators.validateAesKeySize(bArr.length);
            this.keySpec = new SecretKeySpec(bArr, "AES");
            this.prependIv = z11;
            return;
        }
        throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
    }

    private static AlgorithmParameterSpec getParams(byte[] bArr) throws GeneralSecurityException {
        return getParams(bArr, 0, bArr.length);
    }

    public byte[] decrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        int i11;
        int i12;
        if (bArr.length == 12) {
            boolean z11 = this.prependIv;
            if (z11) {
                i11 = 28;
            } else {
                i11 = 16;
            }
            if (bArr2.length >= i11) {
                int i13 = 0;
                if (!z11 || ByteBuffer.wrap(bArr).equals(ByteBuffer.wrap(bArr2, 0, 12))) {
                    AlgorithmParameterSpec params = getParams(bArr);
                    ThreadLocal<Cipher> threadLocal = localCipher;
                    threadLocal.get().init(2, this.keySpec, params);
                    if (!(bArr3 == null || bArr3.length == 0)) {
                        threadLocal.get().updateAAD(bArr3);
                    }
                    boolean z12 = this.prependIv;
                    if (z12) {
                        i13 = 12;
                    }
                    if (z12) {
                        i12 = bArr2.length - 12;
                    } else {
                        i12 = bArr2.length;
                    }
                    return threadLocal.get().doFinal(bArr2, i13, i12);
                }
                throw new GeneralSecurityException("iv does not match prepended iv");
            }
            throw new GeneralSecurityException("ciphertext too short");
        }
        throw new GeneralSecurityException("iv is wrong size");
    }

    public byte[] encrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        int i11;
        int i12;
        if (bArr.length != 12) {
            throw new GeneralSecurityException("iv is wrong size");
        } else if (bArr2.length <= 2147483619) {
            boolean z11 = this.prependIv;
            if (z11) {
                i11 = bArr2.length + 12;
            } else {
                i11 = bArr2.length;
            }
            byte[] bArr4 = new byte[(i11 + 16)];
            if (z11) {
                System.arraycopy(bArr, 0, bArr4, 0, 12);
            }
            AlgorithmParameterSpec params = getParams(bArr);
            ThreadLocal<Cipher> threadLocal = localCipher;
            threadLocal.get().init(1, this.keySpec, params);
            if (!(bArr3 == null || bArr3.length == 0)) {
                threadLocal.get().updateAAD(bArr3);
            }
            if (this.prependIv) {
                i12 = 12;
            } else {
                i12 = 0;
            }
            int doFinal = threadLocal.get().doFinal(bArr2, 0, bArr2.length, bArr4, i12);
            if (doFinal == bArr2.length + 16) {
                return bArr4;
            }
            throw new GeneralSecurityException(String.format("encryption failed; GCM tag must be %s bytes, but got only %s bytes", new Object[]{16, Integer.valueOf(doFinal - bArr2.length)}));
        } else {
            throw new GeneralSecurityException("plaintext too long");
        }
    }

    private static AlgorithmParameterSpec getParams(byte[] bArr, int i11, int i12) throws GeneralSecurityException {
        if (!SubtleUtil.isAndroid() || SubtleUtil.androidApiLevel() > 19) {
            return new GCMParameterSpec(128, bArr, i11, i12);
        }
        return new IvParameterSpec(bArr, i11, i12);
    }
}
