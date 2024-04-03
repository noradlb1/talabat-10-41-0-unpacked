package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zzjo extends zzhb {
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11;
        Preconditions.checkArgument(true);
        if (zzoaArr.length == 2) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        return new zzoe(Double.valueOf(zzha.zza(zzoaArr[0], new zzoe(Double.valueOf(zzha.zzb(zzoaArr[1]) * -1.0d)))));
    }
}
