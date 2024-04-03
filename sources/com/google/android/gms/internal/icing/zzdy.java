package com.google.android.gms.internal.icing;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class zzdy<K, V> extends LinkedHashMap<K, V> {
    private static final zzdy zzb;
    private boolean zza = true;

    static {
        zzdy zzdy = new zzdy();
        zzb = zzdy;
        zzdy.zza = false;
    }

    private zzdy() {
    }

    private static int zze(Object obj) {
        if (obj instanceof byte[]) {
            return zzdh.zzg((byte[]) obj);
        }
        if (!(obj instanceof zzde)) {
            return obj.hashCode();
        }
        throw new UnsupportedOperationException();
    }

    private final void zzf() {
        if (!this.zza) {
            throw new UnsupportedOperationException();
        }
    }

    public final void clear() {
        zzf();
        super.clear();
    }

    public final Set<Map.Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    public final boolean equals(Object obj) {
        boolean z11;
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (this == map) {
            return true;
        }
        if (size() != map.size()) {
            return false;
        }
        for (Map.Entry entry : entrySet()) {
            if (!map.containsKey(entry.getKey())) {
                return false;
            }
            Object value = entry.getValue();
            Object obj2 = map.get(entry.getKey());
            if (!(value instanceof byte[]) || !(obj2 instanceof byte[])) {
                z11 = value.equals(obj2);
                continue;
            } else {
                z11 = Arrays.equals((byte[]) value, (byte[]) obj2);
                continue;
            }
            if (!z11) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i11 = 0;
        for (Map.Entry entry : entrySet()) {
            i11 += zze(entry.getValue()) ^ zze(entry.getKey());
        }
        return i11;
    }

    public final V put(K k11, V v11) {
        zzf();
        zzdh.zza(k11);
        zzdh.zza(v11);
        return super.put(k11, v11);
    }

    public final void putAll(Map<? extends K, ? extends V> map) {
        zzf();
        for (Object next : map.keySet()) {
            zzdh.zza(next);
            zzdh.zza(map.get(next));
        }
        super.putAll(map);
    }

    public final V remove(Object obj) {
        zzf();
        return super.remove(obj);
    }

    public final void zza(zzdy<K, V> zzdy) {
        zzf();
        if (!zzdy.isEmpty()) {
            putAll(zzdy);
        }
    }

    public final zzdy<K, V> zzb() {
        return isEmpty() ? new zzdy<>() : new zzdy<>(this);
    }

    public final void zzc() {
        this.zza = false;
    }

    public final boolean zzd() {
        return this.zza;
    }

    private zzdy(Map<K, V> map) {
        super(map);
    }
}
