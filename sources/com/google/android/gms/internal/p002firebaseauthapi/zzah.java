package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzah  reason: invalid package */
public class zzah {
    public static int zza(int i11, int i12) {
        if (i12 >= 0) {
            int i13 = i11 + (i11 >> 1) + 1;
            if (i13 < i12) {
                int highestOneBit = Integer.highestOneBit(i12 - 1);
                i13 = highestOneBit + highestOneBit;
            }
            if (i13 < 0) {
                return Integer.MAX_VALUE;
            }
            return i13;
        }
        throw new AssertionError("cannot store more than MAX_VALUE elements");
    }
}
