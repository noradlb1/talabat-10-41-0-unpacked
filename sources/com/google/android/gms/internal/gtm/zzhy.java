package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zzhy implements zzgz {
    public final zzoa<?> zzb(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11;
        boolean z12;
        if (zzoaArr != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        if (zzoaArr.length == 2) {
            z12 = true;
        } else {
            z12 = false;
        }
        Preconditions.checkArgument(z12);
        zzoa<?> zza = zzoo.zza(zzfl, (zzoa) zzoaArr[0]);
        if (!zzha.zza(zza)) {
            return zza;
        }
        return zzoo.zza(zzfl, (zzoa) zzoaArr[1]);
    }
}
