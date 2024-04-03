package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Arrays;

public final class zzch {
    public static final zzch zza = new zzch(new zzcf[0]);
    public static final zzj<zzch> zzb = zzcg.zza;
    public final int zzc;
    private final zzcf[] zzd;
    private int zze;

    public zzch(zzcf... zzcfArr) {
        this.zzd = zzcfArr;
        this.zzc = zzcfArr.length;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzch.class == obj.getClass()) {
            zzch zzch = (zzch) obj;
            if (this.zzc != zzch.zzc || !Arrays.equals(this.zzd, zzch.zzd)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i11 = this.zze;
        if (i11 != 0) {
            return i11;
        }
        int hashCode = Arrays.hashCode(this.zzd);
        this.zze = hashCode;
        return hashCode;
    }

    public final int zza(zzcf zzcf) {
        for (int i11 = 0; i11 < this.zzc; i11++) {
            if (this.zzd[i11] == zzcf) {
                return i11;
            }
        }
        return -1;
    }

    public final zzcf zzb(int i11) {
        return this.zzd[i11];
    }
}
