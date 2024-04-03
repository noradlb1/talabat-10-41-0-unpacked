package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;

final class zzgbj extends zzfyh<zzfym, zzgew> {
    public zzgbj(Class cls) {
        super(cls);
    }

    public final /* bridge */ /* synthetic */ Object zzb(Object obj) throws GeneralSecurityException {
        zzgew zzgew = (zzgew) obj;
        int zzg = zzgew.zzg().zzg();
        SecretKeySpec secretKeySpec = new SecretKeySpec(zzgew.zzh().zzE(), "HMAC");
        int zza = zzgew.zzg().zza();
        int i11 = zzg - 2;
        if (i11 == 1) {
            return new zzgie(new zzgid("HMACSHA1", secretKeySpec), zza);
        }
        if (i11 == 2) {
            return new zzgie(new zzgid("HMACSHA384", secretKeySpec), zza);
        }
        if (i11 == 3) {
            return new zzgie(new zzgid("HMACSHA256", secretKeySpec), zza);
        }
        if (i11 == 4) {
            return new zzgie(new zzgid("HMACSHA512", secretKeySpec), zza);
        }
        if (i11 == 5) {
            return new zzgie(new zzgid("HMACSHA224", secretKeySpec), zza);
        }
        throw new GeneralSecurityException("unknown hash");
    }
}
