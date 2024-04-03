package com.google.android.gms.internal.gtm;

import java.nio.charset.Charset;
import java.util.Arrays;

public final class zzuu {
    private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    protected static final Charset UTF_8 = Charset.forName("UTF-8");
    public static final Object zzbhk = new Object();

    public static boolean equals(int[] iArr, int[] iArr2) {
        if (iArr == null || iArr.length == 0) {
            return iArr2 == null || iArr2.length == 0;
        }
        return Arrays.equals(iArr, iArr2);
    }

    public static int hashCode(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            return 0;
        }
        return Arrays.hashCode(iArr);
    }

    public static void zza(zzuq zzuq, zzuq zzuq2) {
        zzus zzus = zzuq.zzbhb;
        if (zzus != null) {
            zzuq2.zzbhb = (zzus) zzus.clone();
        }
    }

    public static int hashCode(Object[] objArr) {
        int length = objArr == null ? 0 : objArr.length;
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            Object obj = objArr[i12];
            if (obj != null) {
                i11 = (i11 * 31) + obj.hashCode();
            }
        }
        return i11;
    }

    public static boolean equals(Object[] objArr, Object[] objArr2) {
        int i11;
        int length = objArr == null ? 0 : objArr.length;
        if (objArr2 == null) {
            i11 = 0;
        } else {
            i11 = objArr2.length;
        }
        int i12 = 0;
        int i13 = 0;
        while (true) {
            if (i12 >= length || objArr[i12] != null) {
                while (i13 < i11 && objArr2[i13] == null) {
                    i13++;
                }
                boolean z11 = i12 >= length;
                boolean z12 = i13 >= i11;
                if (z11 && z12) {
                    return true;
                }
                if (z11 != z12 || !objArr[i12].equals(objArr2[i13])) {
                    return false;
                }
                i12++;
                i13++;
            } else {
                i12++;
            }
        }
    }
}
