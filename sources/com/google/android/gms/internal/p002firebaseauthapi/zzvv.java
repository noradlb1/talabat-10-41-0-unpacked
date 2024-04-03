package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvv  reason: invalid package */
public final class zzvv implements zzop {
    private final SecretKey zza;
    private final byte[] zzb;
    private final byte[] zzc;

    public zzvv(byte[] bArr) throws GeneralSecurityException {
        zzwc.zzb(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.zza = secretKeySpec;
        Cipher zzb2 = zzb();
        zzb2.init(1, secretKeySpec);
        byte[] zzb3 = zzoc.zzb(zzb2.doFinal(new byte[16]));
        this.zzb = zzb3;
        this.zzc = zzoc.zzb(zzb3);
    }

    private static Cipher zzb() throws GeneralSecurityException {
        if (zzhj.zza(1)) {
            return (Cipher) zzvk.zza.zza("AES/ECB/NoPadding");
        }
        throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
    }

    public final byte[] zza(byte[] bArr, int i11) throws GeneralSecurityException {
        byte[] bArr2;
        if (i11 <= 16) {
            Cipher zzb2 = zzb();
            zzb2.init(1, this.zza);
            int length = bArr.length;
            int max = Math.max(1, (int) Math.ceil(((double) length) / 16.0d));
            if (max * 16 == length) {
                bArr2 = zzuu.zzd(bArr, (max - 1) * 16, this.zzb, 0, 16);
            } else {
                bArr2 = zzuu.zzc(zzoc.zza(Arrays.copyOfRange(bArr, (max - 1) * 16, length)), this.zzc);
            }
            byte[] bArr3 = new byte[16];
            for (int i12 = 0; i12 < max - 1; i12++) {
                bArr3 = zzb2.doFinal(zzuu.zzd(bArr3, 0, bArr, i12 * 16, 16));
            }
            return Arrays.copyOf(zzb2.doFinal(zzuu.zzc(bArr2, bArr3)), i11);
        }
        throw new InvalidAlgorithmParameterException("outputLength too large, max is 16 bytes");
    }
}
