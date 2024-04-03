package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public final class zzme extends zzhb {
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11;
        int i11;
        Preconditions.checkArgument(true);
        boolean z12 = false;
        if (zzoaArr.length == 2 || zzoaArr.length == 3) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        String zzd = zzha.zzd(zzoaArr[0]);
        String zzd2 = zzha.zzd(zzoaArr[1]);
        if (zzoaArr.length >= 3) {
            z12 = "true".equalsIgnoreCase(zzha.zzd(zzoaArr[2]));
        }
        if (z12) {
            i11 = 66;
        } else {
            i11 = 64;
        }
        try {
            return new zzod(Boolean.valueOf(Pattern.compile(zzd2, i11).matcher(zzd).find()));
        } catch (PatternSyntaxException unused) {
            return new zzod(Boolean.FALSE);
        }
    }
}
