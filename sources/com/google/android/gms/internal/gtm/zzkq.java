package com.google.android.gms.internal.gtm;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

public final class zzkq implements zzgz {
    private final zzdl zzarm;

    public zzkq(Context context) {
        this(zzdl.zzo(context));
    }

    public final zzoa<?> zzb(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11;
        boolean z12 = false;
        if (zzoaArr != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        if (zzoaArr.length == 0) {
            z12 = true;
        }
        Preconditions.checkArgument(z12);
        return new zzod(Boolean.valueOf(!this.zzarm.isLimitAdTrackingEnabled()));
    }

    @VisibleForTesting
    private zzkq(zzdl zzdl) {
        this.zzarm = zzdl;
    }
}
