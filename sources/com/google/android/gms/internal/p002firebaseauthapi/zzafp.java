package com.google.android.gms.internal.p002firebaseauthapi;

import org.junit.jupiter.api.IndicativeSentencesGeneration;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafp  reason: invalid package */
final class zzafp extends zzafs {
    private final int zzc;

    public zzafp(byte[] bArr, int i11, int i12) {
        super(bArr);
        zzafv.zzl(0, i12, bArr.length);
        this.zzc = i12;
    }

    public final byte zza(int i11) {
        int i12 = this.zzc;
        if (((i12 - (i11 + 1)) | i11) >= 0) {
            return this.zza[i11];
        }
        if (i11 < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i11);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i11 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + i12);
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

    public final void zze(byte[] bArr, int i11, int i12, int i13) {
        System.arraycopy(this.zza, 0, bArr, 0, i13);
    }
}
