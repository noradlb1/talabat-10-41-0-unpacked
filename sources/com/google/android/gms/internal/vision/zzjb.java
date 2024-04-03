package com.google.android.gms.internal.vision;

import java.util.Map;

final class zzjb implements Comparable, Map.Entry {
    private Object value;
    private final /* synthetic */ zziw zzaab;
    private final Comparable zzaaf;

    public zzjb(zziw zziw, Map.Entry entry) {
        this(zziw, (Comparable) entry.getKey(), entry.getValue());
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return ((Comparable) getKey()).compareTo((Comparable) ((zzjb) obj).getKey());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return equals(this.zzaaf, entry.getKey()) && equals(this.value, entry.getValue());
    }

    public final /* synthetic */ Object getKey() {
        return this.zzaaf;
    }

    public final Object getValue() {
        return this.value;
    }

    public final int hashCode() {
        Comparable comparable = this.zzaaf;
        int i11 = 0;
        int hashCode = comparable == null ? 0 : comparable.hashCode();
        Object obj = this.value;
        if (obj != null) {
            i11 = obj.hashCode();
        }
        return hashCode ^ i11;
    }

    public final Object setValue(Object obj) {
        this.zzaab.zzia();
        Object obj2 = this.value;
        this.value = obj;
        return obj2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzaaf);
        String valueOf2 = String.valueOf(this.value);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 1 + valueOf2.length());
        sb2.append(valueOf);
        sb2.append("=");
        sb2.append(valueOf2);
        return sb2.toString();
    }

    public zzjb(zziw zziw, Comparable comparable, Object obj) {
        this.zzaab = zziw;
        this.zzaaf = comparable;
        this.value = obj;
    }

    private static boolean equals(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }
}
