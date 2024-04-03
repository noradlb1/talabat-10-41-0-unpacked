package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zzkx implements zzgz {
    private final zzoa<?> zzaro;

    public zzkx(zzoa<?> zzoa) {
        this.zzaro = (zzoa) Preconditions.checkNotNull(zzoa);
    }

    public final zzoa<?> zzb(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11;
        boolean z12 = true;
        if (zzoaArr != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        if (zzoaArr.length != 0) {
            z12 = false;
        }
        Preconditions.checkArgument(z12);
        return this.zzaro;
    }
}
