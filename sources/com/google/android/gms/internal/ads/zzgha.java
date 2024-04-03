package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.util.Arrays;
import java.util.Collection;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class zzgha implements zzfxx {
    private static final Collection<Integer> zza = Arrays.asList(new Integer[]{64});
    private static final byte[] zzb = new byte[16];
    private final zzgib zzc;
    private final byte[] zzd;

    public zzgha(byte[] bArr) throws GeneralSecurityException {
        if (zzgak.zza(1)) {
            Collection<Integer> collection = zza;
            int length = bArr.length;
            if (collection.contains(Integer.valueOf(length))) {
                int i11 = length >> 1;
                byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, i11);
                this.zzd = Arrays.copyOfRange(bArr, i11, length);
                this.zzc = new zzgib(copyOfRange);
                return;
            }
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("invalid key size: ");
            sb2.append(length);
            sb2.append(" bytes; key must have 64 bytes");
            throw new InvalidKeyException(sb2.toString());
        }
        throw new GeneralSecurityException("Can not use AES-SIV in FIPS-mode.");
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3;
        if (bArr.length <= 2147483631) {
            Cipher zza2 = zzghp.zza.zza("AES/CTR/NoPadding");
            byte[][] bArr4 = {bArr2, bArr};
            byte[] zza3 = this.zzc.zza(zzb, 16);
            for (int i11 = 0; i11 <= 0; i11++) {
                byte[] bArr5 = bArr4[i11];
                if (bArr5 == null) {
                    bArr5 = new byte[0];
                }
                zza3 = zzghc.zzc(zzghb.zzb(zza3), this.zzc.zza(bArr5, 16));
            }
            byte[] bArr6 = bArr4[1];
            int length = bArr6.length;
            if (length >= 16) {
                int length2 = zza3.length;
                if (length >= length2) {
                    int i12 = length - length2;
                    bArr3 = Arrays.copyOf(bArr6, length);
                    for (int i13 = 0; i13 < zza3.length; i13++) {
                        int i14 = i12 + i13;
                        bArr3[i14] = (byte) (bArr3[i14] ^ zza3[i13]);
                    }
                } else {
                    throw new IllegalArgumentException("xorEnd requires a.length >= b.length");
                }
            } else {
                bArr3 = zzghc.zzc(zzghb.zza(bArr6), zzghb.zzb(zza3));
            }
            byte[] zza4 = this.zzc.zza(bArr3, 16);
            byte[] bArr7 = (byte[]) zza4.clone();
            bArr7[8] = (byte) (bArr7[8] & Byte.MAX_VALUE);
            bArr7[12] = (byte) (bArr7[12] & Byte.MAX_VALUE);
            zza2.init(1, new SecretKeySpec(this.zzd, "AES"), new IvParameterSpec(bArr7));
            return zzghc.zzb(zza4, zza2.doFinal(bArr));
        }
        throw new GeneralSecurityException("plaintext too long");
    }
}
