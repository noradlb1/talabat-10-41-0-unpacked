package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zzlr extends zzhb {
    private static final zzoe zzarv = new zzoe(Double.valueOf(0.0d));
    private static final zzoe zzarw = new zzoe(Double.valueOf(2.147483647E9d));

    private static boolean zzg(zzoa<?> zzoa) {
        return (zzoa instanceof zzoe) && !Double.isNaN(((Double) ((zzoe) zzoa).value()).doubleValue());
    }

    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        zzoe zzoe;
        zzoe zzoe2;
        double d11;
        double d12;
        Preconditions.checkArgument(true);
        if (zzoaArr.length > 0) {
            zzoe = zzoaArr[0];
        } else {
            zzoe = zzarv;
        }
        if (zzoaArr.length > 1) {
            zzoe2 = zzoaArr[1];
        } else {
            zzoe2 = zzarw;
        }
        if (!zzg(zzoe) || !zzg(zzoe2) || !zzha.zzb(zzoe, zzoe2)) {
            d12 = 0.0d;
            d11 = 2.147483647E9d;
        } else {
            d12 = ((Double) zzoe.value()).doubleValue();
            d11 = ((Double) zzoe2.value()).doubleValue();
        }
        return new zzoe(Double.valueOf((double) Math.round((Math.random() * (d11 - d12)) + d12)));
    }
}
