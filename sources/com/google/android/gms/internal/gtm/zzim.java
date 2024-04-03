package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zzim implements zzgz {
    public final zzoa<?> zzb(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11;
        boolean z12;
        zzoa<?> zzoa;
        if (zzoaArr != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        if (zzoaArr.length == 3) {
            z12 = true;
        } else {
            z12 = false;
        }
        Preconditions.checkArgument(z12);
        if (zzha.zza(zzoo.zza(zzfl, (zzoa) zzoaArr[0]))) {
            zzoa = zzoo.zza(zzfl, (zzoa) zzoaArr[1]);
        } else {
            zzoa = zzoo.zza(zzfl, (zzoa) zzoaArr[2]);
        }
        if (!(zzoa instanceof zzog) || zzoa == zzog.zzaum || zzoa == zzog.zzaul) {
            return zzoa;
        }
        throw new IllegalArgumentException("Illegal InternalType passed to Ternary.");
    }
}
