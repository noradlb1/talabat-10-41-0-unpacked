package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class zzfzh extends zzfyg<zzgcf, zzgcc> {
    final /* synthetic */ zzfzi zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzfzh(zzfzi zzfzi, Class cls) {
        super(cls);
        this.zza = zzfzi;
    }

    public final /* synthetic */ zzglv zza(zzgjf zzgjf) throws zzgkx {
        return zzgcf.zzd(zzgjf, zzgjx.zza());
    }

    public final /* bridge */ /* synthetic */ Object zzc(zzglv zzglv) throws GeneralSecurityException {
        zzgcf zzgcf = (zzgcf) zzglv;
        new zzfzl();
        zzgci zzg = zzfzk.zzg(zzgcf.zze());
        Object zzc = new zzgbl().zza().zzc(zzgcf.zzf());
        zzgcb zzc2 = zzgcc.zzc();
        zzc2.zza(zzg);
        zzc2.zzb((zzgew) zzc);
        zzc2.zzc(0);
        return (zzgcc) zzc2.zzah();
    }

    public final Map<String, zzfyf<zzgcf>> zzd() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("AES128_CTR_HMAC_SHA256", zzfzi.zzk(16, 16, 32, 16, 5, 1));
        hashMap.put("AES128_CTR_HMAC_SHA256_RAW", zzfzi.zzk(16, 16, 32, 16, 5, 3));
        hashMap.put("AES256_CTR_HMAC_SHA256", zzfzi.zzk(32, 16, 32, 32, 5, 1));
        hashMap.put("AES256_CTR_HMAC_SHA256_RAW", zzfzi.zzk(32, 16, 32, 32, 5, 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* bridge */ /* synthetic */ void zze(zzglv zzglv) throws GeneralSecurityException {
        zzgcf zzgcf = (zzgcf) zzglv;
        ((zzfzk) new zzfzl().zza()).zze(zzgcf.zze());
        new zzgbl().zza().zze(zzgcf.zzf());
        zzgii.zza(zzgcf.zze().zza());
    }
}
