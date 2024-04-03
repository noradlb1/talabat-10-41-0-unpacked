package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class zzgbh extends zzfyg<zzgbw, zzgbt> {
    public zzgbh(zzgbi zzgbi, Class cls) {
        super(cls);
    }

    public final /* synthetic */ zzglv zza(zzgjf zzgjf) throws zzgkx {
        return zzgbw.zze(zzgjf, zzgjx.zza());
    }

    public final /* bridge */ /* synthetic */ Object zzc(zzglv zzglv) throws GeneralSecurityException {
        zzgbw zzgbw = (zzgbw) zzglv;
        zzgbs zzc = zzgbt.zzc();
        zzc.zzc(0);
        zzc.zza(zzgjf.zzv(zzgig.zza(zzgbw.zza())));
        zzc.zzb(zzgbw.zzf());
        return (zzgbt) zzc.zzah();
    }

    public final Map<String, zzfyf<zzgbw>> zzd() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        zzgbv zzc = zzgbw.zzc();
        zzc.zza(32);
        zzgby zzc2 = zzgbz.zzc();
        zzc2.zza(16);
        zzc.zzb((zzgbz) zzc2.zzah());
        hashMap.put("AES_CMAC", new zzfyf((zzgbw) zzc.zzah(), 1));
        zzgbv zzc3 = zzgbw.zzc();
        zzc3.zza(32);
        zzgby zzc4 = zzgbz.zzc();
        zzc4.zza(16);
        zzc3.zzb((zzgbz) zzc4.zzah());
        hashMap.put("AES256_CMAC", new zzfyf((zzgbw) zzc3.zzah(), 1));
        zzgbv zzc5 = zzgbw.zzc();
        zzc5.zza(32);
        zzgby zzc6 = zzgbz.zzc();
        zzc6.zza(16);
        zzc5.zzb((zzgbz) zzc6.zzah());
        hashMap.put("AES256_CMAC_RAW", new zzfyf((zzgbw) zzc5.zzah(), 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* bridge */ /* synthetic */ void zze(zzglv zzglv) throws GeneralSecurityException {
        zzgbw zzgbw = (zzgbw) zzglv;
        zzgbi.zzm(zzgbw.zzf());
        zzgbi.zzn(zzgbw.zza());
    }
}
