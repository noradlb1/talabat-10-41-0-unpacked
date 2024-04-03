package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Arrays;

public final class zzci {
    private int zza;
    private final zzsb[] zzb;

    public zzci(zzsb[] zzsbArr, byte... bArr) {
        this.zzb = zzsbArr;
        int length = zzsbArr.length;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzci.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.zzb, ((zzci) obj).zzb);
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
}
