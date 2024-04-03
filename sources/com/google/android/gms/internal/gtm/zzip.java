package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zzip extends zzhb {
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
        Preconditions.checkArgument(zzoaArr[0] instanceof zzom);
        String str2 = (String) zzoaArr[0].value();
        if (zzfl.has(str2)) {
            zzfl.zzb(str2, zzoaArr[1]);
            return zzoaArr[1];
        }
        String valueOf = String.valueOf(str2);
        if (valueOf.length() != 0) {
            str = "Attempting to assign to undefined variable ".concat(valueOf);
        } else {
            str = new String("Attempting to assign to undefined variable ");
        }
        throw new IllegalStateException(str);
    }
}
