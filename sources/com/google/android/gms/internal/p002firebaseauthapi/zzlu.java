package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlu  reason: invalid package */
public final class zzlu implements zzlw {
    private final zzwf zza;
    private final zztc zzb;

    private zzlu(zztc zztc, zzwf zzwf) {
        this.zzb = zztc;
        this.zza = zzwf;
    }

    public static zzlu zza(zztc zztc) throws GeneralSecurityException {
        String zzg = zztc.zzg();
        Charset charset = zzmg.zza;
        byte[] bArr = new byte[zzg.length()];
        for (int i11 = 0; i11 < zzg.length(); i11++) {
            char charAt = zzg.charAt(i11);
            if (charAt < '!' || charAt > '~') {
                throw new GeneralSecurityException("Not a printable ASCII character: " + charAt);
            }
            bArr[i11] = (byte) charAt;
        }
        return new zzlu(zztc, zzwf.zzb(bArr));
    }

    public static zzlu zzb(zztc zztc) {
        return new zzlu(zztc, zzmg.zzb(zztc.zzg()));
    }

    public final zztc zzc() {
        return this.zzb;
    }

    public final zzwf zzd() {
        return this.zza;
    }
}
