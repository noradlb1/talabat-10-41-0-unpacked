package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class zzggz implements zzfxu {
    private static final ThreadLocal<Cipher> zza = new zzggy();
    private final SecretKey zzb;

    public zzggz(byte[] bArr) throws GeneralSecurityException {
        if (zzgak.zza(2)) {
            zzgii.zza(bArr.length);
            this.zzb = new SecretKeySpec(bArr, "AES");
            return;
        }
        throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        AlgorithmParameterSpec algorithmParameterSpec;
        int length = bArr.length;
        if (length <= 2147483619) {
            byte[] bArr3 = new byte[(length + 28)];
            byte[] zza2 = zzgig.zza(12);
            System.arraycopy(zza2, 0, bArr3, 0, 12);
            int length2 = zza2.length;
            if (!zzgih.zzb() || zzgih.zza() > 19) {
                algorithmParameterSpec = new GCMParameterSpec(128, zza2, 0, length2);
            } else {
                algorithmParameterSpec = new IvParameterSpec(zza2, 0, length2);
            }
            ThreadLocal<Cipher> threadLocal = zza;
            threadLocal.get().init(1, this.zzb, algorithmParameterSpec);
            int doFinal = threadLocal.get().doFinal(bArr, 0, length, bArr3, 12);
            if (doFinal == length + 16) {
                return bArr3;
            }
            throw new GeneralSecurityException(String.format("encryption failed; GCM tag must be %s bytes, but got only %s bytes", new Object[]{16, Integer.valueOf(doFinal - length)}));
        }
        throw new GeneralSecurityException("plaintext too long");
    }
}
