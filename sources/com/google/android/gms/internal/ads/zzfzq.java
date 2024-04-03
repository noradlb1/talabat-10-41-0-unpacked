package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class zzfzq extends zzfyg<zzgdd, zzgda> {
    final /* synthetic */ zzfzr zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzfzq(zzfzr zzfzr, Class cls) {
        super(cls);
        this.zza = zzfzr;
    }

    public final /* synthetic */ zzglv zza(zzgjf zzgjf) throws zzgkx {
        return zzgdd.zze(zzgjf, zzgjx.zza());
    }

    public final /* bridge */ /* synthetic */ Object zzc(zzglv zzglv) throws GeneralSecurityException {
        zzgcz zzc = zzgda.zzc();
        zzc.zza(zzgjf.zzv(zzgig.zza(((zzgdd) zzglv).zza())));
        zzc.zzb(0);
        return (zzgda) zzc.zzah();
    }

    public final Map<String, zzfyf<zzgdd>> zzd() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("AES128_GCM", zzfzr.zzk(16, 1));
        hashMap.put("AES128_GCM_RAW", zzfzr.zzk(16, 3));
        hashMap.put("AES256_GCM", zzfzr.zzk(32, 1));
        hashMap.put("AES256_GCM_RAW", zzfzr.zzk(32, 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* synthetic */ void zze(zzglv zzglv) throws GeneralSecurityException {
        zzgii.zza(((zzgdd) zzglv).zza());
    }
}
