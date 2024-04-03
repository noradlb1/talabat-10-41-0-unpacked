package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

final class zzgbd {
    public static void zza(zzgeg zzgeg) throws GeneralSecurityException {
        zzghn.zze(zzc(zzgeg.zzf().zzg()));
        zzb(zzgeg.zzf().zzh());
        if (zzgeg.zzi() != 2) {
            zzfza.zzc(zzgeg.zza().zze());
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
        throw new NoSuchAlgorithmException("hash unsupported for HMAC: ".concat(Integer.toString(zzget.zza(i11))));
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
        throw new GeneralSecurityException("unknown curve type: ".concat(Integer.toString(zzger.zza(i11))));
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
                throw new GeneralSecurityException("unknown point format: ".concat(Integer.toString(zzgdx.zza(i11))));
            }
        }
        return i13;
    }
}
