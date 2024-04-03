package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.HashMap;
import java.util.Map;

public final class zzkk extends zzhb {
    private final zzkl zzarl;

    public zzkk(zzkl zzkl) {
        this.zzarl = zzkl;
    }

    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11;
        zzog zzog;
        Preconditions.checkNotNull(zzoaArr);
        if (zzoaArr.length > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzom);
        String str = (String) zzoaArr[0].value();
        HashMap hashMap = new HashMap();
        if (zzoaArr.length >= 2 && (zzog = zzoaArr[1]) != zzog.zzaum) {
            Preconditions.checkArgument(zzog instanceof zzok);
            for (Map.Entry entry : ((Map) zzoaArr[1].value()).entrySet()) {
                Preconditions.checkState(!(entry.getValue() instanceof zzol));
                Preconditions.checkState(!zzoo.zzm((zzoa) entry.getValue()));
                hashMap.put((String) entry.getKey(), ((zzoa) entry.getValue()).value());
            }
        }
        return zzoo.zzq(this.zzarl.zza(str, hashMap));
    }
}
