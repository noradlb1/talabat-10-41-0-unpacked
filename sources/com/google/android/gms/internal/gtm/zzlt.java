package com.google.android.gms.internal.gtm;

import android.os.Build;
import com.google.android.gms.common.internal.Preconditions;

public final class zzlt implements zzgz {
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
        int i11 = Build.VERSION.SDK_INT;
        StringBuilder sb2 = new StringBuilder(16);
        sb2.append("5.06-");
        sb2.append(i11);
        return new zzom(sb2.toString());
    }
}
