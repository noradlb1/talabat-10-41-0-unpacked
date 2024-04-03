package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class zzglp<K, V> extends LinkedHashMap<K, V> {
    private static final zzglp zza;
    private boolean zzb = true;

    static {
        zzglp zzglp = new zzglp();
        zza = zzglp;
        zzglp.zzb = false;
    }

    private zzglp() {
    }

    public static <K, V> zzglp<K, V> zza() {
        return zza;
    }

    private static int zzf(Object obj) {
        if (obj instanceof byte[]) {
            return zzgkv.zzb((byte[]) obj);
        }
        if (!(obj instanceof zzgkn)) {
            return obj.hashCode();
        }
        throw new UnsupportedOperationException();
    }

    private final void zzg() {
        if (!this.zzb) {
            throw new UnsupportedOperationException();
        }
    }

    public final void clear() {
        zzg();
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
            i11 += zzf(entry.getValue()) ^ zzf(entry.getKey());
        }
        return i11;
    }

    public final V put(K k11, V v11) {
        zzg();
        zzgkv.zze(k11);
        zzgkv.zze(v11);
        return super.put(k11, v11);
    }

    public final void putAll(Map<? extends K, ? extends V> map) {
        zzg();
        for (Object next : map.keySet()) {
            zzgkv.zze(next);
            zzgkv.zze(map.get(next));
        }
        super.putAll(map);
    }

    public final V remove(Object obj) {
        zzg();
        return super.remove(obj);
    }

    public final zzglp<K, V> zzb() {
        return isEmpty() ? new zzglp<>() : new zzglp<>(this);
    }

    public final void zzc() {
        this.zzb = false;
    }

    public final void zzd(zzglp<K, V> zzglp) {
        zzg();
        if (!zzglp.isEmpty()) {
            putAll(zzglp);
        }
    }

    public final boolean zze() {
        return this.zzb;
    }

    private zzglp(Map<K, V> map) {
        super(map);
    }
}
