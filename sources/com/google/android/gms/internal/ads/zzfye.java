package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

public final class zzfye {
    public static zzfyd zza(String str) throws GeneralSecurityException {
        String str2;
        if (zzfza.zzj().containsKey(str)) {
            return zzfza.zzj().get(str);
        }
        if (str.length() != 0) {
            str2 = "cannot find key template: ".concat(str);
        } else {
            str2 = new String("cannot find key template: ");
        }
        throw new GeneralSecurityException(str2);
    }
}
