package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

public final class zzhg extends zzhb {
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11;
        zzog zzog;
        zzog zzog2;
        Preconditions.checkNotNull(zzoaArr);
        int i11 = 0;
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
        if (zzoaArr.length < 3) {
            zzog2 = zzog.zzaum;
        } else {
            zzog2 = zzoaArr[2];
        }
        List list = (List) zzoh.value();
        int size = list.size();
        if (zzog2 != zzog.zzaum) {
            int zzc = (int) zzha.zzc(zzog2);
            if (zzc < 0) {
                i11 = Math.max(size - Math.abs(zzc), 0);
            } else {
                i11 = zzc;
            }
        }
        while (true) {
            if (i11 < size) {
                if (zzoh.zzad(i11) && zzha.zzd(zzog, (zzoa) list.get(i11))) {
                    break;
                }
                i11++;
            } else {
                i11 = -1;
                break;
            }
        }
        return new zzoe(Double.valueOf((double) i11));
    }
}
