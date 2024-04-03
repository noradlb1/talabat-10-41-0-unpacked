package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Locale;

public final class zzll implements zzgz {
    public final zzoa<?> zzb(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11;
        boolean z12 = true;
        if (zzoaArr != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        if (zzoaArr.length != 0) {
            z12 = false;
        }
        Preconditions.checkArgument(z12);
        Locale locale = Locale.getDefault();
        if (locale == null) {
            return new zzom("");
        }
        String language = locale.getLanguage();
        if (language == null) {
            return new zzom("");
        }
        return new zzom(language.toLowerCase());
    }
}
