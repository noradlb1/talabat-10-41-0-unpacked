package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

public final class zzhw extends zzhb {
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11;
        int i11;
        Preconditions.checkNotNull(zzoaArr);
        if (zzoaArr.length >= 3) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzoh);
        zzoh zzoh = zzoaArr[0];
        int zzc = (int) zzha.zzc(zzoaArr[1]);
        if (zzc < 0) {
            i11 = Math.max(((List) zzoh.value()).size() + zzc, 0);
        } else {
            i11 = Math.min(zzc, ((List) zzoh.value()).size());
        }
        int min = Math.min(Math.max((int) zzha.zzc(zzoaArr[2]), 0), ((List) zzoh.value()).size() - i11) + i11;
        ArrayList arrayList = new ArrayList(((List) zzoh.value()).subList(i11, min));
        ((List) zzoh.value()).subList(i11, min).clear();
        ArrayList arrayList2 = new ArrayList();
        for (int i12 = 3; i12 < zzoaArr.length; i12++) {
            arrayList2.add(zzoaArr[i12]);
        }
        ((List) zzoh.value()).addAll(i11, arrayList2);
        return new zzoh(arrayList);
    }
}
