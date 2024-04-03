package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class zzjv extends zzhb {
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11;
        String str;
        Preconditions.checkArgument(true);
        if (zzoaArr.length == 1 || zzoaArr.length == 2) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzom);
        String str2 = (String) zzoaArr[0].value();
        if (zzoaArr.length < 2) {
            str = "";
        } else {
            str = zzha.zzd(zzoaArr[1]);
        }
        Matcher matcher = Pattern.compile(str).matcher(str2);
        if (matcher.find()) {
            return new zzoe(Double.valueOf((double) matcher.start()));
        }
        return new zzoe(Double.valueOf(-1.0d));
    }
}
