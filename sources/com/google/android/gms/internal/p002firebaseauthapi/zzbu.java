package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbu  reason: invalid package */
public final class zzbu {
    private final zztc zza;

    private zzbu(zztc zztc) {
        this.zza = zztc;
    }

    public static zzbu zzc(String str, byte[] bArr, int i11) {
        zzud zzud;
        zztb zza2 = zztc.zza();
        zza2.zzb(str);
        zzafv zzafv = zzafv.zzb;
        zza2.zzc(zzafv.zzn(bArr, 0, bArr.length));
        int i12 = i11 - 1;
        if (i12 == 0) {
            zzud = zzud.TINK;
        } else if (i12 == 1) {
            zzud = zzud.LEGACY;
        } else if (i12 != 2) {
            zzud = zzud.CRUNCHY;
        } else {
            zzud = zzud.RAW;
        }
        zza2.zza(zzud);
        return new zzbu((zztc) zza2.zzi());
    }

    public final zzce zza() throws GeneralSecurityException {
        try {
            zztc zzd = zztc.zzd(this.zza.zzq(), zzagn.zza());
            zzky zzc = zzky.zzc();
            zzlu zza2 = zzlu.zza(zzd);
            if (!zzc.zzi(zza2)) {
                return new zzko(zza2);
            }
            return zzc.zzb(zza2);
        } catch (IOException e11) {
            throw new GeneralSecurityException("Failed to parse proto", e11);
        }
    }

    public final zztc zzb() {
        return this.zza;
    }
}
