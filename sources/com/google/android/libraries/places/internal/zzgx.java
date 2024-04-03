package com.google.android.libraries.places.internal;

import java.util.Set;

public final class zzgx {
    public static int zza(Set<?> set) {
        int i11;
        int i12 = 0;
        for (Object next : set) {
            if (next != null) {
                i11 = next.hashCode();
            } else {
                i11 = 0;
            }
            i12 += i11;
        }
        return i12;
    }
}
