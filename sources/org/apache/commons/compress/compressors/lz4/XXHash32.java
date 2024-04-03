package org.apache.commons.compress.compressors.lz4;

import java.util.zip.Checksum;
import org.apache.commons.compress.utils.ByteUtils;

public class XXHash32 implements Checksum {
    private static final int BUF_SIZE = 16;
    private static final int PRIME1 = -1640531535;
    private static final int PRIME2 = -2048144777;
    private static final int PRIME3 = -1028477379;
    private static final int PRIME4 = 668265263;
    private static final int PRIME5 = 374761393;
    private static final int ROTATE_BITS = 13;
    private final byte[] buffer;
    private final byte[] oneByte;
    private int pos;
    private final int seed;
    private final int[] state;
    private int totalLen;

    public XXHash32() {
        this(0);
    }

    private static int getInt(byte[] bArr, int i11) {
        return (int) (ByteUtils.fromLittleEndian(bArr, i11, 4) & 4294967295L);
    }

    private void initializeState() {
        int[] iArr = this.state;
        int i11 = this.seed;
        iArr[0] = i11 + PRIME1 + PRIME2;
        iArr[1] = PRIME2 + i11;
        iArr[2] = i11;
        iArr[3] = i11 - PRIME1;
    }

    private void process(byte[] bArr, int i11) {
        int[] iArr = this.state;
        int i12 = iArr[0];
        int i13 = iArr[1];
        int i14 = iArr[2];
        int i15 = iArr[3];
        int rotateLeft = Integer.rotateLeft(i12 + (getInt(bArr, i11) * PRIME2), 13) * PRIME1;
        int rotateLeft2 = Integer.rotateLeft(i13 + (getInt(bArr, i11 + 4) * PRIME2), 13) * PRIME1;
        int rotateLeft3 = Integer.rotateLeft(i14 + (getInt(bArr, i11 + 8) * PRIME2), 13) * PRIME1;
        int rotateLeft4 = Integer.rotateLeft(i15 + (getInt(bArr, i11 + 12) * PRIME2), 13) * PRIME1;
        int[] iArr2 = this.state;
        iArr2[0] = rotateLeft;
        iArr2[1] = rotateLeft2;
        iArr2[2] = rotateLeft3;
        iArr2[3] = rotateLeft4;
        this.pos = 0;
    }

    public long getValue() {
        int i11;
        int i12 = 0;
        if (this.totalLen > 16) {
            i11 = Integer.rotateLeft(this.state[0], 1) + Integer.rotateLeft(this.state[1], 7) + Integer.rotateLeft(this.state[2], 12) + Integer.rotateLeft(this.state[3], 18);
        } else {
            i11 = this.state[2] + PRIME5;
        }
        int i13 = i11 + this.totalLen;
        int i14 = this.pos - 4;
        while (i12 <= i14) {
            i13 = Integer.rotateLeft(i13 + (getInt(this.buffer, i12) * PRIME3), 17) * PRIME4;
            i12 += 4;
        }
        while (i12 < this.pos) {
            i13 = Integer.rotateLeft(i13 + ((this.buffer[i12] & 255) * PRIME5), 11) * PRIME1;
            i12++;
        }
        int i15 = (i13 ^ (i13 >>> 15)) * PRIME2;
        int i16 = (i15 ^ (i15 >>> 13)) * PRIME3;
        return ((long) (i16 ^ (i16 >>> 16))) & 4294967295L;
    }

    public void reset() {
        initializeState();
        this.totalLen = 0;
        this.pos = 0;
    }

    public void update(int i11) {
        byte[] bArr = this.oneByte;
        bArr[0] = (byte) (i11 & 255);
        update(bArr, 0, 1);
    }

    public XXHash32(int i11) {
        this.oneByte = new byte[1];
        this.state = new int[4];
        this.buffer = new byte[16];
        this.seed = i11;
        initializeState();
    }

    public void update(byte[] bArr, int i11, int i12) {
        if (i12 > 0) {
            this.totalLen += i12;
            int i13 = i11 + i12;
            int i14 = this.pos;
            if (i14 + i12 < 16) {
                System.arraycopy(bArr, i11, this.buffer, i14, i12);
                this.pos += i12;
                return;
            }
            if (i14 > 0) {
                int i15 = 16 - i14;
                System.arraycopy(bArr, i11, this.buffer, i14, i15);
                process(this.buffer, 0);
                i11 += i15;
            }
            int i16 = i13 - 16;
            while (i11 <= i16) {
                process(bArr, i11);
                i11 += 16;
            }
            if (i11 < i13) {
                int i17 = i13 - i11;
                this.pos = i17;
                System.arraycopy(bArr, i11, this.buffer, 0, i17);
            }
        }
    }
}
