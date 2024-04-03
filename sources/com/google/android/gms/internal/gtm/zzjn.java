package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zzjn extends zzhb {
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11;
        boolean z12;
        double d11;
        boolean z13 = true;
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
        if ((Double.isInfinite(zzb) && zzb2 == 0.0d) || (zzb == 0.0d && Double.isInfinite(zzb2))) {
            return new zzoe(Double.valueOf(Double.NaN));
        }
        if (!Double.isInfinite(zzb) && !Double.isInfinite(zzb2)) {
            return new zzoe(Double.valueOf(zzb * zzb2));
        }
        if (((double) Double.compare(zzb, 0.0d)) < 0.0d) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (((double) Double.compare(zzb2, 0.0d)) >= 0.0d) {
            z13 = false;
        }
        if (z13 ^ z12) {
            d11 = Double.NEGATIVE_INFINITY;
        } else {
            d11 = Double.POSITIVE_INFINITY;
        }
        return new zzoe(Double.valueOf(d11));
    }
}
