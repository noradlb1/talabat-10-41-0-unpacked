package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public final class zzavu implements zzavw {
    private final byte[] zza;
    private Uri zzb;
    private int zzc;
    private int zzd;

    public zzavu(byte[] bArr) {
        boolean z11;
        bArr.getClass();
        if (bArr.length > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzawm.zzc(z11);
        this.zza = bArr;
    }

    public final int zza(byte[] bArr, int i11, int i12) throws IOException {
        if (i12 == 0) {
            return 0;
        }
        int i13 = this.zzd;
        if (i13 == 0) {
            return -1;
        }
        int min = Math.min(i12, i13);
        System.arraycopy(this.zza, this.zzc, bArr, i11, min);
        this.zzc += min;
        this.zzd -= min;
        return min;
    }

    public final long zzb(zzavy zzavy) throws IOException {
        long j11;
        this.zzb = zzavy.zza;
        long j12 = zzavy.zzc;
        int i11 = (int) j12;
        this.zzc = i11;
        long j13 = zzavy.zzd;
        if (j13 == -1) {
            j11 = ((long) this.zza.length) - j12;
        } else {
            j11 = j13;
        }
        int i12 = (int) j11;
        this.zzd = i12;
        if (i12 > 0 && i11 + i12 <= this.zza.length) {
            return (long) i12;
        }
        int length = this.zza.length;
        StringBuilder sb2 = new StringBuilder(77);
        sb2.append("Unsatisfiable range: [");
        sb2.append(i11);
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        sb2.append(j13);
        sb2.append("], length: ");
        sb2.append(length);
        throw new IOException(sb2.toString());
    }

    public final Uri zzc() {
        return this.zzb;
    }

    public final void zzd() throws IOException {
        this.zzb = null;
    }
}
