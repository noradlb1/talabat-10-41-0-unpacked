package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzavd {
    public static final zzavd zza = new zzavd(new zzavc[0]);
    public final int zzb;
    private final zzavc[] zzc;
    private int zzd;

    public zzavd(zzavc... zzavcArr) {
        this.zzc = zzavcArr;
        this.zzb = zzavcArr.length;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzavd.class == obj.getClass()) {
            zzavd zzavd = (zzavd) obj;
            if (this.zzb != zzavd.zzb || !Arrays.equals(this.zzc, zzavd.zzc)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i11 = this.zzd;
        if (i11 != 0) {
            return i11;
        }
        int hashCode = Arrays.hashCode(this.zzc);
        this.zzd = hashCode;
        return hashCode;
    }

    public final int zza(zzavc zzavc) {
        for (int i11 = 0; i11 < this.zzb; i11++) {
            if (this.zzc[i11] == zzavc) {
                return i11;
            }
        }
        return -1;
    }

    public final zzavc zzb(int i11) {
        return this.zzc[i11];
    }
}
