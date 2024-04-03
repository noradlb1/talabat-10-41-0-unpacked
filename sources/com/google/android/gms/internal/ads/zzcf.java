package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import java.util.Arrays;

public final class zzcf {
    public static final zzj<zzcf> zza = zzce.zza;
    public final int zzb = 1;
    private final zzab[] zzc;
    private int zzd;

    public zzcf(zzab... zzabArr) {
        this.zzc = zzabArr;
        zzc(zzabArr[0].zzd);
        int i11 = zzabArr[0].zzf;
    }

    private static String zzc(@Nullable String str) {
        if (str == null || str.equals(C.LANGUAGE_UNDETERMINED)) {
            return "";
        }
        return str;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzcf.class != obj.getClass() || !Arrays.equals(this.zzc, ((zzcf) obj).zzc)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i11 = this.zzd;
        if (i11 != 0) {
            return i11;
        }
        int hashCode = Arrays.hashCode(this.zzc) + 527;
        this.zzd = hashCode;
        return hashCode;
    }

    public final int zza(zzab zzab) {
        for (int i11 = 0; i11 <= 0; i11++) {
            if (zzab == this.zzc[i11]) {
                return i11;
            }
        }
        return -1;
    }

    public final zzab zzb(int i11) {
        return this.zzc[i11];
    }
}
