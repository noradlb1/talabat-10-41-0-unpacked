package com.apptimize;

import java.util.LinkedHashMap;
import java.util.Map;

public class ex<K, V> extends LinkedHashMap<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private final int f42372a;

    public ex(int i11) {
        super(i11);
        this.f42372a = i11;
    }

    public boolean removeEldestEntry(Map.Entry entry) {
        return size() > this.f42372a;
    }
}
