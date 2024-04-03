package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class zzggx implements zzfxu {
    private static final ThreadLocal<Cipher> zza = new zzggv();
    private static final ThreadLocal<Cipher> zzb = new zzggw();
    private final byte[] zzc;
    private final byte[] zzd;
    private final SecretKeySpec zze;
    private final int zzf;

    public zzggx(byte[] bArr, int i11) throws GeneralSecurityException {
        if (!zzgak.zza(1)) {
            throw new GeneralSecurityException("Can not use AES-EAX in FIPS-mode.");
        } else if (i11 == 12 || i11 == 16) {
            this.zzf = i11;
            zzgii.zza(bArr.length);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            this.zze = secretKeySpec;
            Cipher cipher = zza.get();
            cipher.init(1, secretKeySpec);
            byte[] zzb2 = zzb(cipher.doFinal(new byte[16]));
            this.zzc = zzb2;
            this.zzd = zzb(zzb2);
        } else {
            throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
        }
    }

    private static byte[] zzb(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i11 = 0;
        while (i11 < 15) {
            byte b11 = bArr[i11];
            int i12 = i11 + 1;
            bArr2[i11] = (byte) (((b11 + b11) ^ ((bArr[i12] & 255) >>> 7)) & 255);
            i11 = i12;
        }
        byte b12 = bArr[15];
        bArr2[15] = (byte) (((bArr[0] >> 7) & 135) ^ (b12 + b12));
        return bArr2;
    }

    private final byte[] zzc(Cipher cipher, int i11, byte[] bArr, int i12, int i13) throws IllegalBlockSizeException, BadPaddingException {
        byte[] bArr2;
        int length;
        byte[] bArr3 = new byte[16];
        bArr3[15] = (byte) i11;
        if (i13 == 0) {
            return cipher.doFinal(zzd(bArr3, this.zzc));
        }
        byte[] doFinal = cipher.doFinal(bArr3);
        int i14 = 0;
        int i15 = 0;
        while (i13 - i15 > 16) {
            for (int i16 = 0; i16 < 16; i16++) {
                doFinal[i16] = (byte) (doFinal[i16] ^ bArr[(i12 + i15) + i16]);
            }
            doFinal = cipher.doFinal(doFinal);
            i15 += 16;
        }
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i15 + i12, i12 + i13);
        if (copyOfRange.length == 16) {
            bArr2 = zzd(copyOfRange, this.zzc);
        } else {
            byte[] copyOf = Arrays.copyOf(this.zzd, 16);
            while (true) {
                length = copyOfRange.length;
                if (i14 >= length) {
                    break;
                }
                copyOf[i14] = (byte) (copyOf[i14] ^ copyOfRange[i14]);
                i14++;
            }
            copyOf[length] = (byte) (copyOf[length] ^ 128);
            bArr2 = copyOf;
        }
        return cipher.doFinal(zzd(doFinal, bArr2));
    }

    private static byte[] zzd(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        byte[] bArr3 = new byte[length];
        for (int i11 = 0; i11 < length; i11++) {
            bArr3[i11] = (byte) (bArr[i11] ^ bArr2[i11]);
        }
        return bArr3;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i11 = this.zzf;
        if (length <= (Integer.MAX_VALUE - i11) - 16) {
            byte[] bArr3 = new byte[(i11 + length + 16)];
            byte[] zza2 = zzgig.zza(i11);
            System.arraycopy(zza2, 0, bArr3, 0, this.zzf);
            Cipher cipher = zza.get();
            cipher.init(1, this.zze);
            Cipher cipher2 = cipher;
            byte[] zzc2 = zzc(cipher2, 0, zza2, 0, zza2.length);
            byte[] zzc3 = zzc(cipher2, 1, bArr2, 0, 0);
            Cipher cipher3 = zzb.get();
            cipher3.init(1, this.zze, new IvParameterSpec(zzc2));
            cipher3.doFinal(bArr, 0, length, bArr3, this.zzf);
            byte[] zzc4 = zzc(cipher, 2, bArr3, this.zzf, length);
            int i12 = length + this.zzf;
            for (int i13 = 0; i13 < 16; i13++) {
                bArr3[i12 + i13] = (byte) ((zzc3[i13] ^ zzc2[i13]) ^ zzc4[i13]);
            }
            return bArr3;
        }
        throw new GeneralSecurityException("plaintext too long");
    }
}
