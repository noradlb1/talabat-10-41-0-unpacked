package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfi  reason: invalid package */
final class zzfi extends zzkk {
    final /* synthetic */ zzfj zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzfi(zzfj zzfj, Class cls) {
        super(cls);
        this.zza = zzfj;
    }

    public final /* bridge */ /* synthetic */ zzaif zza(zzaif zzaif) throws GeneralSecurityException {
        zzqe zzb = zzqf.zzb();
        byte[] zza2 = zzwa.zza(((zzqi) zzaif).zza());
        zzb.zza(zzafv.zzn(zza2, 0, zza2.length));
        zzb.zzb(0);
        return (zzqf) zzb.zzi();
    }

    public final /* synthetic */ zzaif zzb(zzafv zzafv) throws zzahi {
        return zzqi.zze(zzafv, zzagn.zza());
    }

    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("AES128_GCM_SIV", zzfj.zzh(16, 1));
        hashMap.put("AES128_GCM_SIV_RAW", zzfj.zzh(16, 3));
        hashMap.put("AES256_GCM_SIV", zzfj.zzh(32, 1));
        hashMap.put("AES256_GCM_SIV_RAW", zzfj.zzh(32, 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* synthetic */ void zzd(zzaif zzaif) throws GeneralSecurityException {
        zzwc.zzb(((zzqi) zzaif).zza());
    }
}
