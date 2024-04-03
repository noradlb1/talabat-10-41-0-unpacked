package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zzjm extends zzhb {
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11;
        int i11;
        Preconditions.checkArgument(true);
        if (zzoaArr.length == 2) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        double zzb = zzha.zzb(zzoaArr[0]);
        double zzb2 = zzha.zzb(zzoaArr[1]);
        if (Double.isNaN(zzb) || Double.isNaN(zzb2)) {
            return new zzoe(Double.valueOf(Double.NaN));
        }
        if (Double.isInfinite(zzb) || zzb2 == 0.0d) {
            return new zzoe(Double.valueOf(Double.NaN));
        }
        if (!Double.isInfinite(zzb) && Double.isInfinite(zzb2)) {
            return new zzoe(Double.valueOf(zzb));
        }
        if (zzb != 0.0d || i11 == 0 || Double.isInfinite(zzb2)) {
            return new zzoe(Double.valueOf(zzb % zzb2));
        }
        return new zzoe(Double.valueOf(zzb));
    }
}
