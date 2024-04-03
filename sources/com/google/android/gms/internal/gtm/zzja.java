package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

public final class zzja extends zzhb {
    public static final zzja zzark = new zzja();

    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11;
        Preconditions.checkArgument(true);
        if (zzoaArr.length == 2) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        zzoh zzoh = zzoaArr[0];
        zzoa<?> zzoa = zzoaArr[1];
        Preconditions.checkArgument(!zzoo.zzm(zzoh));
        Preconditions.checkArgument(true ^ zzoo.zzm(zzoa));
        String zzd = zzha.zzd(zzoa);
        if (zzoh instanceof zzoh) {
            if ("length".equals(zzd)) {
                return new zzod(Boolean.TRUE);
            }
            double zzb = zzha.zzb(zzoa);
            if (zzb == Math.floor(zzb)) {
                int i11 = (int) zzb;
                if (zzd.equals(Integer.toString(i11)) && i11 >= 0 && i11 < ((List) zzoh.value()).size()) {
                    return new zzod(Boolean.TRUE);
                }
            }
        } else if (zzoh instanceof zzom) {
            if ("length".equals(zzd)) {
                return new zzod(Boolean.TRUE);
            }
            double zzb2 = zzha.zzb(zzoa);
            if (zzb2 == Math.floor(zzb2)) {
                int i12 = (int) zzb2;
                if (zzd.equals(Integer.toString(i12)) && i12 >= 0 && i12 < ((String) ((zzom) zzoh).value()).length()) {
                    return new zzod(Boolean.TRUE);
                }
            }
            return new zzod(Boolean.FALSE);
        }
        return new zzod(Boolean.valueOf(zzoh.zzcn(zzd)));
    }
}
