package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zzjw extends zzhb {
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11;
        double d11;
        double d12;
        double d13;
        zzog zzog;
        Preconditions.checkArgument(true);
        if (zzoaArr.length <= 0 || zzoaArr.length > 3) {
            z11 = false;
        } else {
            z11 = true;
        }
        Preconditions.checkArgument(z11);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzom);
        String str = (String) zzoaArr[0].value();
        if (zzoaArr.length < 2) {
            d11 = 0.0d;
        } else {
            d11 = zzha.zzc(zzoaArr[1]);
        }
        double length = (double) str.length();
        if (zzoaArr.length == 3 && (zzog = zzoaArr[2]) != zzog.zzaum) {
            length = zzha.zzc(zzog);
        }
        if (d11 < 0.0d) {
            d12 = Math.max(((double) str.length()) + d11, 0.0d);
        } else {
            d12 = Math.min(d11, (double) str.length());
        }
        int i11 = (int) d12;
        if (length < 0.0d) {
            d13 = Math.max(((double) str.length()) + length, 0.0d);
        } else {
            d13 = Math.min(length, (double) str.length());
        }
        return new zzom(str.substring(i11, Math.max(0, ((int) d13) - i11) + i11));
    }
}
