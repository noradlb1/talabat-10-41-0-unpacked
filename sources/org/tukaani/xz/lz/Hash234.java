package org.tukaani.xz.lz;

import org.tukaani.xz.ArrayCache;

final class Hash234 extends CRC32Hash {
    private static final int HASH_2_MASK = 1023;
    private static final int HASH_2_SIZE = 1024;
    private static final int HASH_3_MASK = 65535;
    private static final int HASH_3_SIZE = 65536;
    private final int[] hash2Table;
    private int hash2Value = 0;
    private final int[] hash3Table;
    private int hash3Value = 0;
    private final int hash4Mask;
    private final int hash4Size;
    private final int[] hash4Table;
    private int hash4Value = 0;

    public Hash234(int i11, ArrayCache arrayCache) {
        this.hash2Table = arrayCache.getIntArray(1024, true);
        this.hash3Table = arrayCache.getIntArray(65536, true);
        int e11 = e(i11);
        this.hash4Size = e11;
        this.hash4Table = arrayCache.getIntArray(e11, true);
        this.hash4Mask = e11 - 1;
    }

    public static int e(int i11) {
        int i12 = i11 - 1;
        int i13 = i12 | (i12 >>> 1);
        int i14 = i13 | (i13 >>> 2);
        int i15 = i14 | (i14 >>> 4);
        int i16 = ((i15 | (i15 >>> 8)) >>> 1) | 65535;
        if (i16 > 16777216) {
            i16 >>>= 1;
        }
        return i16 + 1;
    }

    public static int f(int i11) {
        return ((e(i11) + 66560) / 256) + 4;
    }

    public void a(byte[] bArr, int i11) {
        int[] iArr = CRC32Hash.f63431a;
        byte b11 = iArr[bArr[i11] & 255] ^ (bArr[i11 + 1] & 255);
        this.hash2Value = b11 & 1023;
        byte b12 = b11 ^ ((bArr[i11 + 2] & 255) << 8);
        this.hash3Value = 65535 & b12;
        this.hash4Value = ((iArr[bArr[i11 + 3] & 255] << 5) ^ b12) & this.hash4Mask;
    }

    public int b() {
        return this.hash2Table[this.hash2Value];
    }

    public int c() {
        return this.hash3Table[this.hash3Value];
    }

    public int d() {
        return this.hash4Table[this.hash4Value];
    }

    public void g(int i11) {
        LZEncoder.b(this.hash2Table, 1024, i11);
        LZEncoder.b(this.hash3Table, 65536, i11);
        LZEncoder.b(this.hash4Table, this.hash4Size, i11);
    }

    public void h(ArrayCache arrayCache) {
        arrayCache.putArray(this.hash4Table);
        arrayCache.putArray(this.hash3Table);
        arrayCache.putArray(this.hash2Table);
    }

    public void i(int i11) {
        this.hash2Table[this.hash2Value] = i11;
        this.hash3Table[this.hash3Value] = i11;
        this.hash4Table[this.hash4Value] = i11;
    }
}
