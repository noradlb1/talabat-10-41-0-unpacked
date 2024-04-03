package com.google.android.gms.internal.gtm;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

public final class zzkp implements zzgz {
    private final zzdl zzarm;

    public zzkp(Context context) {
        this(zzdl.zzo(context));
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
        String zzgq = this.zzarm.zzgq();
        if (zzgq == null) {
            return zzog.zzaum;
        }
        return new zzom(zzgq);
    }

    @VisibleForTesting
    private zzkp(zzdl zzdl) {
        this.zzarm = zzdl;
    }
}
