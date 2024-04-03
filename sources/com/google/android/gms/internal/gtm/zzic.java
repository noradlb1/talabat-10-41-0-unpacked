package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zzic extends zzhb {
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11;
        Preconditions.checkArgument(true);
        if (zzoaArr.length == 2) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        return new zzod(Boolean.valueOf(zzha.zzd(zzoaArr[1], zzoaArr[0])));
    }
}
