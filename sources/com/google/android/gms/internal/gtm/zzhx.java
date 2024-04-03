package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

public final class zzhx extends zzhb {
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
        ArrayList arrayList = new ArrayList();
        for (int i11 = 1; i11 < zzoaArr.length; i11++) {
            arrayList.add(zzoaArr[i11]);
        }
        ((List) zzoh.value()).addAll(0, arrayList);
        return new zzoe(Double.valueOf((double) ((List) zzoh.value()).size()));
    }
}
