package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class zzfzn extends zzfyg<zzgcu, zzgcr> {
    final /* synthetic */ zzfzo zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzfzn(zzfzo zzfzo, Class cls) {
        super(cls);
        this.zza = zzfzo;
    }

    public final /* synthetic */ zzglv zza(zzgjf zzgjf) throws zzgkx {
        return zzgcu.zze(zzgjf, zzgjx.zza());
    }

    public final /* bridge */ /* synthetic */ Object zzc(zzglv zzglv) throws GeneralSecurityException {
        zzgcu zzgcu = (zzgcu) zzglv;
        zzgcq zzc = zzgcr.zzc();
        zzc.zza(zzgjf.zzv(zzgig.zza(zzgcu.zza())));
        zzc.zzb(zzgcu.zzf());
        zzc.zzc(0);
        return (zzgcr) zzc.zzah();
    }

    public final Map<String, zzfyf<zzgcu>> zzd() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("AES128_EAX", zzfzo.zzk(16, 16, 1));
        hashMap.put("AES128_EAX_RAW", zzfzo.zzk(16, 16, 3));
        hashMap.put("AES256_EAX", zzfzo.zzk(32, 16, 1));
        hashMap.put("AES256_EAX_RAW", zzfzo.zzk(32, 16, 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* bridge */ /* synthetic */ void zze(zzglv zzglv) throws GeneralSecurityException {
        zzgcu zzgcu = (zzgcu) zzglv;
        zzgii.zza(zzgcu.zza());
        if (zzgcu.zzf().zza() != 12 && zzgcu.zzf().zza() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }
}
