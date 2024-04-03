package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class zzggu implements zzghz {
    private static final ThreadLocal<Cipher> zza = new zzggt();
    private final SecretKeySpec zzb;
    private final int zzc;
    private final int zzd;

    public zzggu(byte[] bArr, int i11) throws GeneralSecurityException {
        if (zzgak.zza(2)) {
            zzgii.zza(bArr.length);
            this.zzb = new SecretKeySpec(bArr, "AES");
            int blockSize = zza.get().getBlockSize();
            this.zzd = blockSize;
            if (i11 < 12 || i11 > blockSize) {
                throw new GeneralSecurityException("invalid IV size");
            }
            this.zzc = i11;
            return;
        }
        throw new GeneralSecurityException("Can not use AES-CTR in FIPS-mode, as BoringCrypto module is not available.");
    }

    public final byte[] zza(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        int i11 = this.zzc;
        int i12 = Integer.MAX_VALUE - i11;
        if (length <= i12) {
            byte[] bArr2 = new byte[(i11 + length)];
            byte[] zza2 = zzgig.zza(i11);
            System.arraycopy(zza2, 0, bArr2, 0, this.zzc);
            int i13 = this.zzc;
            Cipher cipher = zza.get();
            byte[] bArr3 = new byte[this.zzd];
            System.arraycopy(zza2, 0, bArr3, 0, this.zzc);
            cipher.init(1, this.zzb, new IvParameterSpec(bArr3));
            if (cipher.doFinal(bArr, 0, length, bArr2, i13) == length) {
                return bArr2;
            }
            throw new GeneralSecurityException("stored output's length does not match input's length");
        }
        StringBuilder sb2 = new StringBuilder(43);
        sb2.append("plaintext length can not exceed ");
        sb2.append(i12);
        throw new GeneralSecurityException(sb2.toString());
    }
}
