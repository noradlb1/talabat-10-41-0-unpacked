package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

public final class zzit extends zzhb {
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11;
        Preconditions.checkArgument(true);
        ArrayList arrayList = new ArrayList();
        for (zzog zzog : zzoaArr) {
            if (!(zzog instanceof zzog) || zzog == zzog.zzaum || zzog == zzog.zzaul) {
                z11 = true;
            } else {
                z11 = false;
            }
            Preconditions.checkArgument(z11);
            arrayList.add(zzog);
        }
        return new zzoh(arrayList);
    }
}
