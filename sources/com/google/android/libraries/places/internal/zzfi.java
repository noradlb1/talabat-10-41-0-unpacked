package com.google.android.libraries.places.internal;

import javax.annotation.CheckForNull;

public final class zzfi extends zzfd {
    public static boolean zza(@CheckForNull Object obj, @CheckForNull Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj != null) {
            return obj.equals(obj2);
        }
        return false;
    }
}
