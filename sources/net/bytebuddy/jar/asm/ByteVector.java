package net.bytebuddy.jar.asm;

public class ByteVector {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f27349a;

    /* renamed from: b  reason: collision with root package name */
    public int f27350b;

    public ByteVector() {
        this.f27349a = new byte[64];
    }

    private void enlarge(int i11) {
        byte[] bArr = this.f27349a;
        int length = bArr.length * 2;
        int i12 = this.f27350b;
        int i13 = i11 + i12;
        if (length <= i13) {
            length = i13;
        }
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, i12);
        this.f27349a = bArr2;
    }

    public final ByteVector a(String str, int i11, int i12) {
        int i13;
        int length = str.length();
        int i14 = i11;
        int i15 = i14;
        while (i14 < length) {
            char charAt = str.charAt(i14);
            if (charAt >= 1 && charAt <= 127) {
                i15++;
            } else if (charAt <= 2047) {
                i15 += 2;
            } else {
                i15 += 3;
            }
            i14++;
        }
        if (i15 <= i12) {
            int i16 = this.f27350b;
            int i17 = (i16 - i11) - 2;
            if (i17 >= 0) {
                byte[] bArr = this.f27349a;
                bArr[i17] = (byte) (i15 >>> 8);
                bArr[i17 + 1] = (byte) i15;
            }
            if ((i16 + i15) - i11 > this.f27349a.length) {
                enlarge(i15 - i11);
            }
            int i18 = this.f27350b;
            while (i11 < length) {
                char charAt2 = str.charAt(i11);
                if (charAt2 >= 1 && charAt2 <= 127) {
                    i13 = i18 + 1;
                    this.f27349a[i18] = (byte) charAt2;
                } else if (charAt2 <= 2047) {
                    byte[] bArr2 = this.f27349a;
                    int i19 = i18 + 1;
                    bArr2[i18] = (byte) (((charAt2 >> 6) & 31) | 192);
                    i18 = i19 + 1;
                    bArr2[i19] = (byte) ((charAt2 & '?') | 128);
                    i11++;
                } else {
                    byte[] bArr3 = this.f27349a;
                    int i21 = i18 + 1;
                    bArr3[i18] = (byte) (((charAt2 >> 12) & 15) | 224);
                    int i22 = i21 + 1;
                    bArr3[i21] = (byte) (((charAt2 >> 6) & 63) | 128);
                    i13 = i22 + 1;
                    bArr3[i22] = (byte) ((charAt2 & '?') | 128);
                }
                i18 = i13;
                i11++;
            }
            this.f27350b = i18;
            return this;
        }
        throw new IllegalArgumentException("UTF8 string too large");
    }

    public final ByteVector b(int i11, int i12) {
        int i13 = this.f27350b;
        if (i13 + 2 > this.f27349a.length) {
            enlarge(2);
        }
        byte[] bArr = this.f27349a;
        int i14 = i13 + 1;
        bArr[i13] = (byte) i11;
        bArr[i14] = (byte) i12;
        this.f27350b = i14 + 1;
        return this;
    }

    public final ByteVector c(int i11, int i12, int i13) {
        int i14 = this.f27350b;
        if (i14 + 4 > this.f27349a.length) {
            enlarge(4);
        }
        byte[] bArr = this.f27349a;
        int i15 = i14 + 1;
        bArr[i14] = (byte) i11;
        int i16 = i15 + 1;
        bArr[i15] = (byte) i12;
        int i17 = i16 + 1;
        bArr[i16] = (byte) (i13 >>> 8);
        bArr[i17] = (byte) i13;
        this.f27350b = i17 + 1;
        return this;
    }

    public final ByteVector d(int i11, int i12) {
        int i13 = this.f27350b;
        if (i13 + 3 > this.f27349a.length) {
            enlarge(3);
        }
        byte[] bArr = this.f27349a;
        int i14 = i13 + 1;
        bArr[i13] = (byte) i11;
        int i15 = i14 + 1;
        bArr[i14] = (byte) (i12 >>> 8);
        bArr[i15] = (byte) i12;
        this.f27350b = i15 + 1;
        return this;
    }

    public final ByteVector e(int i11, int i12, int i13) {
        int i14 = this.f27350b;
        if (i14 + 5 > this.f27349a.length) {
            enlarge(5);
        }
        byte[] bArr = this.f27349a;
        int i15 = i14 + 1;
        bArr[i14] = (byte) i11;
        int i16 = i15 + 1;
        bArr[i15] = (byte) (i12 >>> 8);
        int i17 = i16 + 1;
        bArr[i16] = (byte) i12;
        int i18 = i17 + 1;
        bArr[i17] = (byte) (i13 >>> 8);
        bArr[i18] = (byte) i13;
        this.f27350b = i18 + 1;
        return this;
    }

    public ByteVector putByte(int i11) {
        int i12 = this.f27350b;
        int i13 = i12 + 1;
        if (i13 > this.f27349a.length) {
            enlarge(1);
        }
        this.f27349a[i12] = (byte) i11;
        this.f27350b = i13;
        return this;
    }

    public ByteVector putByteArray(byte[] bArr, int i11, int i12) {
        if (this.f27350b + i12 > this.f27349a.length) {
            enlarge(i12);
        }
        if (bArr != null) {
            System.arraycopy(bArr, i11, this.f27349a, this.f27350b, i12);
        }
        this.f27350b += i12;
        return this;
    }

    public ByteVector putInt(int i11) {
        int i12 = this.f27350b;
        if (i12 + 4 > this.f27349a.length) {
            enlarge(4);
        }
        byte[] bArr = this.f27349a;
        int i13 = i12 + 1;
        bArr[i12] = (byte) (i11 >>> 24);
        int i14 = i13 + 1;
        bArr[i13] = (byte) (i11 >>> 16);
        int i15 = i14 + 1;
        bArr[i14] = (byte) (i11 >>> 8);
        bArr[i15] = (byte) i11;
        this.f27350b = i15 + 1;
        return this;
    }

    public ByteVector putLong(long j11) {
        int i11 = this.f27350b;
        if (i11 + 8 > this.f27349a.length) {
            enlarge(8);
        }
        byte[] bArr = this.f27349a;
        int i12 = (int) (j11 >>> 32);
        int i13 = i11 + 1;
        bArr[i11] = (byte) (i12 >>> 24);
        int i14 = i13 + 1;
        bArr[i13] = (byte) (i12 >>> 16);
        int i15 = i14 + 1;
        bArr[i14] = (byte) (i12 >>> 8);
        int i16 = i15 + 1;
        bArr[i15] = (byte) i12;
        int i17 = (int) j11;
        int i18 = i16 + 1;
        bArr[i16] = (byte) (i17 >>> 24);
        int i19 = i18 + 1;
        bArr[i18] = (byte) (i17 >>> 16);
        int i21 = i19 + 1;
        bArr[i19] = (byte) (i17 >>> 8);
        bArr[i21] = (byte) i17;
        this.f27350b = i21 + 1;
        return this;
    }

    public ByteVector putShort(int i11) {
        int i12 = this.f27350b;
        if (i12 + 2 > this.f27349a.length) {
            enlarge(2);
        }
        byte[] bArr = this.f27349a;
        int i13 = i12 + 1;
        bArr[i12] = (byte) (i11 >>> 8);
        bArr[i13] = (byte) i11;
        this.f27350b = i13 + 1;
        return this;
    }

    public ByteVector putUTF8(String str) {
        int length = str.length();
        if (length <= 65535) {
            int i11 = this.f27350b;
            if (i11 + 2 + length > this.f27349a.length) {
                enlarge(length + 2);
            }
            byte[] bArr = this.f27349a;
            int i12 = i11 + 1;
            bArr[i11] = (byte) (length >>> 8);
            int i13 = i12 + 1;
            bArr[i12] = (byte) length;
            int i14 = 0;
            while (i14 < length) {
                char charAt = str.charAt(i14);
                if (charAt < 1 || charAt > 127) {
                    this.f27350b = i13;
                    return a(str, i14, 65535);
                }
                bArr[i13] = (byte) charAt;
                i14++;
                i13++;
            }
            this.f27350b = i13;
            return this;
        }
        throw new IllegalArgumentException("UTF8 string too large");
    }

    public ByteVector(int i11) {
        this.f27349a = new byte[i11];
    }

    public ByteVector(byte[] bArr) {
        this.f27349a = bArr;
        this.f27350b = bArr.length;
    }
}
