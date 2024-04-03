package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzavp {
    private int zza;
    private final zzavh[] zzb;

    public zzavp(zzavh[] zzavhArr, byte... bArr) {
        this.zzb = zzavhArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzavp.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.zzb, ((zzavp) obj).zzb);
    }

    public final int hashCode() {
        int i11 = this.zza;
        if (i11 != 0) {
            return i11;
        }
        int hashCode = Arrays.hashCode(this.zzb) + 527;
        this.zza = hashCode;
        return hashCode;
    }

    public final zzavh zza(int i11) {
        return this.zzb[i11];
    }

    public final zzavh[] zzb() {
        return (zzavh[]) this.zzb.clone();
    }
}
