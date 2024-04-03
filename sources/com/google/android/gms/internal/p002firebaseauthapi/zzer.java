package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzer  reason: invalid package */
final class zzer extends zzkk {
    final /* synthetic */ zzes zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzer(zzes zzes, Class cls) {
        super(cls);
        this.zza = zzes;
    }

    public final /* bridge */ /* synthetic */ zzaif zza(zzaif zzaif) throws GeneralSecurityException {
        zzpy zzb = zzpz.zzb();
        byte[] zza2 = zzwa.zza(((zzqc) zzaif).zza());
        zzb.zza(zzafv.zzn(zza2, 0, zza2.length));
        zzb.zzb(0);
        return (zzpz) zzb.zzi();
    }

    public final /* synthetic */ zzaif zzb(zzafv zzafv) throws zzahi {
        return zzqc.zze(zzafv, zzagn.zza());
    }

    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("AES128_GCM", zzes.zzg(16, 1));
        hashMap.put("AES128_GCM_RAW", zzes.zzg(16, 3));
        hashMap.put("AES256_GCM", zzes.zzg(32, 1));
        hashMap.put("AES256_GCM_RAW", zzes.zzg(32, 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* synthetic */ void zzd(zzaif zzaif) throws GeneralSecurityException {
        zzwc.zzb(((zzqc) zzaif).zza());
    }
}
