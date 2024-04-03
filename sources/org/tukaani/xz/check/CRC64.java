package org.tukaani.xz.check;

import java.lang.reflect.Array;

public class CRC64 extends Check {
    private static final long[][] TABLE = ((long[][]) Array.newInstance(Long.TYPE, new int[]{4, 256}));
    private long crc = -1;

    static {
        int i11 = 0;
        while (i11 < 4) {
            for (int i12 = 0; i12 < 256; i12++) {
                long j11 = i11 == 0 ? (long) i12 : TABLE[i11 - 1][i12];
                for (int i13 = 0; i13 < 8; i13++) {
                    int i14 = ((j11 & 1) > 1 ? 1 : ((j11 & 1) == 1 ? 0 : -1));
                    long j12 = j11 >>> 1;
                    if (i14 == 0) {
                        j12 ^= -3932672073523589310L;
                    }
                }
                TABLE[i11][i12] = j11;
            }
            i11++;
        }
    }

    public CRC64() {
        this.f63419a = 8;
        this.f63420b = "CRC64";
    }

    public byte[] finish() {
        long j11 = ~this.crc;
        this.crc = -1;
        byte[] bArr = new byte[8];
        for (int i11 = 0; i11 < 8; i11++) {
            bArr[i11] = (byte) ((int) (j11 >> (i11 * 8)));
        }
        return bArr;
    }

    public void update(byte[] bArr, int i11, int i12) {
        int i13 = i12 + i11;
        int i14 = i13 - 3;
        while (i11 < i14) {
            long j11 = this.crc;
            int i15 = (int) j11;
            long[][] jArr = TABLE;
            this.crc = (((j11 >>> 32) ^ (jArr[3][(i15 & 255) ^ (bArr[i11] & 255)] ^ jArr[2][((i15 >>> 8) & 255) ^ (bArr[i11 + 1] & 255)])) ^ jArr[1][((i15 >>> 16) & 255) ^ (bArr[i11 + 2] & 255)]) ^ jArr[0][((i15 >>> 24) & 255) ^ (bArr[i11 + 3] & 255)];
            i11 += 4;
        }
        while (i11 < i13) {
            long[] jArr2 = TABLE[0];
            long j12 = this.crc;
            this.crc = (j12 >>> 8) ^ jArr2[(bArr[i11] & 255) ^ (((int) j12) & 255)];
            i11++;
        }
    }
}
