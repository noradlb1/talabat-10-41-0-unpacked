package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class zzfzt extends zzfyg<zzgdj, zzgdg> {
    final /* synthetic */ zzfzu zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzfzt(zzfzu zzfzu, Class cls) {
        super(cls);
        this.zza = zzfzu;
    }

    public final /* synthetic */ zzglv zza(zzgjf zzgjf) throws zzgkx {
        return zzgdj.zze(zzgjf, zzgjx.zza());
    }

    public final /* bridge */ /* synthetic */ Object zzc(zzglv zzglv) throws GeneralSecurityException {
        zzgdf zzc = zzgdg.zzc();
        zzc.zza(zzgjf.zzv(zzgig.zza(((zzgdj) zzglv).zza())));
        zzc.zzb(0);
        return (zzgdg) zzc.zzah();
    }

    public final Map<String, zzfyf<zzgdj>> zzd() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("AES128_GCM_SIV", zzfzu.zzl(16, 1));
        hashMap.put("AES128_GCM_SIV_RAW", zzfzu.zzl(16, 3));
        hashMap.put("AES256_GCM_SIV", zzfzu.zzl(32, 1));
        hashMap.put("AES256_GCM_SIV_RAW", zzfzu.zzl(32, 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* synthetic */ void zze(zzglv zzglv) throws GeneralSecurityException {
        zzgii.zza(((zzgdj) zzglv).zza());
    }
}
