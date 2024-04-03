package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zzju extends zzhb {
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11;
        zzoa<?> zzoa;
        Preconditions.checkArgument(true);
        if (zzoaArr.length <= 0 || zzoaArr.length > 3) {
            z11 = false;
        } else {
            z11 = true;
        }
        Preconditions.checkArgument(z11);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzom);
        String str = (String) zzoaArr[0].value();
        if (zzoaArr.length == 1) {
            return new zzom(str);
        }
        String zzd = zzha.zzd(zzoaArr[1]);
        if (zzoaArr.length < 3) {
            zzoa = zzog.zzaum;
        } else {
            zzoa = zzoaArr[2];
        }
        int indexOf = str.indexOf(zzd);
        if (indexOf == -1) {
            return new zzom(str);
        }
        if (zzoa instanceof zzof) {
            zzoa = ((zzgz) ((zzof) zzoa).value()).zzb(zzfl, new zzom(zzd), new zzoe(Double.valueOf((double) indexOf)), new zzom(str));
        }
        String zzd2 = zzha.zzd(zzoa);
        String substring = str.substring(0, indexOf);
        String substring2 = str.substring(indexOf + zzd.length());
        StringBuilder sb2 = new StringBuilder(String.valueOf(substring).length() + String.valueOf(zzd2).length() + String.valueOf(substring2).length());
        sb2.append(substring);
        sb2.append(zzd2);
        sb2.append(substring2);
        return new zzom(sb2.toString());
    }
}
