package com.google.android.gms.internal.gtm;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;

public final class zzln extends zzhb {
    private final zzfj zzarn;
    private final Context zzrm;

    public zzln(Context context, zzfj zzfj) {
        this.zzrm = context;
        this.zzarn = zzfj;
    }

    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11;
        Preconditions.checkArgument(true);
        if (zzoaArr.length > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        Object obj = this.zzarn.zzkt().zzib().get(zzha.zzd(zzoaArr[0]));
        Object obj2 = obj;
        if (obj == null) {
            obj2 = obj;
            if (zzoaArr.length > 1) {
                obj2 = zzoaArr[1];
            }
        }
        return zzoo.zzq(obj2);
    }
}
