package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

public final class zzhj extends zzhb {
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11;
        zzoa<?> zzoa;
        Preconditions.checkNotNull(zzoaArr);
        if (zzoaArr.length == 2) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzoh);
        Preconditions.checkArgument(zzoaArr[1] instanceof zzof);
        zzoh zzoh = zzoaArr[0];
        zzof zzof = zzoaArr[1];
        List list = (List) zzoh.value();
        int size = list.size();
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        while (i11 < size && i11 < ((List) zzoh.value()).size()) {
            if (zzoh.zzad(i11)) {
                zzoa = ((zzgz) zzof.value()).zzb(zzfl, (zzoa) list.get(i11), new zzoe(Double.valueOf((double) i11)), zzoh);
                Preconditions.checkState(!zzoo.zzm(zzoa));
            } else {
                zzoa = null;
            }
            arrayList.add(zzoa);
            i11++;
        }
        return new zzoh(arrayList);
    }
}
