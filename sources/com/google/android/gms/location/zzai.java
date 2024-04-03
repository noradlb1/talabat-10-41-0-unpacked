package com.google.android.gms.location;

public final class zzai {
    public static String zza(int i11) {
        if (i11 == 0) {
            return "THROTTLE_BACKGROUND";
        }
        if (i11 == 1) {
            return "THROTTLE_ALWAYS";
        }
        if (i11 == 2) {
            return "THROTTLE_NEVER";
        }
        throw new IllegalArgumentException();
    }
}
