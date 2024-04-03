package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahz  reason: invalid package */
public final class zzahz extends LinkedHashMap {
    private static final zzahz zza;
    private boolean zzb = true;

    static {
        zzahz zzahz = new zzahz();
        zza = zzahz;
        zzahz.zzb = false;
    }

    private zzahz() {
    }

    public static zzahz zza() {
        return zza;
    }

    private static int zzf(Object obj) {
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            byte[] bArr2 = zzahg.zzd;
            int length = bArr.length;
            int zzb2 = zzahg.zzb(length, bArr, 0, length);
            if (zzb2 == 0) {
                return 1;
            }
            return zzb2;
        } else if (!(obj instanceof zzahc)) {
            return obj.hashCode();
        } else {
            throw new UnsupportedOperationException();
        }
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

    public final Set entrySet() {
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

    public final Object put(Object obj, Object obj2) {
        zzg();
        byte[] bArr = zzahg.zzd;
        obj.getClass();
        obj2.getClass();
        return super.put(obj, obj2);
    }

    public final void putAll(Map map) {
        zzg();
        for (Object next : map.keySet()) {
            byte[] bArr = zzahg.zzd;
            next.getClass();
            map.get(next).getClass();
        }
        super.putAll(map);
    }

    public final Object remove(Object obj) {
        zzg();
        return super.remove(obj);
    }

    public final zzahz zzb() {
        return isEmpty() ? new zzahz() : new zzahz(this);
    }

    public final void zzc() {
        this.zzb = false;
    }

    public final void zzd(zzahz zzahz) {
        zzg();
        if (!zzahz.isEmpty()) {
            putAll(zzahz);
        }
    }

    public final boolean zze() {
        return this.zzb;
    }

    private zzahz(Map map) {
        super(map);
    }
}
