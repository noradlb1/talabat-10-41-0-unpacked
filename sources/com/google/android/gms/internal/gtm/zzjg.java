package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

public final class zzjg extends zzhb {
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11;
        boolean z12;
        Preconditions.checkArgument(true);
        if (zzoaArr.length == 3) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        Preconditions.checkArgument(zzoaArr[1] instanceof zzoh);
        Preconditions.checkArgument(zzoaArr[2] instanceof zzoh);
        zzoa<?> zzoa = zzoaArr[0];
        List list = (List) zzoaArr[1].value();
        List list2 = (List) zzoaArr[2].value();
        if (list2.size() <= list.size() + 1) {
            z12 = true;
        } else {
            z12 = false;
        }
        Preconditions.checkArgument(z12);
        boolean z13 = false;
        for (int i11 = 0; i11 < list.size(); i11++) {
            if (z13 || zzha.zzd(zzoa, zzoo.zza(zzfl, (zzoa) list.get(i11)))) {
                zzoa<?> zza = zzoo.zza(zzfl, (zzoa) list2.get(i11));
                if (!(zza instanceof zzog)) {
                    z13 = true;
                } else if (zza == zzog.zzauk || ((zzog) zza).zzmh()) {
                    return zza;
                } else {
                    if (zza == zzog.zzauj) {
                        return zzog.zzaum;
                    }
                }
            }
        }
        if (list.size() < list2.size()) {
            zzoa<?> zza2 = zzoo.zza(zzfl, (zzoa) list2.get(list2.size() - 1));
            if ((zza2 instanceof zzog) && (zza2 == zzog.zzauk || ((zzog) zza2).zzmh())) {
                return zza2;
            }
        }
        return zzog.zzaum;
    }
}
