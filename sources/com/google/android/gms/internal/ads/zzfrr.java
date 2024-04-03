package com.google.android.gms.internal.ads;

final class zzfrr {
    public static int zza(int i11, String str) {
        if (i11 >= 0) {
            return i11;
        }
        StringBuilder sb2 = new StringBuilder(str.length() + 40);
        sb2.append(str);
        sb2.append(" cannot be negative but was: ");
        sb2.append(i11);
        throw new IllegalArgumentException(sb2.toString());
    }

    public static void zzb(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("null key in entry: null=".concat(String.valueOf(obj2)));
        } else if (obj2 == null) {
            String obj3 = obj.toString();
            StringBuilder sb2 = new StringBuilder(obj3.length() + 26);
            sb2.append("null value in entry: ");
            sb2.append(obj3);
            sb2.append("=null");
            throw new NullPointerException(sb2.toString());
        }
    }
}
