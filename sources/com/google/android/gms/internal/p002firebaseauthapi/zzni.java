package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzni  reason: invalid package */
final class zzni extends zzll {
    public zzni(Class cls) {
        super(cls);
    }

    public final /* bridge */ /* synthetic */ Object zza(zzaif zzaif) throws GeneralSecurityException {
        zzry zzry = (zzry) zzaif;
        int zzf = zzry.zzf().zzf();
        SecretKeySpec secretKeySpec = new SecretKeySpec(zzry.zzg().zzq(), "HMAC");
        int zza = zzry.zzf().zza();
        int i11 = zzf - 2;
        if (i11 == 1) {
            return new zzvy(new zzvx("HMACSHA1", secretKeySpec), zza);
        }
        if (i11 == 2) {
            return new zzvy(new zzvx("HMACSHA384", secretKeySpec), zza);
        }
        if (i11 == 3) {
            return new zzvy(new zzvx("HMACSHA256", secretKeySpec), zza);
        }
        if (i11 == 4) {
            return new zzvy(new zzvx("HMACSHA512", secretKeySpec), zza);
        }
        if (i11 == 5) {
            return new zzvy(new zzvx("HMACSHA224", secretKeySpec), zza);
        }
        throw new GeneralSecurityException("unknown hash");
    }
}
