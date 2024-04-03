package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zziy implements zzgz {
    private static zzff zzamz;

    public zziy(zzff zzff) {
        zzamz = zzff;
    }

    public final zzoa<?> zzb(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11;
        boolean z12 = true;
        if (zzoaArr != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        if (zzoaArr.length != 1) {
            z12 = false;
        }
        Preconditions.checkArgument(z12);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzom);
        return zzamz.zzbx((String) zzoaArr[0].value());
    }
}
