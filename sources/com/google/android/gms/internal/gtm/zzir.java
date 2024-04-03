package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

public final class zzir extends zzhb {
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11 = true;
        Preconditions.checkArgument(true);
        if (zzoaArr.length != 1) {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzoh);
        for (zzoa zza : (List) zzoaArr[0].value()) {
            zzoa<?> zza2 = zzoo.zza(zzfl, zza);
            if ((zza2 instanceof zzog) && (zza2 == zzog.zzauj || zza2 == zzog.zzauk || ((zzog) zza2).zzmh())) {
                return zza2;
            }
        }
        return zzog.zzaum;
    }
}
