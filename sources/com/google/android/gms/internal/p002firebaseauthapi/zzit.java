package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzit  reason: invalid package */
final class zzit {
    public static void zza(zzrf zzrf) throws GeneralSecurityException {
        zzvb.zzi(zzc(zzrf.zze().zzf()));
        zzb(zzrf.zze().zzg());
        if (zzrf.zzh() != 2) {
            zzcq.zzb(zzrf.zza().zzd());
            return;
        }
        throw new GeneralSecurityException("unknown EC point format");
    }

    public static String zzb(int i11) throws NoSuchAlgorithmException {
        int i12 = i11 - 2;
        if (i12 == 1) {
            return "HmacSha1";
        }
        if (i12 == 2) {
            return "HmacSha384";
        }
        if (i12 == 3) {
            return "HmacSha256";
        }
        if (i12 == 4) {
            return "HmacSha512";
        }
        if (i12 == 5) {
            return "HmacSha224";
        }
        throw new NoSuchAlgorithmException("hash unsupported for HMAC: ".concat(Integer.toString(zzrv.zza(i11))));
    }

    public static int zzc(int i11) throws GeneralSecurityException {
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
        throw new GeneralSecurityException("unknown curve type: ".concat(Integer.toString(zzrq.zza(i11))));
    }

    public static int zzd(int i11) throws GeneralSecurityException {
        int i12 = i11 - 2;
        int i13 = 1;
        if (i12 != 1) {
            i13 = 2;
            if (i12 != 2) {
                if (i12 == 3) {
                    return 3;
                }
                throw new GeneralSecurityException("unknown point format: ".concat(Integer.toString(zzqw.zza(i11))));
            }
        }
        return i13;
    }
}
