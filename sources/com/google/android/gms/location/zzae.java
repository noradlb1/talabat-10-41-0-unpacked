package com.google.android.gms.location;

import com.google.android.gms.common.internal.Preconditions;

public final class zzae {
    public static int zza(int i11) {
        boolean z11;
        if (!(i11 == 100 || i11 == 102 || i11 == 104)) {
            if (i11 == 105) {
                i11 = 105;
            } else {
                z11 = false;
                Preconditions.checkArgument(z11, "priority %d must be a Priority.PRIORITY_* constant", Integer.valueOf(i11));
                return i11;
            }
        }
        z11 = true;
        Preconditions.checkArgument(z11, "priority %d must be a Priority.PRIORITY_* constant", Integer.valueOf(i11));
        return i11;
    }

    public static String zzb(int i11) {
        if (i11 == 100) {
            return "HIGH_ACCURACY";
        }
        if (i11 == 102) {
            return "BALANCED_POWER_ACCURACY";
        }
        if (i11 == 104) {
            return "LOW_POWER";
        }
        if (i11 == 105) {
            return "PASSIVE";
        }
        throw new IllegalArgumentException();
    }
}
