package com.google.android.gms.internal.ads;

import java.security.SecureRandom;

public final class zzgig {
    private static final ThreadLocal<SecureRandom> zza = new zzgif();

    public static byte[] zza(int i11) {
        byte[] bArr = new byte[i11];
        zza.get().nextBytes(bArr);
        return bArr;
    }
}
