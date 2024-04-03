package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzar  reason: invalid package */
public final class zzar {
    public static Object[] zza(Object[] objArr, int i11) {
        int i12 = 0;
        while (i12 < i11) {
            if (objArr[i12] != null) {
                i12++;
            } else {
                throw new NullPointerException("at index " + i12);
            }
        }
        return objArr;
    }
}
