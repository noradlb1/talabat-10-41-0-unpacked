package com.google.android.gms.internal.vision;

import org.junit.jupiter.api.IndicativeSentencesGeneration;

final class zzfo extends zzfr {
    private final int zzsb;
    private final int zzsc;

    public zzfo(byte[] bArr, int i11, int i12) {
        super(bArr);
        zzfh.zzc(i11, i11 + i12, bArr.length);
        this.zzsb = i11;
        this.zzsc = i12;
    }

    public final int size() {
        return this.zzsc;
    }

    public final void zza(byte[] bArr, int i11, int i12, int i13) {
        System.arraycopy(this.zzse, zzeu(), bArr, 0, i13);
    }

    public final byte zzan(int i11) {
        int size = size();
        if (((size - (i11 + 1)) | i11) >= 0) {
            return this.zzse[this.zzsb + i11];
        }
        if (i11 < 0) {
            StringBuilder sb2 = new StringBuilder(22);
            sb2.append("Index < 0: ");
            sb2.append(i11);
            throw new ArrayIndexOutOfBoundsException(sb2.toString());
        }
        StringBuilder sb3 = new StringBuilder(40);
        sb3.append("Index > length: ");
        sb3.append(i11);
        sb3.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        sb3.append(size);
        throw new ArrayIndexOutOfBoundsException(sb3.toString());
    }

    public final byte zzao(int i11) {
        return this.zzse[this.zzsb + i11];
    }

    public final int zzeu() {
        return this.zzsb;
    }
}
