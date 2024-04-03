package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

public final class zziz extends zzhb {
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11;
        zzoa<?> zzac;
        Preconditions.checkArgument(true);
        boolean z12 = false;
        if (zzoaArr.length == 2) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        zzoh zzoh = zzoaArr[0];
        zzoa<?> zzoa = zzoaArr[1];
        boolean z13 = zzoh instanceof zzom;
        if (z13 || !zzoo.zzl(zzoh)) {
            z12 = true;
        }
        Preconditions.checkArgument(z12);
        Preconditions.checkArgument(!zzoo.zzm(zzoh));
        Preconditions.checkArgument(true ^ zzoo.zzm(zzoa));
        String zzd = zzha.zzd(zzoa);
        if (zzoh instanceof zzoh) {
            zzoh zzoh2 = zzoh;
            if ("length".equals(zzd)) {
                return new zzoe(Double.valueOf((double) ((List) zzoh2.value()).size()));
            }
            double zzb = zzha.zzb(zzoa);
            if (zzb == Math.floor(zzb)) {
                int i11 = (int) zzb;
                if (zzd.equals(Integer.toString(i11)) && (zzac = zzoh2.zzac(i11)) != zzog.zzaum) {
                    return zzac;
                }
            }
        } else if (z13) {
            zzom zzom = (zzom) zzoh;
            if ("length".equals(zzd)) {
                return new zzoe(Double.valueOf((double) ((String) zzom.value()).length()));
            }
            double zzb2 = zzha.zzb(zzoa);
            if (zzb2 == Math.floor(zzb2)) {
                int i12 = (int) zzb2;
                if (zzd.equals(Integer.toString(i12))) {
                    return zzom.zzae(i12);
                }
            }
            return zzog.zzaum;
        }
        return zzoh.zzco(zzd);
    }
}
