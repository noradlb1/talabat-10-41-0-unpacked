package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

public final class zzhn extends zzhb {
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11;
        zzoa<?> zzoa;
        int i11;
        boolean z12;
        int i12;
        zzoa<?> zzoa2;
        boolean z13;
        Preconditions.checkNotNull(zzoaArr);
        if (zzoaArr.length == 2 || zzoaArr.length == 3) {
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
        if (zzoaArr.length == 3) {
            zzoa = zzoaArr[2];
            i11 = size - 1;
        } else {
            if (size > 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            Preconditions.checkState(z12);
            int i13 = size - 1;
            zzoa<?> zzac = zzoh.zzac(i13);
            int i14 = size - 2;
            while (true) {
                if (i13 < 0) {
                    zzoa<?> zzoa3 = zzac;
                    i12 = i14;
                    zzoa2 = zzoa3;
                    break;
                } else if (zzoh.zzad(i13)) {
                    zzoa2 = zzoh.zzac(i13);
                    i12 = i13 - 1;
                    break;
                } else {
                    i13--;
                }
            }
            if (i13 >= 0) {
                z13 = true;
            } else {
                z13 = false;
            }
            Preconditions.checkState(z13);
            zzoa = zzoa2;
            i11 = i12;
        }
        while (i11 >= 0) {
            if (zzoh.zzad(i11)) {
                zzoa = ((zzgz) zzof.value()).zzb(zzfl, zzoa, (zzoa) list.get(i11), new zzoe(Double.valueOf((double) i11)), zzoh);
            }
            i11--;
        }
        return zzoa;
    }
}
