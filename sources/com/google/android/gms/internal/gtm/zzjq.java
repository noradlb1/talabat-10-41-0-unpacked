package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zzjq extends zzhb {
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11;
        Preconditions.checkArgument(true);
        if (zzoaArr.length > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzom);
        StringBuilder sb2 = new StringBuilder((String) zzoaArr[0].value());
        for (int i11 = 1; i11 < zzoaArr.length; i11++) {
            sb2.append(zzha.zzd(zzoaArr[i11]));
        }
        return new zzom(sb2.toString());
    }
}
