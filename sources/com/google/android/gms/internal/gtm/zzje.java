package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zzje extends zzhb {
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        zzog zzog;
        boolean z11 = true;
        Preconditions.checkArgument(true);
        if (zzoaArr.length > 1) {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        if (zzoaArr.length <= 0) {
            zzog = zzog.zzaum;
        } else {
            zzog = zzoaArr[0];
        }
        return new zzog((zzoa<?>) zzog);
    }
}
