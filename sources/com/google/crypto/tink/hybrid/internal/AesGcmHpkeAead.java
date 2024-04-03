package com.google.crypto.tink.hybrid.internal;

import com.google.crypto.tink.aead.internal.InsecureNonceAesGcmJce;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

@Immutable
final class AesGcmHpkeAead implements HpkeAead {
    private final int keyLength;

    public AesGcmHpkeAead(int i11) throws InvalidAlgorithmParameterException {
        if (i11 == 16 || i11 == 32) {
            this.keyLength = i11;
            return;
        }
        throw new InvalidAlgorithmParameterException("Unsupported key length: " + i11);
    }

    public byte[] getAeadId() throws GeneralSecurityException {
        int i11 = this.keyLength;
        if (i11 == 16) {
            return HpkeUtil.AES_128_GCM_AEAD_ID;
        }
        if (i11 == 32) {
            return HpkeUtil.AES_256_GCM_AEAD_ID;
        }
        throw new GeneralSecurityException("Could not determine HPKE AEAD ID");
    }

    public int getKeyLength() {
        return this.keyLength;
    }

    public int getNonceLength() {
        return 12;
    }

    public byte[] open(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) throws GeneralSecurityException {
        if (bArr.length == this.keyLength) {
            return new InsecureNonceAesGcmJce(bArr, false).decrypt(bArr2, bArr3, bArr4);
        }
        throw new InvalidAlgorithmParameterException("Unexpected key length: " + bArr.length);
    }

    public byte[] seal(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) throws GeneralSecurityException {
        if (bArr.length == this.keyLength) {
            return new InsecureNonceAesGcmJce(bArr, false).encrypt(bArr2, bArr3, bArr4);
        }
        throw new InvalidAlgorithmParameterException("Unexpected key length: " + bArr.length);
    }
}
