package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Arrays;
import org.checkerframework.dataflow.qual.Pure;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public final class zzm {
    public static final zzj<zzm> zza = zzl.zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    @Nullable
    public final byte[] zze;
    private int zzf;

    public zzm(int i11, int i12, int i13, @Nullable byte[] bArr) {
        this.zzb = i11;
        this.zzc = i12;
        this.zzd = i13;
        this.zze = bArr;
    }

    @Pure
    public static int zza(int i11) {
        if (i11 == 1) {
            return 1;
        }
        if (i11 != 9) {
            return (i11 == 4 || i11 == 5 || i11 == 6 || i11 == 7) ? 2 : -1;
        }
        return 6;
    }

    @Pure
    public static int zzb(int i11) {
        if (i11 == 1) {
            return 3;
        }
        if (i11 == 16) {
            return 6;
        }
        if (i11 != 18) {
            return (i11 == 6 || i11 == 7) ? 3 : -1;
        }
        return 7;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzm.class == obj.getClass()) {
            zzm zzm = (zzm) obj;
            if (this.zzb == zzm.zzb && this.zzc == zzm.zzc && this.zzd == zzm.zzd && Arrays.equals(this.zze, zzm.zze)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int i11 = this.zzf;
        if (i11 != 0) {
            return i11;
        }
        int hashCode = ((((((this.zzb + 527) * 31) + this.zzc) * 31) + this.zzd) * 31) + Arrays.hashCode(this.zze);
        this.zzf = hashCode;
        return hashCode;
    }

    public final String toString() {
        int i11 = this.zzb;
        int i12 = this.zzc;
        int i13 = this.zzd;
        boolean z11 = this.zze != null;
        StringBuilder sb2 = new StringBuilder(55);
        sb2.append("ColorInfo(");
        sb2.append(i11);
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        sb2.append(i12);
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        sb2.append(i13);
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        sb2.append(z11);
        sb2.append(")");
        return sb2.toString();
    }
}
