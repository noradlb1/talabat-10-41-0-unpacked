package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

public final class zzjd implements zzgz {
    public final zzoa<?> zzb(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11;
        if (zzoaArr != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        ArrayList arrayList = new ArrayList(zzoaArr.length);
        for (zzoa<?> add : zzoaArr) {
            arrayList.add(add);
        }
        return new zzoh(arrayList);
    }
}
