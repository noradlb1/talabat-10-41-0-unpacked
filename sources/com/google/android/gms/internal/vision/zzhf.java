package com.google.android.gms.internal.vision;

import java.util.Map;

final class zzhf<K> implements Map.Entry<K, Object> {
    private Map.Entry<K, zzhd> zzxw;

    private zzhf(Map.Entry<K, zzhd> entry) {
        this.zzxw = entry;
    }

    public final K getKey() {
        return this.zzxw.getKey();
    }

    public final Object getValue() {
        if (this.zzxw.getValue() == null) {
            return null;
        }
        return zzhd.zzgu();
    }

    public final Object setValue(Object obj) {
        if (obj instanceof zzic) {
            return this.zzxw.getValue().zzi((zzic) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }

    public final zzhd zzgw() {
        return this.zzxw.getValue();
    }
}
