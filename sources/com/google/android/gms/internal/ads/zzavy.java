package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Arrays;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public final class zzavy {
    public final Uri zza;
    public final long zzb;
    public final long zzc;
    public final long zzd;

    public zzavy(Uri uri, byte[] bArr, long j11, long j12, long j13, String str, int i11) {
        boolean z11;
        boolean z12;
        boolean z13 = false;
        if (j11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzawm.zzc(z11);
        if (j12 >= 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        zzawm.zzc(z12);
        zzawm.zzc((j13 > 0 || j13 == -1) ? true : z13);
        this.zza = uri;
        this.zzb = j11;
        this.zzc = j12;
        this.zzd = j13;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        String arrays = Arrays.toString((byte[]) null);
        long j11 = this.zzb;
        long j12 = this.zzc;
        long j13 = this.zzd;
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 93 + String.valueOf(arrays).length() + 4);
        sb2.append("DataSpec[");
        sb2.append(valueOf);
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        sb2.append(arrays);
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        sb2.append(j11);
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        sb2.append(j12);
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        sb2.append(j13);
        sb2.append(", null, 0]");
        return sb2.toString();
    }
}
