package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public final class zzgib implements zzgbq {
    private final SecretKey zza;
    private final byte[] zzb;
    private final byte[] zzc;

    public zzgib(byte[] bArr) throws GeneralSecurityException {
        zzgii.zza(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.zza = secretKeySpec;
        Cipher zzb2 = zzb();
        zzb2.init(1, secretKeySpec);
        byte[] zzb3 = zzghb.zzb(zzb2.doFinal(new byte[16]));
        this.zzb = zzb3;
        this.zzc = zzghb.zzb(zzb3);
    }

    private static Cipher zzb() throws GeneralSecurityException {
        if (zzgak.zza(1)) {
            return zzghp.zza.zza("AES/ECB/NoPadding");
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
                bArr2 = zzghc.zzd(bArr, (max - 1) * 16, this.zzb, 0, 16);
            } else {
                bArr2 = zzghc.zzc(zzghb.zza(Arrays.copyOfRange(bArr, (max - 1) * 16, length)), this.zzc);
            }
            byte[] bArr3 = new byte[16];
            for (int i12 = 0; i12 < max - 1; i12++) {
                bArr3 = zzb2.doFinal(zzghc.zzd(bArr3, 0, bArr, i12 * 16, 16));
            }
            return Arrays.copyOf(zzb2.doFinal(zzghc.zzc(bArr2, bArr3)), i11);
        }
        throw new InvalidAlgorithmParameterException("outputLength too large, max is 16 bytes");
    }
}
