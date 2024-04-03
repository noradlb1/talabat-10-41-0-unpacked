package com.google.android.gms.internal.measurement;

import javax.annotation.CheckForNull;

public final class zzih extends zzif {
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
