package com.google.android.gms.internal.ads;

import javax.annotation.CheckForNull;

public final class zzfue {
    public static Object zza(@CheckForNull Object obj, int i11) {
        if (obj != null) {
            return obj;
        }
        StringBuilder sb2 = new StringBuilder(20);
        sb2.append("at index ");
        sb2.append(i11);
        throw new NullPointerException(sb2.toString());
    }

    public static Object[] zzb(Object[] objArr, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            zza(objArr[i12], i12);
        }
        return objArr;
    }
}
