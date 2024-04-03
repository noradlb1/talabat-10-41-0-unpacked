package com.google.android.libraries.places.internal;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class zzact<K, V> extends LinkedHashMap<K, V> {
    private static final zzact zza;
    private boolean zzb = true;

    static {
        zzact zzact = new zzact();
        zza = zzact;
        zzact.zzb = false;
    }

    private zzact() {
    }

    private static int zze(Object obj) {
        if (obj instanceof byte[]) {
            return zzaca.zzb((byte[]) obj);
        }
        if (!(obj instanceof zzabu)) {
            return obj.hashCode();
        }
        throw new UnsupportedOperationException();
    }

    private final void zzf() {
        if (!this.zzb) {
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
        zzaca.zze(k11);
        zzaca.zze(v11);
        return super.put(k11, v11);
    }

    public final void putAll(Map<? extends K, ? extends V> map) {
        zzf();
        for (Object next : map.keySet()) {
            zzaca.zze(next);
            zzaca.zze(map.get(next));
        }
        super.putAll(map);
    }

    public final V remove(Object obj) {
        zzf();
        return super.remove(obj);
    }

    public final zzact<K, V> zza() {
        return isEmpty() ? new zzact<>() : new zzact<>(this);
    }

    public final void zzb() {
        this.zzb = false;
    }

    public final void zzc(zzact<K, V> zzact) {
        zzf();
        if (!zzact.isEmpty()) {
            putAll(zzact);
        }
    }

    public final boolean zzd() {
        return this.zzb;
    }

    private zzact(Map<K, V> map) {
        super(map);
    }
}
