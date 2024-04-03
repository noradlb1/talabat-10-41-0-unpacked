package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zzjp extends zzhb {
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11;
        Preconditions.checkArgument(true);
        int i11 = 0;
        if (zzoaArr.length == 1 || zzoaArr.length == 2) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzom);
        String str = (String) zzoaArr[0].value();
        if (zzoaArr.length == 2) {
            i11 = (int) zzha.zzc(zzoaArr[1]);
        }
        if (i11 < 0 || i11 >= str.length()) {
            return new zzom("");
        }
        return new zzom(String.valueOf(str.charAt(i11)));
    }
}
