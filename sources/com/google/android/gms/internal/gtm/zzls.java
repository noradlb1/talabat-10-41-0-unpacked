package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public final class zzls extends zzhb {
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11;
        int i11;
        String str;
        zzog zzog;
        zzog zzog2;
        int i12 = 1;
        Preconditions.checkArgument(true);
        if (zzoaArr.length >= 2) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        zzog zzog3 = zzoaArr[0];
        zzog zzog4 = zzog.zzaum;
        if (zzog3 == zzog4 || zzoaArr[1] == zzog4) {
            return zzog4;
        }
        String zzd = zzha.zzd(zzog3);
        String zzd2 = zzha.zzd(zzoaArr[1]);
        if (zzoaArr.length <= 2 || (zzog2 = zzoaArr[2]) == zzog4 || !zzha.zza(zzog2)) {
            i11 = 64;
        } else {
            i11 = 66;
        }
        if (zzoaArr.length > 3 && (zzog = zzoaArr[3]) != zzog4) {
            if (!(zzog instanceof zzoe)) {
                return zzog4;
            }
            double zzc = zzha.zzc(zzog);
            if (Double.isInfinite(zzc) || zzc < 0.0d) {
                return zzog4;
            }
            i12 = (int) zzc;
        }
        try {
            Matcher matcher = Pattern.compile(zzd2, i11).matcher(zzd);
            if (!matcher.find() || matcher.groupCount() < i12) {
                str = null;
            } else {
                str = matcher.group(i12);
            }
            if (str == null) {
                return zzog4;
            }
            return new zzom(str);
        } catch (PatternSyntaxException unused) {
            return zzog.zzaum;
        }
    }
}
