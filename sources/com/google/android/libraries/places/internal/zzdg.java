package com.google.android.libraries.places.internal;

import java.util.LinkedHashMap;
import java.util.Map;

final class zzdg extends LinkedHashMap<Long, Integer> {
    public zzdg(int i11, float f11, boolean z11) {
        super(16, 0.75f, true);
    }

    public final boolean removeEldestEntry(Map.Entry<Long, Integer> entry) {
        return size() > 10;
    }
}
