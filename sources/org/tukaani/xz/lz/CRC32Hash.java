package org.tukaani.xz.lz;

class CRC32Hash {
    private static final int CRC32_POLY = -306674912;

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f63431a = new int[256];

    static {
        for (int i11 = 0; i11 < 256; i11++) {
            int i12 = i11;
            for (int i13 = 0; i13 < 8; i13++) {
                int i14 = i12 & 1;
                i12 >>>= 1;
                if (i14 != 0) {
                    i12 ^= CRC32_POLY;
                }
            }
            f63431a[i11] = i12;
        }
    }
}
