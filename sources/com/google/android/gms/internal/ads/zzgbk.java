package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class zzgbk extends zzfyg<zzgez, zzgew> {
    final /* synthetic */ zzgbl zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzgbk(zzgbl zzgbl, Class cls) {
        super(cls);
        this.zza = zzgbl;
    }

    public final /* synthetic */ zzglv zza(zzgjf zzgjf) throws zzgkx {
        return zzgez.zzf(zzgjf, zzgjx.zza());
    }

    public final /* bridge */ /* synthetic */ Object zzc(zzglv zzglv) throws GeneralSecurityException {
        zzgez zzgez = (zzgez) zzglv;
        zzgev zzc = zzgew.zzc();
        zzc.zzc(0);
        zzc.zzb(zzgez.zzg());
        zzc.zza(zzgjf.zzv(zzgig.zza(zzgez.zza())));
        return (zzgew) zzc.zzah();
    }

    public final Map<String, zzfyf<zzgez>> zzd() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("HMAC_SHA256_128BITTAG", zzgbl.zzm(32, 16, 5, 1));
        hashMap.put("HMAC_SHA256_128BITTAG_RAW", zzgbl.zzm(32, 16, 5, 3));
        hashMap.put("HMAC_SHA256_256BITTAG", zzgbl.zzm(32, 32, 5, 1));
        hashMap.put("HMAC_SHA256_256BITTAG_RAW", zzgbl.zzm(32, 32, 5, 3));
        hashMap.put("HMAC_SHA512_128BITTAG", zzgbl.zzm(64, 16, 6, 1));
        hashMap.put("HMAC_SHA512_128BITTAG_RAW", zzgbl.zzm(64, 16, 6, 3));
        hashMap.put("HMAC_SHA512_256BITTAG", zzgbl.zzm(64, 32, 6, 1));
        hashMap.put("HMAC_SHA512_256BITTAG_RAW", zzgbl.zzm(64, 32, 6, 3));
        hashMap.put("HMAC_SHA512_512BITTAG", zzgbl.zzm(64, 64, 6, 1));
        hashMap.put("HMAC_SHA512_512BITTAG_RAW", zzgbl.zzm(64, 64, 6, 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* bridge */ /* synthetic */ void zze(zzglv zzglv) throws GeneralSecurityException {
        zzgez zzgez = (zzgez) zzglv;
        if (zzgez.zza() >= 16) {
            zzgbl.zzn(zzgez.zzg());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }
}
