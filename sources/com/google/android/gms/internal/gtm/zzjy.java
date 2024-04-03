package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zzjy extends zzhb {
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11;
        zzog zzog;
        zzog zzog2;
        Preconditions.checkArgument(true);
        if (zzoaArr.length <= 0 || zzoaArr.length > 3) {
            z11 = false;
        } else {
            z11 = true;
        }
        Preconditions.checkArgument(z11);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzom);
        String str = (String) zzoaArr[0].value();
        if (zzoaArr.length < 2) {
            zzog = zzog.zzaum;
        } else {
            zzog = zzoaArr[1];
        }
        int zzc = (int) zzha.zzc(zzog);
        int length = str.length();
        if (zzoaArr.length == 3 && (zzog2 = zzoaArr[2]) != zzog.zzaum) {
            length = (int) zzha.zzc(zzoo.zza(zzfl, (zzoa) zzog2));
        }
        int min = Math.min(Math.max(zzc, 0), str.length());
        int min2 = Math.min(Math.max(length, 0), str.length());
        return new zzom(str.substring(Math.min(min, min2), Math.max(min, min2)));
    }
}
