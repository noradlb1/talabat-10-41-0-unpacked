package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

public final class zzhl extends zzhb {
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11;
        Preconditions.checkNotNull(zzoaArr);
        if (zzoaArr.length > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzoh);
        zzoh zzoh = zzoaArr[0];
        int size = ((List) zzoh.value()).size();
        zzoh.setSize((zzoaArr.length + size) - 1);
        for (int i11 = 1; i11 < zzoaArr.length; i11++) {
            zzoh.zza(size, zzoaArr[i11]);
            size++;
        }
        return new zzoe(Double.valueOf((double) size));
    }
}
