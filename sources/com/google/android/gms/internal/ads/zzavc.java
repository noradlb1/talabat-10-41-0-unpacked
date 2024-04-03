package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzavc {
    public final int zza = 1;
    private final zzapg[] zzb;
    private int zzc;

    public zzavc(zzapg... zzapgArr) {
        this.zzb = zzapgArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzavc.class != obj.getClass() || !Arrays.equals(this.zzb, ((zzavc) obj).zzb)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i11 = this.zzc;
        if (i11 != 0) {
            return i11;
        }
        int hashCode = Arrays.hashCode(this.zzb) + 527;
        this.zzc = hashCode;
        return hashCode;
    }

    public final int zza(zzapg zzapg) {
        for (int i11 = 0; i11 <= 0; i11++) {
            if (zzapg == this.zzb[i11]) {
                return i11;
            }
        }
        return -1;
    }

    public final zzapg zzb(int i11) {
        return this.zzb[i11];
    }
}
