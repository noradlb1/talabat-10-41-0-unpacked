package com.google.android.gms.internal.icing;

import java.util.Map;

final class zzew implements Map.Entry, Comparable<zzew> {
    final /* synthetic */ zzez zza;
    private final Comparable zzb;
    private Object zzc;

    public zzew(zzez zzez, Comparable comparable, Object obj) {
        this.zza = zzez;
        this.zzb = comparable;
        this.zzc = obj;
    }

    private static final boolean zzb(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.zzb.compareTo(((zzew) obj).zzb);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (!zzb(this.zzb, entry.getKey()) || !zzb(this.zzc, entry.getValue())) {
            return false;
        }
        return true;
    }

    public final /* bridge */ /* synthetic */ Object getKey() {
        return this.zzb;
    }

    public final Object getValue() {
        return this.zzc;
    }

    public final int hashCode() {
        int i11;
        Comparable comparable = this.zzb;
        int i12 = 0;
        if (comparable == null) {
            i11 = 0;
        } else {
            i11 = comparable.hashCode();
        }
        Object obj = this.zzc;
        if (obj != null) {
            i12 = obj.hashCode();
        }
        return i11 ^ i12;
    }

    public final Object setValue(Object obj) {
        this.zza.zzm();
        Object obj2 = this.zzc;
        this.zzc = obj;
        return obj2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzb);
        String valueOf2 = String.valueOf(this.zzc);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 1 + valueOf2.length());
        sb2.append(valueOf);
        sb2.append("=");
        sb2.append(valueOf2);
        return sb2.toString();
    }

    public final Comparable zza() {
        return this.zzb;
    }
}
