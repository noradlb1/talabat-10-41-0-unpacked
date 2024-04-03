package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdf  reason: invalid package */
final class zzdf extends zzkk {
    final /* synthetic */ zzdg zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzdf(zzdg zzdg, Class cls) {
        super(cls);
        this.zza = zzdg;
    }

    public final /* bridge */ /* synthetic */ zzaif zza(zzaif zzaif) throws GeneralSecurityException {
        zzpe zzpe = (zzpe) zzaif;
        new zzdu();
        zzph zzf = zzdt.zzf(zzpe.zzd());
        zzaif zza2 = new zznk().zza().zza(zzpe.zze());
        zzpa zzb = zzpb.zzb();
        zzb.zza(zzf);
        zzb.zzb((zzry) zza2);
        zzb.zzc(0);
        return (zzpb) zzb.zzi();
    }

    public final /* synthetic */ zzaif zzb(zzafv zzafv) throws zzahi {
        return zzpe.zzc(zzafv, zzagn.zza());
    }

    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("AES128_CTR_HMAC_SHA256", zzdg.zzg(16, 16, 32, 16, 5, 1));
        hashMap.put("AES128_CTR_HMAC_SHA256_RAW", zzdg.zzg(16, 16, 32, 16, 5, 3));
        hashMap.put("AES256_CTR_HMAC_SHA256", zzdg.zzg(32, 16, 32, 32, 5, 1));
        hashMap.put("AES256_CTR_HMAC_SHA256_RAW", zzdg.zzg(32, 16, 32, 32, 5, 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* bridge */ /* synthetic */ void zzd(zzaif zzaif) throws GeneralSecurityException {
        zzpe zzpe = (zzpe) zzaif;
        ((zzdt) new zzdu().zza()).zzd(zzpe.zzd());
        new zznk().zza().zzd(zzpe.zze());
        zzwc.zzb(zzpe.zzd().zza());
    }
}
