package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzij  reason: invalid package */
final class zzij extends zzkk {
    final /* synthetic */ zzik zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzij(zzik zzik, Class cls) {
        super(cls);
        this.zza = zzik;
    }

    public final /* bridge */ /* synthetic */ zzaif zza(zzaif zzaif) throws GeneralSecurityException {
        zzrc zzrc = (zzrc) zzaif;
        KeyPair zzc = zzvb.zzc(zzvb.zzi(zzit.zzc(zzrc.zzd().zze().zzf())));
        ECPoint w11 = ((ECPublicKey) zzc.getPublic()).getW();
        zzrk zzc2 = zzrl.zzc();
        zzc2.zzb(0);
        zzc2.zza(zzrc.zzd());
        byte[] byteArray = w11.getAffineX().toByteArray();
        zzafv zzafv = zzafv.zzb;
        zzc2.zzc(zzafv.zzn(byteArray, 0, byteArray.length));
        byte[] byteArray2 = w11.getAffineY().toByteArray();
        zzc2.zzd(zzafv.zzn(byteArray2, 0, byteArray2.length));
        zzrh zzb = zzri.zzb();
        zzb.zzc(0);
        zzb.zzb((zzrl) zzc2.zzi());
        byte[] byteArray3 = ((ECPrivateKey) zzc.getPrivate()).getS().toByteArray();
        zzb.zza(zzafv.zzn(byteArray3, 0, byteArray3.length));
        return (zzri) zzb.zzi();
    }

    public final /* synthetic */ zzaif zzb(zzafv zzafv) throws zzahi {
        return zzrc.zzc(zzafv, zzagn.zza());
    }

    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM", zzik.zzi(4, 5, 3, zzbv.zza("AES128_GCM"), zzik.zza, 1));
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM_RAW", zzik.zzi(4, 5, 3, zzbv.zza("AES128_GCM"), zzik.zza, 3));
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_GCM", zzik.zzi(4, 5, 4, zzbv.zza("AES128_GCM"), zzik.zza, 1));
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_GCM_RAW", zzik.zzi(4, 5, 4, zzbv.zza("AES128_GCM"), zzik.zza, 3));
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM_COMPRESSED_WITHOUT_PREFIX", zzik.zzi(4, 5, 4, zzbv.zza("AES128_GCM"), zzik.zza, 3));
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256", zzik.zzi(4, 5, 3, zzbv.zza("AES128_CTR_HMAC_SHA256"), zzik.zza, 1));
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256_RAW", zzik.zzi(4, 5, 3, zzbv.zza("AES128_CTR_HMAC_SHA256"), zzik.zza, 3));
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256", zzik.zzi(4, 5, 4, zzbv.zza("AES128_CTR_HMAC_SHA256"), zzik.zza, 1));
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256_RAW", zzik.zzi(4, 5, 4, zzbv.zza("AES128_CTR_HMAC_SHA256"), zzik.zza, 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* synthetic */ void zzd(zzaif zzaif) throws GeneralSecurityException {
        zzit.zza(((zzrc) zzaif).zzd());
    }
}
