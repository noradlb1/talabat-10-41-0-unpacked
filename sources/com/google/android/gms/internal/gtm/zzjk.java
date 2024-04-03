package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zzjk extends zzhb {
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11;
        String str;
        Preconditions.checkArgument(true);
        if (zzoaArr.length == 2) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        zzog zzog = zzoaArr[0];
        zzog zzog2 = zzoaArr[1];
        if ((!(zzog instanceof zzog) || zzog == zzog.zzaum || zzog == zzog.zzaul) && (!(zzog2 instanceof zzog) || zzog2 == zzog.zzaum || zzog2 == zzog.zzaul)) {
            if ((zzog instanceof zzok) || (zzog instanceof zzoh) || (zzog instanceof zzof)) {
                zzog = new zzom(zzha.zzd(zzog));
            }
            if ((zzog2 instanceof zzok) || (zzog2 instanceof zzoh) || (zzog2 instanceof zzof)) {
                zzog2 = new zzom(zzha.zzd(zzog2));
            }
            if (!(zzog instanceof zzom) && !(zzog2 instanceof zzom)) {
                return new zzoe(Double.valueOf(zzha.zza(zzog, zzog2)));
            }
            String valueOf = String.valueOf(zzha.zzd(zzog));
            String valueOf2 = String.valueOf(zzha.zzd(zzog2));
            if (valueOf2.length() != 0) {
                str = valueOf.concat(valueOf2);
            } else {
                str = new String(valueOf);
            }
            return new zzom(str);
        }
        throw new IllegalArgumentException("Illegal InternalType passed to Add.");
    }
}
