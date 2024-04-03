package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class zzgan extends zzfyg<zzgdp, zzgdm> {
    final /* synthetic */ zzgao zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzgan(zzgao zzgao, Class cls) {
        super(cls);
        this.zza = zzgao;
    }

    public final /* synthetic */ zzglv zza(zzgjf zzgjf) throws zzgkx {
        return zzgdp.zze(zzgjf, zzgjx.zza());
    }

    public final /* bridge */ /* synthetic */ Object zzc(zzglv zzglv) throws GeneralSecurityException {
        zzgdl zzc = zzgdm.zzc();
        zzc.zza(zzgjf.zzv(zzgig.zza(((zzgdp) zzglv).zza())));
        zzc.zzb(0);
        return (zzgdm) zzc.zzah();
    }

    public final Map<String, zzfyf<zzgdp>> zzd() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        zzgdo zzc = zzgdp.zzc();
        zzc.zza(64);
        hashMap.put("AES256_SIV", new zzfyf((zzgdp) zzc.zzah(), 1));
        zzgdo zzc2 = zzgdp.zzc();
        zzc2.zza(64);
        hashMap.put("AES256_SIV_RAW", new zzfyf((zzgdp) zzc2.zzah(), 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* bridge */ /* synthetic */ void zze(zzglv zzglv) throws GeneralSecurityException {
        zzgdp zzgdp = (zzgdp) zzglv;
        if (zzgdp.zza() != 64) {
            int zza2 = zzgdp.zza();
            StringBuilder sb2 = new StringBuilder(61);
            sb2.append("invalid key size: ");
            sb2.append(zza2);
            sb2.append(". Valid keys must have 64 bytes.");
            throw new InvalidAlgorithmParameterException(sb2.toString());
        }
    }
}
