package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zzix implements zzgz {
    public final zzoa<?> zzb(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11;
        boolean z12 = true;
        if (zzoaArr != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        if (zzoaArr.length != 1) {
            z12 = false;
        }
        Preconditions.checkArgument(z12);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzom);
        zzoa<?> zzca = zzfl.zzca((String) zzoaArr[0].value());
        if (zzca instanceof zzol) {
            throw new IllegalStateException("Illegal Statement type encountered in Get.");
        } else if (!(zzca instanceof zzog) || zzca == zzog.zzaum || zzca == zzog.zzaul) {
            return zzca;
        } else {
            throw new IllegalStateException("Illegal InternalType encountered in Get.");
        }
    }
}
