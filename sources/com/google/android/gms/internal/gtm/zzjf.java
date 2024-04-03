package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zzjf extends zzhb {
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14 = true;
        Preconditions.checkArgument(true);
        if (zzoaArr.length == 3) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        zzok zzok = zzoaArr[0];
        zzoa<?> zzoa = zzoaArr[1];
        zzoa<?> zzoa2 = zzoaArr[2];
        if (zzok != zzog.zzaul) {
            z12 = true;
        } else {
            z12 = false;
        }
        Preconditions.checkArgument(z12);
        if (zzok != zzog.zzaum) {
            z13 = true;
        } else {
            z13 = false;
        }
        Preconditions.checkArgument(z13);
        Preconditions.checkArgument(!zzoo.zzm(zzok));
        Preconditions.checkArgument(!zzoo.zzm(zzoa));
        Preconditions.checkArgument(!zzoo.zzm(zzoa2));
        if (zzoo.zzl(zzok)) {
            return zzoa2;
        }
        String zzd = zzha.zzd(zzoa);
        if (zzok instanceof zzok) {
            zzok zzok2 = zzok;
            if (!zzok2.isImmutable()) {
                zzok2.zzc(zzd, zzoa2);
            }
            return zzoa2;
        }
        if (zzok instanceof zzoh) {
            zzoh zzoh = (zzoh) zzok;
            if ("length".equals(zzd)) {
                double zzb = zzha.zzb(zzoa2);
                if (Double.isInfinite(zzb) || zzb != Math.floor(zzb)) {
                    z14 = false;
                }
                Preconditions.checkArgument(z14);
                zzoh.setSize((int) zzb);
                return zzoa2;
            }
            double zzb2 = zzha.zzb(zzoa);
            if (!Double.isInfinite(zzb2) && zzb2 >= 0.0d) {
                int i11 = (int) zzb2;
                if (zzd.equals(Integer.toString(i11))) {
                    zzoh.zza(i11, zzoa2);
                    return zzoa2;
                }
            }
        }
        zzok.zzc(zzd, zzoa2);
        return zzoa2;
    }
}
