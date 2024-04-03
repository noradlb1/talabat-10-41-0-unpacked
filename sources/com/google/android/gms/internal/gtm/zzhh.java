package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

public final class zzhh extends zzhb {
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11;
        zzog zzog;
        String str;
        Preconditions.checkNotNull(zzoaArr);
        if (zzoaArr.length == 1 || zzoaArr.length == 2) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzoh);
        List<zzoa> list = (List) zzoaArr[0].value();
        if (zzoaArr.length < 2) {
            zzog = zzog.zzaum;
        } else {
            zzog = zzoaArr[1];
        }
        if (zzog == zzog.zzaum) {
            str = ",";
        } else {
            str = zzha.zzd(zzog);
        }
        ArrayList arrayList = new ArrayList();
        for (zzoa zzoa : list) {
            if (zzoa == zzog.zzaul || zzoa == zzog.zzaum) {
                arrayList.add("");
            } else {
                arrayList.add(zzha.zzd(zzoa));
            }
        }
        return new zzom(TextUtils.join(str, arrayList));
    }
}
