package com.google.android.gms.internal.ads;

import java.util.Map;
import javax.annotation.CheckForNull;

public final class zzftr {
    @CheckForNull
    public static <V> V zza(Map<?, V> map, @CheckForNull Object obj) {
        map.getClass();
        try {
            return map.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }
}
