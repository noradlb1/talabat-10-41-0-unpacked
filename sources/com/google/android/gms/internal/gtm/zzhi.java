package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

public final class zzhi extends zzhb {
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11;
        zzog zzog;
        Preconditions.checkNotNull(zzoaArr);
        if (zzoaArr.length <= 0 || zzoaArr.length > 3) {
            z11 = false;
        } else {
            z11 = true;
        }
        Preconditions.checkArgument(z11);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzoh);
        zzoh zzoh = zzoaArr[0];
        if (zzoaArr.length < 2) {
            zzog = zzog.zzaum;
        } else {
            zzog = zzoaArr[1];
        }
        List list = (List) zzoh.value();
        int size = list.size();
        int i11 = size - 1;
        if (zzoaArr.length == 3) {
            int zzc = (int) zzha.zzc(zzoaArr[2]);
            if (zzc < 0) {
                i11 = size - Math.abs(zzc);
            } else {
                i11 = Math.min(zzc, i11);
            }
        }
        while (true) {
            if (i11 >= 0) {
                if (zzoh.zzad(i11) && zzha.zzd(zzog, (zzoa) list.get(i11))) {
                    break;
                }
                i11--;
            } else {
                i11 = -1;
                break;
            }
        }
        return new zzoe(Double.valueOf((double) i11));
    }
}
