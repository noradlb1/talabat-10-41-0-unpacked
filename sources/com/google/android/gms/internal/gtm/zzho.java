package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.List;

public final class zzho extends zzhb {
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        Preconditions.checkNotNull(zzoaArr);
        boolean z11 = true;
        if (zzoaArr.length != 1) {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzoh);
        Collections.reverse((List) zzoaArr[0].value());
        return zzoaArr[0];
    }
}
