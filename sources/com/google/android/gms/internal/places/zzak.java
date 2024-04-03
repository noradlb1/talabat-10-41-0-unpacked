package com.google.android.gms.internal.places;

final class zzak extends zzai {
    private final byte[] buffer;
    private int limit;
    private int pos;
    private final boolean zzet;
    private int zzeu;
    private int zzev;
    private int zzew;

    private zzak(byte[] bArr, int i11, int i12, boolean z11) {
        super();
        this.zzew = Integer.MAX_VALUE;
        this.buffer = bArr;
        this.limit = i12 + i11;
        this.pos = i11;
        this.zzev = i11;
        this.zzet = z11;
    }

    public final int zzaj() {
        return this.pos - this.zzev;
    }

    public final int zzl(int i11) throws zzbk {
        if (i11 >= 0) {
            int zzaj = i11 + zzaj();
            int i12 = this.zzew;
            if (zzaj <= i12) {
                this.zzew = zzaj;
                int i13 = this.limit + this.zzeu;
                this.limit = i13;
                int i14 = i13 - this.zzev;
                if (i14 > zzaj) {
                    int i15 = i14 - zzaj;
                    this.zzeu = i15;
                    this.limit = i13 - i15;
                } else {
                    this.zzeu = 0;
                }
                return i12;
            }
            throw zzbk.zzbp();
        }
        throw zzbk.zzbq();
    }
}
