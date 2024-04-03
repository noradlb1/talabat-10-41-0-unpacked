package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class zzgat extends zzfyg<zzged, zzgej> {
    final /* synthetic */ zzgau zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzgat(zzgau zzgau, Class cls) {
        super(cls);
        this.zza = zzgau;
    }

    public final /* synthetic */ zzglv zza(zzgjf zzgjf) throws zzgkx {
        return zzged.zzd(zzgjf, zzgjx.zza());
    }

    public final /* bridge */ /* synthetic */ Object zzc(zzglv zzglv) throws GeneralSecurityException {
        zzged zzged = (zzged) zzglv;
        KeyPair zzb = zzghn.zzb(zzghn.zze(zzgbd.zzc(zzged.zze().zzf().zzg())));
        ECPoint w11 = ((ECPublicKey) zzb.getPublic()).getW();
        zzgel zzd = zzgem.zzd();
        zzd.zzb(0);
        zzd.zza(zzged.zze());
        zzd.zzc(zzgjf.zzv(w11.getAffineX().toByteArray()));
        zzd.zzd(zzgjf.zzv(w11.getAffineY().toByteArray()));
        zzgei zzc = zzgej.zzc();
        zzc.zzc(0);
        zzc.zzb((zzgem) zzd.zzah());
        zzc.zza(zzgjf.zzv(((ECPrivateKey) zzb.getPrivate()).getS().toByteArray()));
        return (zzgej) zzc.zzah();
    }

    public final Map<String, zzfyf<zzged>> zzd() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM", zzgau.zzl(4, 5, 3, zzfye.zza("AES128_GCM"), zzgau.zza, 1));
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM_RAW", zzgau.zzl(4, 5, 3, zzfye.zza("AES128_GCM"), zzgau.zza, 3));
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_GCM", zzgau.zzl(4, 5, 4, zzfye.zza("AES128_GCM"), zzgau.zza, 1));
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_GCM_RAW", zzgau.zzl(4, 5, 4, zzfye.zza("AES128_GCM"), zzgau.zza, 3));
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM_COMPRESSED_WITHOUT_PREFIX", zzgau.zzl(4, 5, 4, zzfye.zza("AES128_GCM"), zzgau.zza, 3));
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256", zzgau.zzl(4, 5, 3, zzfye.zza("AES128_CTR_HMAC_SHA256"), zzgau.zza, 1));
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256_RAW", zzgau.zzl(4, 5, 3, zzfye.zza("AES128_CTR_HMAC_SHA256"), zzgau.zza, 3));
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256", zzgau.zzl(4, 5, 4, zzfye.zza("AES128_CTR_HMAC_SHA256"), zzgau.zza, 1));
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256_RAW", zzgau.zzl(4, 5, 4, zzfye.zza("AES128_CTR_HMAC_SHA256"), zzgau.zza, 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* synthetic */ void zze(zzglv zzglv) throws GeneralSecurityException {
        zzgbd.zza(((zzged) zzglv).zze());
    }
}
