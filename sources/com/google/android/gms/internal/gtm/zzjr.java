package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zzjr extends zzhb {
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11;
        double d11;
        Preconditions.checkArgument(true);
        if (zzoaArr.length == 2 || zzoaArr.length == 3) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzom);
        String str = (String) zzoaArr[0].value();
        String zzd = zzha.zzd(zzoaArr[1]);
        if (zzoaArr.length < 3) {
            d11 = 0.0d;
        } else {
            d11 = zzha.zzc(zzoaArr[2]);
        }
        return new zzoe(Double.valueOf((double) str.indexOf(zzd, (int) Math.min(Math.max(d11, 0.0d), (double) str.length()))));
    }
}
