package com.google.android.gms.internal.clearcut;

final class zzbm extends zzbk {
    private final byte[] buffer;
    private int limit;
    private int pos;
    private final boolean zzfu;
    private int zzfv;
    private int zzfw;
    private int zzfx;

    private zzbm(byte[] bArr, int i11, int i12, boolean z11) {
        super();
        this.zzfx = Integer.MAX_VALUE;
        this.buffer = bArr;
        this.limit = i12 + i11;
        this.pos = i11;
        this.zzfw = i11;
        this.zzfu = z11;
    }

    public final int zzaf() {
        return this.pos - this.zzfw;
    }

    public final int zzl(int i11) throws zzco {
        if (i11 >= 0) {
            int zzaf = i11 + zzaf();
            int i12 = this.zzfx;
            if (zzaf <= i12) {
                this.zzfx = zzaf;
                int i13 = this.limit + this.zzfv;
                this.limit = i13;
                int i14 = i13 - this.zzfw;
                if (i14 > zzaf) {
                    int i15 = i14 - zzaf;
                    this.zzfv = i15;
                    this.limit = i13 - i15;
                } else {
                    this.zzfv = 0;
                }
                return i12;
            }
            throw zzco.zzbl();
        }
        throw new zzco("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }
}
