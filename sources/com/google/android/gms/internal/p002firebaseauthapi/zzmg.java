package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.common.base.Ascii;
import java.nio.charset.Charset;
import java.security.SecureRandom;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmg  reason: invalid package */
public final class zzmg {
    public static final Charset zza = Charset.forName("UTF-8");

    public static int zza() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] bArr = new byte[4];
        byte b11 = 0;
        while (b11 == 0) {
            secureRandom.nextBytes(bArr);
            b11 = ((bArr[0] & Byte.MAX_VALUE) << Ascii.CAN) | ((bArr[1] & 255) << Ascii.DLE) | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        }
        return b11;
    }

    public static final zzwf zzb(String str) {
        byte[] bArr = new byte[str.length()];
        for (int i11 = 0; i11 < str.length(); i11++) {
            char charAt = str.charAt(i11);
            if (charAt < '!' || charAt > '~') {
                throw new zzmf("Not a printable ASCII character: " + charAt);
            }
            bArr[i11] = (byte) charAt;
        }
        return zzwf.zzb(bArr);
    }
}
