package com.google.android.libraries.places.internal;

public class zzhi<T> {
    private final String zza;
    private final Class<? extends T> zzb;
    private final boolean zzc;

    public zzhi(String str, Class<? extends T> cls, boolean z11) {
        zzje.zzb(str);
        this.zza = str;
        this.zzb = cls;
        this.zzc = z11;
        System.identityHashCode(this);
        for (int i11 = 0; i11 < 5; i11++) {
        }
    }

    public static <T> zzhi<T> zza(String str, Class<? extends T> cls) {
        return new zzhi<>(str, cls, false);
    }

    public final String toString() {
        String name2 = getClass().getName();
        String str = this.zza;
        String name3 = this.zzb.getName();
        int length = name2.length();
        StringBuilder sb2 = new StringBuilder(length + 3 + str.length() + name3.length());
        sb2.append(name2);
        sb2.append("/");
        sb2.append(str);
        sb2.append("[");
        sb2.append(name3);
        sb2.append("]");
        return sb2.toString();
    }

    public final boolean zzb() {
        return this.zzc;
    }
}
