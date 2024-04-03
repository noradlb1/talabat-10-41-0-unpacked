package com.google.crypto.tink.aead.subtle;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.subtle.AesGcmJce;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

@Immutable
public final class AesGcmFactory implements AeadFactory {
    private final int keySizeInBytes;

    public AesGcmFactory(int i11) throws GeneralSecurityException {
        this.keySizeInBytes = validateAesKeySize(i11);
    }

    private static int validateAesKeySize(int i11) throws InvalidAlgorithmParameterException {
        if (i11 == 16 || i11 == 32) {
            return i11;
        }
        throw new InvalidAlgorithmParameterException(String.format("Invalid AES key size, expected 16 or 32, but got %d", new Object[]{Integer.valueOf(i11)}));
    }

    public Aead createAead(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length == getKeySizeInBytes()) {
            return new AesGcmJce(bArr);
        }
        throw new GeneralSecurityException(String.format("Symmetric key has incorrect length; expected %s, but got %s", new Object[]{Integer.valueOf(getKeySizeInBytes()), Integer.valueOf(bArr.length)}));
    }

    public int getKeySizeInBytes() {
        return this.keySizeInBytes;
    }
}
