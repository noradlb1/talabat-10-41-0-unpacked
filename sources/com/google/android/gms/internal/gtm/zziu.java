package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.HashMap;

public final class zziu extends zzhb {
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        Preconditions.checkArgument(true);
        HashMap hashMap = new HashMap();
        int i11 = 0;
        while (i11 < zzoaArr.length - 1) {
            String zzd = zzha.zzd(zzoaArr[i11]);
            zzog zzog = zzoaArr[i11 + 1];
            if (!(zzog instanceof zzog) || zzog == zzog.zzaul || zzog == zzog.zzaum) {
                hashMap.put(zzd, zzog);
                i11 += 2;
            } else {
                throw new IllegalStateException("Illegal InternalType found in CreateObject.");
            }
        }
        return new zzok(hashMap);
    }
}
