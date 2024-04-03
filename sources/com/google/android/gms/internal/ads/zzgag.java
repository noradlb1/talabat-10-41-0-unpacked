package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class zzgag extends zzfyg<zzggs, zzggp> {
    final /* synthetic */ zzgah zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzgag(zzgah zzgah, Class cls) {
        super(cls);
        this.zza = zzgah;
    }

    public final /* synthetic */ zzglv zza(zzgjf zzgjf) throws zzgkx {
        return zzggs.zzd(zzgjf, zzgjx.zza());
    }

    public final /* bridge */ /* synthetic */ Object zzc(zzglv zzglv) throws GeneralSecurityException {
        zzggs zzggs = (zzggs) zzglv;
        zzggo zzc = zzggp.zzc();
        zzc.zzb(0);
        zzc.zza(zzgjf.zzv(zzgig.zza(32)));
        return (zzggp) zzc.zzah();
    }

    public final Map<String, zzfyf<zzggs>> zzd() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("XCHACHA20_POLY1305", new zzfyf(zzggs.zzc(), 1));
        hashMap.put("XCHACHA20_POLY1305_RAW", new zzfyf(zzggs.zzc(), 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* bridge */ /* synthetic */ void zze(zzglv zzglv) throws GeneralSecurityException {
        zzggs zzggs = (zzggs) zzglv;
    }
}
