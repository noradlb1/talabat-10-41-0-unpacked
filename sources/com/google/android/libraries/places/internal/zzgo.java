package com.google.android.libraries.places.internal;

import java.util.Comparator;

public abstract class zzgo<T> implements Comparator<T> {
    public static <T> zzgo<T> zza(Comparator<T> comparator) {
        return new zzfu(comparator);
    }
}
