package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import okio.Utf8;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjg  reason: invalid package */
final class zzjg extends zzkk {
    final /* synthetic */ zzjh zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzjg(zzjh zzjh, Class cls) {
        super(cls);
        this.zza = zzjh;
    }

    public final /* bridge */ /* synthetic */ zzaif zza(zzaif zzaif) throws GeneralSecurityException {
        byte[] bArr;
        byte[] bArr2;
        zzsj zzsj = (zzsj) zzaif;
        int zzf = zzsj.zzd().zzf() - 2;
        if (zzf == 1) {
            bArr2 = zzwa.zza(32);
            bArr2[0] = (byte) (bArr2[0] | 7);
            byte b11 = bArr2[31] & Utf8.REPLACEMENT_BYTE;
            bArr2[31] = (byte) b11;
            bArr2[31] = (byte) (b11 | 128);
            bArr = zzwd.zzb(bArr2);
        } else if (zzf == 2 || zzf == 3 || zzf == 4) {
            int zzg = zzjk.zzg(zzsj.zzd().zzf());
            KeyPair zzc = zzvb.zzc(zzvb.zzi(zzg));
            ECPoint w11 = ((ECPublicKey) zzc.getPublic()).getW();
            EllipticCurve curve = zzvb.zzi(zzg).getCurve();
            zzjy.zzb(w11, curve);
            int zza2 = zzvb.zza(curve);
            int i11 = zza2 + zza2 + 1;
            bArr = new byte[i11];
            byte[] zza3 = zzjw.zza(w11.getAffineX());
            byte[] zza4 = zzjw.zza(w11.getAffineY());
            int length = zza4.length;
            System.arraycopy(zza4, 0, bArr, i11 - length, length);
            int length2 = zza3.length;
            System.arraycopy(zza3, 0, bArr, (zza2 + 1) - length2, length2);
            bArr[0] = 4;
            bArr2 = ((ECPrivateKey) zzc.getPrivate()).getS().toByteArray();
        } else {
            throw new GeneralSecurityException("Invalid KEM");
        }
        zzsr zzc2 = zzss.zzc();
        zzc2.zzc(0);
        zzc2.zza(zzsj.zzd());
        zzc2.zzb(zzafv.zzn(bArr, 0, bArr.length));
        zzso zzb = zzsp.zzb();
        zzb.zzc(0);
        zzb.zzb((zzss) zzc2.zzi());
        zzb.zza(zzafv.zzn(bArr2, 0, bArr2.length));
        return (zzsp) zzb.zzi();
    }

    public final /* synthetic */ zzaif zzb(zzafv zzafv) throws zzahi {
        return zzsj.zzc(zzafv, zzagn.zza());
    }

    public final Map zzc() {
        HashMap hashMap = new HashMap();
        hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_128_GCM", zzjh.zzh(3, 3, 3, 1));
        hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_128_GCM_RAW", zzjh.zzh(3, 3, 3, 3));
        hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_256_GCM", zzjh.zzh(3, 3, 4, 1));
        hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_256_GCM_RAW", zzjh.zzh(3, 3, 4, 3));
        hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_CHACHA20_POLY1305", zzjh.zzh(3, 3, 5, 1));
        hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_CHACHA20_POLY1305_RAW", zzjh.zzh(3, 3, 5, 3));
        hashMap.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_128_GCM", zzjh.zzh(4, 3, 3, 1));
        hashMap.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_128_GCM_RAW", zzjh.zzh(4, 3, 3, 3));
        hashMap.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_256_GCM", zzjh.zzh(4, 3, 4, 1));
        hashMap.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_256_GCM_RAW", zzjh.zzh(4, 3, 4, 3));
        hashMap.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_128_GCM", zzjh.zzh(5, 4, 3, 1));
        hashMap.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_128_GCM_RAW", zzjh.zzh(5, 4, 3, 3));
        hashMap.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_256_GCM", zzjh.zzh(5, 4, 4, 1));
        hashMap.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_256_GCM_RAW", zzjh.zzh(5, 4, 4, 3));
        hashMap.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_128_GCM", zzjh.zzh(6, 5, 3, 1));
        hashMap.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_128_GCM_RAW", zzjh.zzh(6, 5, 3, 3));
        hashMap.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_256_GCM", zzjh.zzh(6, 5, 4, 1));
        hashMap.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_256_GCM_RAW", zzjh.zzh(6, 5, 4, 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* synthetic */ void zzd(zzaif zzaif) throws GeneralSecurityException {
        zzjk.zza(((zzsj) zzaif).zzd());
    }
}
