package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

public final class zzgpo {
    public static <T> HashSet<T> zza(int i11) {
        return new HashSet<>(zzd(i11));
    }

    public static <K, V> LinkedHashMap<K, V> zzb(int i11) {
        return new LinkedHashMap<>(zzd(i11));
    }

    public static <T> List<T> zzc(int i11) {
        if (i11 == 0) {
            return Collections.emptyList();
        }
        return new ArrayList(i11);
    }

    private static int zzd(int i11) {
        if (i11 < 3) {
            return i11 + 1;
        }
        if (i11 < 1073741824) {
            return (int) ((((float) i11) / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }
}
