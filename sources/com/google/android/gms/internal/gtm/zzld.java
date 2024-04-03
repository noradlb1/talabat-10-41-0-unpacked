package com.google.android.gms.internal.gtm;

import android.os.Build;
import com.google.android.gms.common.internal.Preconditions;

public final class zzld implements zzgz {
    private final String zzarr = Build.MANUFACTURER;
    private final String zzars = Build.MODEL;

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
        String str = this.zzarr;
        String str2 = this.zzars;
        if (!str2.startsWith(str) && !str.equals("unknown")) {
            StringBuilder sb2 = new StringBuilder(str.length() + 1 + str2.length());
            sb2.append(str);
            sb2.append(" ");
            sb2.append(str2);
            str2 = sb2.toString();
        }
        return new zzom(str2);
    }
}
