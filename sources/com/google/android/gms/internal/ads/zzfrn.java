package com.google.android.gms.internal.ads;

import java.util.Map;
import javax.annotation.CheckForNull;

abstract class zzfrn<K, V> implements Map.Entry<K, V> {
    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            if (!zzfqc.zza(getKey(), entry.getKey()) || !zzfqc.zza(getValue(), entry.getValue())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public abstract K getKey();

    public abstract V getValue();

    public final int hashCode() {
        int i11;
        Object key = getKey();
        Object value = getValue();
        int i12 = 0;
        if (key == null) {
            i11 = 0;
        } else {
            i11 = key.hashCode();
        }
        if (value != null) {
            i12 = value.hashCode();
        }
        return i11 ^ i12;
    }

    public V setValue(V v11) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        String valueOf = String.valueOf(getKey());
        String valueOf2 = String.valueOf(getValue());
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 1 + valueOf2.length());
        sb2.append(valueOf);
        sb2.append("=");
        sb2.append(valueOf2);
        return sb2.toString();
    }
}
