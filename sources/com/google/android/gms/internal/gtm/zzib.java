package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zzib extends zzhb {
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11;
        boolean z12 = true;
        Preconditions.checkArgument(true);
        if (zzoaArr.length == 2) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        zzom zzom = zzoaArr[0];
        zzom zzom2 = zzoaArr[1];
        if ((zzom instanceof zzok) || (zzom instanceof zzoh) || (zzom instanceof zzof)) {
            zzom = new zzom(zzha.zzd(zzom));
        }
        if ((zzom2 instanceof zzok) || (zzom2 instanceof zzoh) || (zzom2 instanceof zzof)) {
            zzom2 = new zzom(zzha.zzd(zzom2));
        }
        if (((!(zzom instanceof zzom) || !(zzom2 instanceof zzom)) && (Double.isNaN(zzha.zzb(zzom)) || Double.isNaN(zzha.zzb(zzom2)))) || zzha.zzb(zzom, zzom2)) {
            z12 = false;
        }
        return new zzod(Boolean.valueOf(z12));
    }
}
