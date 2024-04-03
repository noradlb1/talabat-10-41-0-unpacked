package com.google.android.gms.internal.clearcut;

public final class zzfw implements Cloneable {
    private static final zzfx zzrl = new zzfx();
    private int mSize;
    private boolean zzrm;
    private int[] zzrn;
    private zzfx[] zzro;

    public zzfw() {
        this(10);
    }

    private zzfw(int i11) {
        this.zzrm = false;
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
        int i15 = i12 / 4;
        this.zzrn = new int[i15];
        this.zzro = new zzfx[i15];
        this.mSize = 0;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        int i11 = this.mSize;
        zzfw zzfw = new zzfw(i11);
        System.arraycopy(this.zzrn, 0, zzfw.zzrn, 0, i11);
        for (int i12 = 0; i12 < i11; i12++) {
            zzfx zzfx = this.zzro[i12];
            if (zzfx != null) {
                zzfw.zzro[i12] = (zzfx) zzfx.clone();
            }
        }
        zzfw.mSize = i11;
        return zzfw;
    }

    public final boolean equals(Object obj) {
        boolean z11;
        boolean z12;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfw)) {
            return false;
        }
        zzfw zzfw = (zzfw) obj;
        int i11 = this.mSize;
        if (i11 != zzfw.mSize) {
            return false;
        }
        int[] iArr = this.zzrn;
        int[] iArr2 = zzfw.zzrn;
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
            zzfx[] zzfxArr = this.zzro;
            zzfx[] zzfxArr2 = zzfw.zzro;
            int i13 = this.mSize;
            int i14 = 0;
            while (true) {
                if (i14 >= i13) {
                    z12 = true;
                    break;
                } else if (!zzfxArr[i14].equals(zzfxArr2[i14])) {
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
            i11 = (((i11 * 31) + this.zzrn[i12]) * 31) + this.zzro[i12].hashCode();
        }
        return i11;
    }

    public final boolean isEmpty() {
        return this.mSize == 0;
    }

    public final int size() {
        return this.mSize;
    }

    public final zzfx zzaq(int i11) {
        return this.zzro[i11];
    }
}
