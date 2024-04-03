package com.google.android.gms.internal.places;

import org.junit.jupiter.api.IndicativeSentencesGeneration;

final class zzz extends zzag {
    private final int zzek;
    private final int zzel;

    public zzz(byte[] bArr, int i11, int i12) {
        super(bArr);
        zzw.zzc(i11, i11 + i12, bArr.length);
        this.zzek = i11;
        this.zzel = i12;
    }

    public final int size() {
        return this.zzel;
    }

    public final int zzag() {
        return this.zzek;
    }

    public final void zzb(byte[] bArr, int i11, int i12, int i13) {
        System.arraycopy(this.zzen, zzag(), bArr, 0, i13);
    }

    public final byte zzi(int i11) {
        int size = size();
        if (((size - (i11 + 1)) | i11) >= 0) {
            return this.zzen[this.zzek + i11];
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

    public final byte zzj(int i11) {
        return this.zzen[this.zzek + i11];
    }
}
