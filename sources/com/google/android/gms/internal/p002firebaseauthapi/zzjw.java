package com.google.android.gms.internal.p002firebaseauthapi;

import java.math.BigInteger;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjw  reason: invalid package */
public final class zzjw {
    public static byte[] zza(BigInteger bigInteger) {
        if (bigInteger.signum() != -1) {
            return bigInteger.toByteArray();
        }
        throw new IllegalArgumentException("n must not be negative");
    }
}
