package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.GoogleApiAvailabilityLight;

public final class zzao {
    public static final String VERSION;
    public static final String zzwe;

    static {
        String str;
        String replaceAll = String.valueOf(GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE / 1000).replaceAll("(\\d+)(\\d)(\\d\\d)", "$1.$2.$3");
        VERSION = replaceAll;
        String valueOf = String.valueOf(replaceAll);
        if (valueOf.length() != 0) {
            str = "ma".concat(valueOf);
        } else {
            str = new String("ma");
        }
        zzwe = str;
    }
}
