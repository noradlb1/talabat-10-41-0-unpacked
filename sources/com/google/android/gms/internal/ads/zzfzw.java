package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class zzfzw extends zzfyg<zzgdv, zzgds> {
    final /* synthetic */ zzfzx zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzfzw(zzfzx zzfzx, Class cls) {
        super(cls);
        this.zza = zzfzx;
    }

    public final /* synthetic */ zzglv zza(zzgjf zzgjf) throws zzgkx {
        return zzgdv.zzd(zzgjf, zzgjx.zza());
    }

    public final /* bridge */ /* synthetic */ Object zzc(zzglv zzglv) throws GeneralSecurityException {
        zzgdv zzgdv = (zzgdv) zzglv;
        zzgdr zzc = zzgds.zzc();
        zzc.zzb(0);
        zzc.zza(zzgjf.zzv(zzgig.zza(32)));
        return (zzgds) zzc.zzah();
    }

    public final Map<String, zzfyf<zzgdv>> zzd() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("CHACHA20_POLY1305", new zzfyf(zzgdv.zzc(), 1));
        hashMap.put("CHACHA20_POLY1305_RAW", new zzfyf(zzgdv.zzc(), 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* bridge */ /* synthetic */ void zze(zzglv zzglv) throws GeneralSecurityException {
        zzgdv zzgdv = (zzgdv) zzglv;
    }
}
