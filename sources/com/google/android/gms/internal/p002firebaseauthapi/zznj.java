package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznj  reason: invalid package */
final class zznj extends zzkk {
    final /* synthetic */ zznk zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zznj(zznk zznk, Class cls) {
        super(cls);
        this.zza = zznk;
    }

    public final /* bridge */ /* synthetic */ zzaif zza(zzaif zzaif) throws GeneralSecurityException {
        zzsb zzsb = (zzsb) zzaif;
        zzrx zzb = zzry.zzb();
        zzb.zzc(0);
        zzb.zzb(zzsb.zzg());
        byte[] zza2 = zzwa.zza(zzsb.zza());
        zzb.zza(zzafv.zzn(zza2, 0, zza2.length));
        return (zzry) zzb.zzi();
    }

    public final /* synthetic */ zzaif zzb(zzafv zzafv) throws zzahi {
        return zzsb.zzf(zzafv, zzagn.zza());
    }

    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("HMAC_SHA256_128BITTAG", zznk.zzn(32, 16, 5, 1));
        hashMap.put("HMAC_SHA256_128BITTAG_RAW", zznk.zzn(32, 16, 5, 3));
        hashMap.put("HMAC_SHA256_256BITTAG", zznk.zzn(32, 32, 5, 1));
        hashMap.put("HMAC_SHA256_256BITTAG_RAW", zznk.zzn(32, 32, 5, 3));
        hashMap.put("HMAC_SHA512_128BITTAG", zznk.zzn(64, 16, 6, 1));
        hashMap.put("HMAC_SHA512_128BITTAG_RAW", zznk.zzn(64, 16, 6, 3));
        hashMap.put("HMAC_SHA512_256BITTAG", zznk.zzn(64, 32, 6, 1));
        hashMap.put("HMAC_SHA512_256BITTAG_RAW", zznk.zzn(64, 32, 6, 3));
        hashMap.put("HMAC_SHA512_512BITTAG", zznk.zzn(64, 64, 6, 1));
        hashMap.put("HMAC_SHA512_512BITTAG_RAW", zznk.zzn(64, 64, 6, 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* bridge */ /* synthetic */ void zzd(zzaif zzaif) throws GeneralSecurityException {
        zzsb zzsb = (zzsb) zzaif;
        if (zzsb.zza() >= 16) {
            zznk.zzo(zzsb.zzg());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }
}
