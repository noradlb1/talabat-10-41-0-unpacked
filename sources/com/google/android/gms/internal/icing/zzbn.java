package com.google.android.gms.internal.icing;

final class zzbn<T> implements zzbm<T> {
    volatile zzbm<T> zza;

    public zzbn(zzbm<T> zzbm) {
        this.zza = zzbm;
    }

    public final String toString() {
        Object obj = this.zza;
        if (obj == null) {
            StringBuilder sb2 = new StringBuilder("null".length() + 25);
            sb2.append("<supplier that returned ");
            sb2.append("null");
            sb2.append(">");
            obj = sb2.toString();
        }
        String valueOf = String.valueOf(obj);
        StringBuilder sb3 = new StringBuilder(valueOf.length() + 19);
        sb3.append("Suppliers.memoize(");
        sb3.append(valueOf);
        sb3.append(")");
        return sb3.toString();
    }
}
