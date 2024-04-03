package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

public final class zzhc extends zzhb {
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
        ArrayList arrayList = new ArrayList();
        for (zzoa add : (List) zzoaArr[0].value()) {
            arrayList.add(add);
        }
        for (int i11 = 1; i11 < zzoaArr.length; i11++) {
            zzoh zzoh = zzoaArr[i11];
            if (zzoh instanceof zzoh) {
                for (zzoa add2 : (List) zzoh.value()) {
                    arrayList.add(add2);
                }
            } else {
                arrayList.add(zzoh);
            }
        }
        return new zzoh(arrayList);
    }
}
