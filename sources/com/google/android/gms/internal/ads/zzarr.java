package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzarr {
    public final int zza = 1;
    public final byte[] zzb;

    public zzarr(int i11, byte[] bArr) {
        this.zzb = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzarr.class != obj.getClass() || !Arrays.equals(this.zzb, ((zzarr) obj).zzb)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zzb) + 31;
    }
}
