package com.google.android.libraries.places.internal;

import org.junit.jupiter.api.IndicativeSentencesGeneration;

final class zzaar extends zzaau {
    private final int zzc;

    public zzaar(byte[] bArr, int i11, int i12) {
        super(bArr);
        zzaax.zzj(0, i12, bArr.length);
        this.zzc = i12;
    }

    public final byte zza(int i11) {
        int i12 = this.zzc;
        if (((i12 - (i11 + 1)) | i11) >= 0) {
            return this.zza[i11];
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
        sb3.append(i12);
        throw new ArrayIndexOutOfBoundsException(sb3.toString());
    }

    public final byte zzb(int i11) {
        return this.zza[i11];
    }

    public final int zzc() {
        return 0;
    }

    public final int zzd() {
        return this.zzc;
    }
}
