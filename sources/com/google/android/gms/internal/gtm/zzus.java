package com.google.android.gms.internal.gtm;

public final class zzus implements Cloneable {
    private static final zzut zzbhe = new zzut();
    private int mSize;
    private boolean zzbhf;
    private int[] zzbhg;
    private zzut[] zzbhh;

    public zzus() {
        this(10);
    }

    private static int idealIntArraySize(int i11) {
        int i12 = i11 << 2;
        int i13 = 4;
        while (true) {
            if (i13 >= 32) {
                break;
            }
            int i14 = (1 << i13) - 12;
            if (i12 <= i14) {
                i12 = i14;
                break;
            }
            i13++;
        }
        return i12 / 4;
    }

    private final int zzcf(int i11) {
        int i12 = this.mSize - 1;
        int i13 = 0;
        while (i13 <= i12) {
            int i14 = (i13 + i12) >>> 1;
            int i15 = this.zzbhg[i14];
            if (i15 < i11) {
                i13 = i14 + 1;
            } else if (i15 <= i11) {
                return i14;
            } else {
                i12 = i14 - 1;
            }
        }
        return ~i13;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        int i11 = this.mSize;
        zzus zzus = new zzus(i11);
        System.arraycopy(this.zzbhg, 0, zzus.zzbhg, 0, i11);
        for (int i12 = 0; i12 < i11; i12++) {
            zzut zzut = this.zzbhh[i12];
            if (zzut != null) {
                zzus.zzbhh[i12] = (zzut) zzut.clone();
            }
        }
        zzus.mSize = i11;
        return zzus;
    }

    public final boolean equals(Object obj) {
        boolean z11;
        boolean z12;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzus)) {
            return false;
        }
        zzus zzus = (zzus) obj;
        int i11 = this.mSize;
        if (i11 != zzus.mSize) {
            return false;
        }
        int[] iArr = this.zzbhg;
        int[] iArr2 = zzus.zzbhg;
        int i12 = 0;
        while (true) {
            if (i12 >= i11) {
                z11 = true;
                break;
            } else if (iArr[i12] != iArr2[i12]) {
                z11 = false;
                break;
            } else {
                i12++;
            }
        }
        if (z11) {
            zzut[] zzutArr = this.zzbhh;
            zzut[] zzutArr2 = zzus.zzbhh;
            int i13 = this.mSize;
            int i14 = 0;
            while (true) {
                if (i14 >= i13) {
                    z12 = true;
                    break;
                } else if (!zzutArr[i14].equals(zzutArr2[i14])) {
                    z12 = false;
                    break;
                } else {
                    i14++;
                }
            }
            if (z12) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i11 = 17;
        for (int i12 = 0; i12 < this.mSize; i12++) {
            i11 = (((i11 * 31) + this.zzbhg[i12]) * 31) + this.zzbhh[i12].hashCode();
        }
        return i11;
    }

    public final boolean isEmpty() {
        return this.mSize == 0;
    }

    public final int size() {
        return this.mSize;
    }

    public final void zza(int i11, zzut zzut) {
        int zzcf = zzcf(i11);
        if (zzcf >= 0) {
            this.zzbhh[zzcf] = zzut;
            return;
        }
        int i12 = ~zzcf;
        int i13 = this.mSize;
        if (i12 < i13) {
            zzut[] zzutArr = this.zzbhh;
            if (zzutArr[i12] == zzbhe) {
                this.zzbhg[i12] = i11;
                zzutArr[i12] = zzut;
                return;
            }
        }
        if (i13 >= this.zzbhg.length) {
            int idealIntArraySize = idealIntArraySize(i13 + 1);
            int[] iArr = new int[idealIntArraySize];
            zzut[] zzutArr2 = new zzut[idealIntArraySize];
            int[] iArr2 = this.zzbhg;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            zzut[] zzutArr3 = this.zzbhh;
            System.arraycopy(zzutArr3, 0, zzutArr2, 0, zzutArr3.length);
            this.zzbhg = iArr;
            this.zzbhh = zzutArr2;
        }
        int i14 = this.mSize;
        if (i14 - i12 != 0) {
            int[] iArr3 = this.zzbhg;
            int i15 = i12 + 1;
            System.arraycopy(iArr3, i12, iArr3, i15, i14 - i12);
            zzut[] zzutArr4 = this.zzbhh;
            System.arraycopy(zzutArr4, i12, zzutArr4, i15, this.mSize - i12);
        }
        this.zzbhg[i12] = i11;
        this.zzbhh[i12] = zzut;
        this.mSize++;
    }

    public final zzut zzcd(int i11) {
        zzut zzut;
        int zzcf = zzcf(i11);
        if (zzcf < 0 || (zzut = this.zzbhh[zzcf]) == zzbhe) {
            return null;
        }
        return zzut;
    }

    public final zzut zzce(int i11) {
        return this.zzbhh[i11];
    }

    private zzus(int i11) {
        this.zzbhf = false;
        int idealIntArraySize = idealIntArraySize(i11);
        this.zzbhg = new int[idealIntArraySize];
        this.zzbhh = new zzut[idealIntArraySize];
        this.mSize = 0;
    }
}
