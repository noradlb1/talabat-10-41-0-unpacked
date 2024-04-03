package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

public final class zzjx extends zzhb {
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11;
        int i11;
        int i12 = 1;
        Preconditions.checkArgument(true);
        if (zzoaArr.length == 1 || zzoaArr.length == 2) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzom);
        ArrayList arrayList = new ArrayList();
        if (zzoaArr.length == 1) {
            arrayList.add(zzoaArr[0]);
        } else {
            String str = (String) zzoaArr[0].value();
            String zzd = zzha.zzd(zzoaArr[1]);
            boolean equals = zzd.equals("");
            if (equals) {
                i11 = 0;
            } else {
                i11 = -1;
            }
            String[] split = str.split(zzd, i11);
            if (!equals || split.length <= 0 || !split[0].equals("")) {
                i12 = 0;
            }
            while (i12 < split.length) {
                arrayList.add(new zzom(split[i12]));
                i12++;
            }
        }
        return new zzoh(arrayList);
    }
}
