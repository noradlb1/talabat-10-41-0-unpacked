package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zziv extends zzhb {
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11;
        Preconditions.checkArgument(true);
        if (zzoaArr.length > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        return zzoaArr[zzoaArr.length - 1];
    }
}
