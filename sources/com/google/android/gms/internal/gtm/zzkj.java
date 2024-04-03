package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zzkj extends zzhb {
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11 = true;
        Preconditions.checkArgument(true);
        if (zzoaArr.length != 1) {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        return new zzod(Boolean.valueOf(zzoaArr[0] instanceof zzoh));
    }
}
