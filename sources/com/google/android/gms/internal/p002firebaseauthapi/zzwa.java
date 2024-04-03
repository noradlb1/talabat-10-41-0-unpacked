package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.SecureRandom;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwa  reason: invalid package */
public final class zzwa {
    private static final ThreadLocal zza = new zzvz();

    public static byte[] zza(int i11) {
        byte[] bArr = new byte[i11];
        ((SecureRandom) zza.get()).nextBytes(bArr);
        return bArr;
    }
}
