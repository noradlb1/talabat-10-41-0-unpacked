package com.google.crypto.tink.subtle;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import org.apache.commons.compress.archivers.tar.TarConstants;

@Deprecated
abstract class ChaCha20Base implements IndCpaCipher {
    public static final int BLOCK_SIZE_IN_BYTES = 64;
    public static final int BLOCK_SIZE_IN_INTS = 16;
    public static final int KEY_SIZE_IN_BYTES = 32;
    public static final int KEY_SIZE_IN_INTS = 8;
    private static final int[] SIGMA = toIntArray(new byte[]{101, TarConstants.LF_PAX_EXTENDED_HEADER_LC, 112, 97, 110, 100, 32, TarConstants.LF_CHR, TarConstants.LF_SYMLINK, 45, 98, 121, 116, 101, 32, 107});
    private final int initialCounter;
    int[] key;

    public ChaCha20Base(byte[] bArr, int i11) throws InvalidKeyException {
        if (bArr.length == 32) {
            this.key = toIntArray(bArr);
            this.initialCounter = i11;
            return;
        }
        throw new InvalidKeyException("The key length in bytes must be 32.");
    }

    private void process(byte[] bArr, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws GeneralSecurityException {
        int remaining = byteBuffer2.remaining();
        int i11 = (remaining / 64) + 1;
        for (int i12 = 0; i12 < i11; i12++) {
            ByteBuffer chacha20Block = chacha20Block(bArr, this.initialCounter + i12);
            if (i12 == i11 - 1) {
                Bytes.xor(byteBuffer, byteBuffer2, chacha20Block, remaining % 64);
            } else {
                Bytes.xor(byteBuffer, byteBuffer2, chacha20Block, 64);
            }
        }
    }

    public static void quarterRound(int[] iArr, int i11, int i12, int i13, int i14) {
        int i15 = iArr[i11] + iArr[i12];
        iArr[i11] = i15;
        int rotateLeft = rotateLeft(i15 ^ iArr[i14], 16);
        iArr[i14] = rotateLeft;
        int i16 = iArr[i13] + rotateLeft;
        iArr[i13] = i16;
        int rotateLeft2 = rotateLeft(iArr[i12] ^ i16, 12);
        iArr[i12] = rotateLeft2;
        int i17 = iArr[i11] + rotateLeft2;
        iArr[i11] = i17;
        int rotateLeft3 = rotateLeft(iArr[i14] ^ i17, 8);
        iArr[i14] = rotateLeft3;
        int i18 = iArr[i13] + rotateLeft3;
        iArr[i13] = i18;
        iArr[i12] = rotateLeft(iArr[i12] ^ i18, 7);
    }

    private static int rotateLeft(int i11, int i12) {
        return (i11 >>> (-i12)) | (i11 << i12);
    }

    public static void setSigmaAndKey(int[] iArr, int[] iArr2) {
        int[] iArr3 = SIGMA;
        System.arraycopy(iArr3, 0, iArr, 0, iArr3.length);
        System.arraycopy(iArr2, 0, iArr, iArr3.length, 8);
    }

    public static void shuffleState(int[] iArr) {
        int[] iArr2 = iArr;
        for (int i11 = 0; i11 < 10; i11++) {
            quarterRound(iArr2, 0, 4, 8, 12);
            quarterRound(iArr2, 1, 5, 9, 13);
            quarterRound(iArr2, 2, 6, 10, 14);
            quarterRound(iArr2, 3, 7, 11, 15);
            quarterRound(iArr2, 0, 5, 10, 15);
            quarterRound(iArr2, 1, 6, 11, 12);
            quarterRound(iArr2, 2, 7, 8, 13);
            quarterRound(iArr2, 3, 4, 9, 14);
        }
    }

    public static int[] toIntArray(byte[] bArr) {
        IntBuffer asIntBuffer = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        int[] iArr = new int[asIntBuffer.remaining()];
        asIntBuffer.get(iArr);
        return iArr;
    }

    public ByteBuffer chacha20Block(byte[] bArr, int i11) {
        int[] createInitialState = createInitialState(toIntArray(bArr), i11);
        int[] iArr = (int[]) createInitialState.clone();
        shuffleState(iArr);
        for (int i12 = 0; i12 < createInitialState.length; i12++) {
            createInitialState[i12] = createInitialState[i12] + iArr[i12];
        }
        ByteBuffer order = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        order.asIntBuffer().put(createInitialState, 0, 16);
        return order;
    }

    public abstract int[] createInitialState(int[] iArr, int i11);

    public byte[] decrypt(byte[] bArr) throws GeneralSecurityException {
        return decrypt(ByteBuffer.wrap(bArr));
    }

    public byte[] encrypt(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length <= Integer.MAX_VALUE - nonceSizeInBytes()) {
            ByteBuffer allocate = ByteBuffer.allocate(nonceSizeInBytes() + bArr.length);
            encrypt(allocate, bArr);
            return allocate.array();
        }
        throw new GeneralSecurityException("plaintext too long");
    }

    public abstract int nonceSizeInBytes();

    public byte[] decrypt(ByteBuffer byteBuffer) throws GeneralSecurityException {
        if (byteBuffer.remaining() >= nonceSizeInBytes()) {
            byte[] bArr = new byte[nonceSizeInBytes()];
            byteBuffer.get(bArr);
            ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
            process(bArr, allocate, byteBuffer);
            return allocate.array();
        }
        throw new GeneralSecurityException("ciphertext too short");
    }

    public void encrypt(ByteBuffer byteBuffer, byte[] bArr) throws GeneralSecurityException {
        if (byteBuffer.remaining() - nonceSizeInBytes() >= bArr.length) {
            byte[] randBytes = Random.randBytes(nonceSizeInBytes());
            byteBuffer.put(randBytes);
            process(randBytes, byteBuffer, ByteBuffer.wrap(bArr));
            return;
        }
        throw new IllegalArgumentException("Given ByteBuffer output is too small");
    }
}
