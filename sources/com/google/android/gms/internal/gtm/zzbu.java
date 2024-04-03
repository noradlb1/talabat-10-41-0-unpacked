package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.util.VisibleForTesting;
import com.huawei.hms.flutter.map.constants.Param;

@VisibleForTesting
public final class zzbu extends zzan {
    @VisibleForTesting
    public zzbu(zzap zzap) {
        super(zzap);
    }

    public final void zzaw() {
    }

    public final zzv zzfa() {
        zzdb();
        return zzcq().zzau();
    }

    public final String zzfb() {
        zzdb();
        zzv zzfa = zzfa();
        int i11 = zzfa.zzul;
        int i12 = zzfa.zzum;
        StringBuilder sb2 = new StringBuilder(23);
        sb2.append(i11);
        sb2.append(Param.X);
        sb2.append(i12);
        return sb2.toString();
    }
}
