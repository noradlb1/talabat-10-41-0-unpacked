package com.google.crypto.tink.subtle;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import javax.crypto.AEADBadTagException;

@Deprecated
abstract class ChaCha20Poly1305Base implements Aead {
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS;
    private final ChaCha20Base chacha20;
    private final ChaCha20Base macKeyChaCha20;

    public ChaCha20Poly1305Base(byte[] bArr) throws GeneralSecurityException {
        if (FIPS.isCompatible()) {
            this.chacha20 = newChaCha20Instance(bArr, 1);
            this.macKeyChaCha20 = newChaCha20Instance(bArr, 0);
            return;
        }
        throw new GeneralSecurityException("Can not use ChaCha20Poly1305 in FIPS-mode.");
    }

    private byte[] getMacKey(byte[] bArr) throws GeneralSecurityException {
        byte[] bArr2 = new byte[32];
        this.macKeyChaCha20.chacha20Block(bArr, 0).get(bArr2);
        return bArr2;
    }

    private static byte[] macDataRfc8439(byte[] bArr, ByteBuffer byteBuffer) {
        int i11;
        int i12;
        if (bArr.length % 16 == 0) {
            i11 = bArr.length;
        } else {
            i11 = (bArr.length + 16) - (bArr.length % 16);
        }
        int remaining = byteBuffer.remaining();
        int i13 = remaining % 16;
        if (i13 == 0) {
            i12 = remaining;
        } else {
            i12 = (remaining + 16) - i13;
        }
        int i14 = i12 + i11;
        ByteBuffer order = ByteBuffer.allocate(i14 + 16).order(ByteOrder.LITTLE_ENDIAN);
        order.put(bArr);
        order.position(i11);
        order.put(byteBuffer);
        order.position(i14);
        order.putLong((long) bArr.length);
        order.putLong((long) remaining);
        return order.array();
    }

    public byte[] decrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return decrypt(ByteBuffer.wrap(bArr), bArr2);
    }

    public byte[] encrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length <= (Integer.MAX_VALUE - this.chacha20.nonceSizeInBytes()) - 16) {
            ByteBuffer allocate = ByteBuffer.allocate(bArr.length + this.chacha20.nonceSizeInBytes() + 16);
            encrypt(allocate, bArr, bArr2);
            return allocate.array();
        }
        throw new GeneralSecurityException("plaintext too long");
    }

    public abstract ChaCha20Base newChaCha20Instance(byte[] bArr, int i11) throws InvalidKeyException;

    private byte[] decrypt(ByteBuffer byteBuffer, byte[] bArr) throws GeneralSecurityException {
        if (byteBuffer.remaining() >= this.chacha20.nonceSizeInBytes() + 16) {
            int position = byteBuffer.position();
            byte[] bArr2 = new byte[16];
            byteBuffer.position(byteBuffer.limit() - 16);
            byteBuffer.get(bArr2);
            byteBuffer.position(position);
            byteBuffer.limit(byteBuffer.limit() - 16);
            byte[] bArr3 = new byte[this.chacha20.nonceSizeInBytes()];
            byteBuffer.get(bArr3);
            if (bArr == null) {
                bArr = new byte[0];
            }
            try {
                Poly1305.verifyMac(getMacKey(bArr3), macDataRfc8439(bArr, byteBuffer), bArr2);
                byteBuffer.position(position);
                return this.chacha20.decrypt(byteBuffer);
            } catch (GeneralSecurityException e11) {
                throw new AEADBadTagException(e11.toString());
            }
        } else {
            throw new GeneralSecurityException("ciphertext too short");
        }
    }

    private void encrypt(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (byteBuffer.remaining() >= bArr.length + this.chacha20.nonceSizeInBytes() + 16) {
            int position = byteBuffer.position();
            this.chacha20.encrypt(byteBuffer, bArr);
            byteBuffer.position(position);
            byte[] bArr3 = new byte[this.chacha20.nonceSizeInBytes()];
            byteBuffer.get(bArr3);
            byteBuffer.limit(byteBuffer.limit() - 16);
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            byte[] computeMac = Poly1305.computeMac(getMacKey(bArr3), macDataRfc8439(bArr2, byteBuffer));
            byteBuffer.limit(byteBuffer.limit() + 16);
            byteBuffer.put(computeMac);
            return;
        }
        throw new IllegalArgumentException("Given ByteBuffer output is too small");
    }
}
