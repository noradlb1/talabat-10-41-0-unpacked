package com.google.android.exoplayer2.upstream.crypto;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class AesFlushingCipher {
    private final int blockSize;
    private final Cipher cipher;
    private final byte[] flushedBlock;
    private int pendingXorBytes;
    private final byte[] zerosBlock;

    public AesFlushingCipher(int i11, byte[] bArr, @Nullable String str, long j11) {
        this(i11, bArr, getFNV64Hash(str), j11);
    }

    private static long getFNV64Hash(@Nullable String str) {
        long j11 = 0;
        if (str == null) {
            return 0;
        }
        for (int i11 = 0; i11 < str.length(); i11++) {
            long charAt = j11 ^ ((long) str.charAt(i11));
            j11 = charAt + (charAt << 1) + (charAt << 4) + (charAt << 5) + (charAt << 7) + (charAt << 8) + (charAt << 40);
        }
        return j11;
    }

    private byte[] getInitializationVector(long j11, long j12) {
        return ByteBuffer.allocate(16).putLong(j11).putLong(j12).array();
    }

    private int nonFlushingUpdate(byte[] bArr, int i11, int i12, byte[] bArr2, int i13) {
        try {
            return this.cipher.update(bArr, i11, i12, bArr2, i13);
        } catch (ShortBufferException e11) {
            throw new RuntimeException(e11);
        }
    }

    public void update(byte[] bArr, int i11, int i12, byte[] bArr2, int i13) {
        boolean z11;
        int i14 = i11;
        do {
            int i15 = this.pendingXorBytes;
            if (i15 > 0) {
                bArr2[i13] = (byte) (bArr[i14] ^ this.flushedBlock[this.blockSize - i15]);
                i13++;
                i14++;
                this.pendingXorBytes = i15 - 1;
                i12--;
            } else {
                int nonFlushingUpdate = nonFlushingUpdate(bArr, i14, i12, bArr2, i13);
                if (i12 != nonFlushingUpdate) {
                    int i16 = i12 - nonFlushingUpdate;
                    int i17 = 0;
                    boolean z12 = true;
                    if (i16 < this.blockSize) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    Assertions.checkState(z11);
                    int i18 = i13 + nonFlushingUpdate;
                    int i19 = this.blockSize - i16;
                    this.pendingXorBytes = i19;
                    if (nonFlushingUpdate(this.zerosBlock, 0, i19, this.flushedBlock, 0) != this.blockSize) {
                        z12 = false;
                    }
                    Assertions.checkState(z12);
                    while (i17 < i16) {
                        bArr2[i18] = this.flushedBlock[i17];
                        i17++;
                        i18++;
                    }
                    return;
                }
                return;
            }
        } while (i12 != 0);
    }

    public void updateInPlace(byte[] bArr, int i11, int i12) {
        update(bArr, i11, i12, bArr, i11);
    }

    public AesFlushingCipher(int i11, byte[] bArr, long j11, long j12) {
        try {
            Cipher instance = Cipher.getInstance("AES/CTR/NoPadding");
            this.cipher = instance;
            int blockSize2 = instance.getBlockSize();
            this.blockSize = blockSize2;
            this.zerosBlock = new byte[blockSize2];
            this.flushedBlock = new byte[blockSize2];
            long j13 = j12 / ((long) blockSize2);
            int i12 = (int) (j12 % ((long) blockSize2));
            instance.init(i11, new SecretKeySpec(bArr, Util.splitAtFirst(instance.getAlgorithm(), "/")[0]), new IvParameterSpec(getInitializationVector(j11, j13)));
            if (i12 != 0) {
                updateInPlace(new byte[i12], 0, i12);
            }
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException e11) {
            throw new RuntimeException(e11);
        }
    }
}
