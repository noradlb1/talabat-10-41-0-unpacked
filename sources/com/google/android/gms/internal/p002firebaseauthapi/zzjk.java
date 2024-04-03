package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjk  reason: invalid package */
public final class zzjk {
    public static final byte[] zza = zzc(1, 0);
    public static final byte[] zzb = zzc(2, 32);
    public static final byte[] zzc = zzc(2, 16);
    public static final byte[] zzd = zzc(2, 17);
    public static final byte[] zze = zzc(2, 18);
    public static final byte[] zzf = zzc(2, 1);
    public static final byte[] zzg = zzc(2, 2);
    public static final byte[] zzh = zzc(2, 3);
    public static final byte[] zzi = zzc(2, 1);
    public static final byte[] zzj = zzc(2, 2);
    public static final byte[] zzk = zzc(2, 3);
    public static final byte[] zzl = new byte[0];
    private static final byte[] zzm;
    private static final byte[] zzn;
    private static final byte[] zzo;

    static {
        Charset charset = zzmg.zza;
        zzm = "KEM".getBytes(charset);
        zzn = "HPKE".getBytes(charset);
        zzo = "HPKE-v1".getBytes(charset);
    }

    public static void zza(zzsm zzsm) throws GeneralSecurityException {
        if (zzsm.zzf() == 2 || zzsm.zzf() == 1) {
            throw new GeneralSecurityException("Invalid KEM param: ".concat(zzsg.zza(zzsm.zzf())));
        }
        String str = "UNRECOGNIZED";
        if (zzsm.zze() == 2 || zzsm.zze() == 1) {
            int zze2 = zzsm.zze();
            if (zze2 == 2) {
                str = "KDF_UNKNOWN";
            } else if (zze2 == 3) {
                str = "HKDF_SHA256";
            } else if (zze2 == 4) {
                str = "HKDF_SHA384";
            } else if (zze2 == 5) {
                str = "HKDF_SHA512";
            }
            throw new GeneralSecurityException("Invalid KDF param: ".concat(str));
        } else if (zzsm.zzd() == 2 || zzsm.zzd() == 1) {
            int zzd2 = zzsm.zzd();
            if (zzd2 == 2) {
                str = "AEAD_UNKNOWN";
            } else if (zzd2 == 3) {
                str = "AES_128_GCM";
            } else if (zzd2 == 4) {
                str = "AES_256_GCM";
            } else if (zzd2 == 5) {
                str = "CHACHA20_POLY1305";
            }
            throw new GeneralSecurityException("Invalid AEAD param: ".concat(str));
        }
    }

    public static byte[] zzb(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        return zzuu.zzb(zzn, bArr, bArr2, bArr3);
    }

    public static byte[] zzc(int i11, int i12) {
        byte[] bArr = new byte[i11];
        for (int i13 = 0; i13 < i11; i13++) {
            bArr[i13] = (byte) ((i12 >> (((i11 - i13) - 1) * 8)) & 255);
        }
        return bArr;
    }

    public static byte[] zzd(byte[] bArr) throws GeneralSecurityException {
        return zzuu.zzb(zzm, bArr);
    }

    public static byte[] zze(String str, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return zzuu.zzb(zzo, bArr2, str.getBytes(zzmg.zza), bArr);
    }

    public static byte[] zzf(String str, byte[] bArr, byte[] bArr2, int i11) throws GeneralSecurityException {
        return zzuu.zzb(zzc(2, i11), zzo, bArr2, str.getBytes(zzmg.zza), bArr);
    }

    public static int zzg(int i11) throws GeneralSecurityException {
        int i12 = i11 - 2;
        if (i12 == 2) {
            return 1;
        }
        if (i12 == 3) {
            return 2;
        }
        if (i12 == 4) {
            return 3;
        }
        throw new GeneralSecurityException("Unrecognized NIST HPKE KEM identifier");
    }
}
