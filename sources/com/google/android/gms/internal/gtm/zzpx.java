package com.google.android.gms.internal.gtm;

import org.junit.jupiter.api.IndicativeSentencesGeneration;

final class zzpx extends zzqc {
    private final int zzawb;
    private final int zzawc;

    public zzpx(byte[] bArr, int i11, int i12) {
        super(bArr);
        zzps.zzb(i11, i11 + i12, bArr.length);
        this.zzawb = i11;
        this.zzawc = i12;
    }

    public final int size() {
        return this.zzawc;
    }

    public final byte zzak(int i11) {
        int size = size();
        if (((size - (i11 + 1)) | i11) >= 0) {
            return this.zzawe[this.zzawb + i11];
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

    public final byte zzal(int i11) {
        return this.zzawe[this.zzawb + i11];
    }

    public final int zznf() {
        return this.zzawb;
    }
}
