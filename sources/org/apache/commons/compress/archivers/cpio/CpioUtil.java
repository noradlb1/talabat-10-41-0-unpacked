package org.apache.commons.compress.archivers.cpio;

class CpioUtil {
    public static long a(byte[] bArr, boolean z11) {
        if (bArr.length % 2 == 0) {
            int length = bArr.length;
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            if (!z11) {
                int i11 = 0;
                while (i11 < length) {
                    byte b11 = bArr2[i11];
                    int i12 = i11 + 1;
                    bArr2[i11] = bArr2[i12];
                    bArr2[i12] = b11;
                    i11 = i12 + 1;
                }
            }
            long j11 = (long) (bArr2[0] & 255);
            for (int i13 = 1; i13 < length; i13++) {
                j11 = (j11 << 8) | ((long) (bArr2[i13] & 255));
            }
            return j11;
        }
        throw new UnsupportedOperationException();
    }

    public static long b(long j11) {
        return j11 & 61440;
    }

    public static byte[] c(long j11, int i11, boolean z11) {
        byte[] bArr = new byte[i11];
        if (i11 % 2 != 0 || i11 < 2) {
            throw new UnsupportedOperationException();
        }
        for (int i12 = i11 - 1; i12 >= 0; i12--) {
            bArr[i12] = (byte) ((int) (255 & j11));
            j11 >>= 8;
        }
        if (!z11) {
            int i13 = 0;
            while (i13 < i11) {
                byte b11 = bArr[i13];
                int i14 = i13 + 1;
                bArr[i13] = bArr[i14];
                bArr[i14] = b11;
                i13 = i14 + 1;
            }
        }
        return bArr;
    }
}
