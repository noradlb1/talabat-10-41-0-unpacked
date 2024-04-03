package com.google.android.gms.internal.ads;

import java.util.Iterator;
import javax.annotation.CheckForNull;

public final class zzftg {
    @CheckForNull
    public static <T> T zza(Iterator<T> it) {
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        it.remove();
        return next;
    }

    public static void zzb(Iterator<?> it) {
        it.getClass();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }
}
