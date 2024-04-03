package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zzji implements zzgz {
    public final zzoa<?> zzb(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11;
        boolean z12 = true;
        if (zzoaArr != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        if (zzoaArr.length <= 0) {
            z12 = false;
        }
        Preconditions.checkArgument(z12);
        for (zzom zzom : zzoaArr) {
            Preconditions.checkNotNull(zzom);
            Preconditions.checkArgument(zzom instanceof zzom);
            zzfl.zza((String) zzom.value(), zzog.zzaum);
        }
        return zzog.zzaum;
    }
}
