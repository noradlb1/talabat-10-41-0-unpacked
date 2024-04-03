package com.google.android.libraries.places.internal;

public final class zzgn {
    public static Object[] zza(Object[] objArr, int i11) {
        int i12 = 0;
        while (i12 < i11) {
            if (objArr[i12] != null) {
                i12++;
            } else {
                StringBuilder sb2 = new StringBuilder(20);
                sb2.append("at index ");
                sb2.append(i12);
                throw new NullPointerException(sb2.toString());
            }
        }
        return objArr;
    }
}
