package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhq  reason: invalid package */
final class zzhq extends zzkk {
    final /* synthetic */ zzhr zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzhq(zzhr zzhr, Class cls) {
        super(cls);
        this.zza = zzhr;
    }

    public final /* bridge */ /* synthetic */ zzaif zza(zzaif zzaif) throws GeneralSecurityException {
        zzqk zzb = zzql.zzb();
        byte[] zza2 = zzwa.zza(((zzqo) zzaif).zza());
        zzb.zza(zzafv.zzn(zza2, 0, zza2.length));
        zzb.zzb(0);
        return (zzql) zzb.zzi();
    }

    public final /* synthetic */ zzaif zzb(zzafv zzafv) throws zzahi {
        return zzqo.zze(zzafv, zzagn.zza());
    }

    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        zzqn zzc = zzqo.zzc();
        zzc.zza(64);
        hashMap.put("AES256_SIV", new zzkj((zzqo) zzc.zzi(), 1));
        zzqn zzc2 = zzqo.zzc();
        zzc2.zza(64);
        hashMap.put("AES256_SIV_RAW", new zzkj((zzqo) zzc2.zzi(), 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* bridge */ /* synthetic */ void zzd(zzaif zzaif) throws GeneralSecurityException {
        zzqo zzqo = (zzqo) zzaif;
        if (zzqo.zza() != 64) {
            int zza2 = zzqo.zza();
            throw new InvalidAlgorithmParameterException("invalid key size: " + zza2 + ". Valid keys must have 64 bytes.");
        }
    }
}
