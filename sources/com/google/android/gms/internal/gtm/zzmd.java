package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public abstract class zzmd extends zzhb {
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11;
        Preconditions.checkArgument(true);
        if (zzoaArr.length == 2) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        try {
            double zzb = zzha.zzb(zzoaArr[0]);
            double zzb2 = zzha.zzb(zzoaArr[1]);
            if (Double.isNaN(zzb) || Double.isNaN(zzb2)) {
                return new zzod(Boolean.FALSE);
            }
            return new zzod(Boolean.valueOf(zza(zzb, zzb2)));
        } catch (IllegalArgumentException unused) {
            return new zzod(Boolean.FALSE);
        }
    }

    public abstract boolean zza(double d11, double d12);
}
