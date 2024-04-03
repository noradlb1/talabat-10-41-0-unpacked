package com.google.crypto.tink.aead.internal;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

public final class InsecureNonceXChaCha20Poly1305 extends InsecureNonceChaCha20Poly1305Base {
    public InsecureNonceXChaCha20Poly1305(byte[] bArr) throws GeneralSecurityException {
        super(bArr);
    }

    public /* bridge */ /* synthetic */ byte[] decrypt(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return super.decrypt(byteBuffer, bArr, bArr2);
    }

    public /* bridge */ /* synthetic */ void encrypt(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        super.encrypt(byteBuffer, bArr, bArr2, bArr3);
    }

    public InsecureNonceChaCha20Base newChaCha20Instance(byte[] bArr, int i11) throws InvalidKeyException {
        return new InsecureNonceXChaCha20(bArr, i11);
    }

    public /* bridge */ /* synthetic */ byte[] decrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        return super.decrypt(bArr, bArr2, bArr3);
    }

    public /* bridge */ /* synthetic */ byte[] encrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        return super.encrypt(bArr, bArr2, bArr3);
    }
}
