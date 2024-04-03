package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

public final class zzjj implements zzgz {
    public final zzoa<?> zzb(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11;
        boolean z12;
        if (zzoaArr != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        if (zzoaArr.length == 4) {
            z12 = true;
        } else {
            z12 = false;
        }
        Preconditions.checkArgument(z12);
        zzoa zza = zzoo.zza(zzfl, (zzoa) zzoaArr[3]);
        Preconditions.checkArgument(zza instanceof zzoh);
        List list = (List) ((zzoh) zza).value();
        zzod zzod = zzoaArr[2];
        Preconditions.checkArgument(zzod instanceof zzod);
        if (((Boolean) zzod.value()).booleanValue()) {
            zzog zza2 = zzoo.zza(zzfl, (List<zzoa<?>>) list);
            if (zza2 == zzog.zzauj) {
                return zzog.zzaum;
            }
            if (zza2.zzmh()) {
                return zza2;
            }
        }
        while (zzha.zza(zzoo.zza(zzfl, (zzoa) zzoaArr[0]))) {
            zzog zza3 = zzoo.zza(zzfl, (List<zzoa<?>>) list);
            if (zza3 == zzog.zzauj) {
                return zzog.zzaum;
            }
            if (zza3.zzmh()) {
                return zza3;
            }
            zzoo.zza(zzfl, (zzoa) zzoaArr[1]);
        }
        return zzog.zzaum;
    }
}
