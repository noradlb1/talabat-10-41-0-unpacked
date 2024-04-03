package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.AEADBadTagException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzur  reason: invalid package */
public final class zzur implements zzbd {
    private static final ThreadLocal zza = new zzup();
    private static final ThreadLocal zzb = new zzuq();
    private final byte[] zzc;
    private final byte[] zzd;
    private final SecretKeySpec zze;
    private final int zzf;

    public zzur(byte[] bArr, int i11) throws GeneralSecurityException {
        if (!zzhj.zza(1)) {
            throw new GeneralSecurityException("Can not use AES-EAX in FIPS-mode.");
        } else if (i11 == 12 || i11 == 16) {
            this.zzf = i11;
            zzwc.zzb(bArr.length);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            this.zze = secretKeySpec;
            Cipher cipher = (Cipher) zza.get();
            cipher.init(1, secretKeySpec);
            byte[] zzc2 = zzc(cipher.doFinal(new byte[16]));
            this.zzc = zzc2;
            this.zzd = zzc(zzc2);
        } else {
            throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
        }
    }

    private static byte[] zzc(byte[] bArr) {
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

    private final byte[] zzd(Cipher cipher, int i11, byte[] bArr, int i12, int i13) throws IllegalBlockSizeException, BadPaddingException {
        byte[] bArr2;
        int length;
        byte[] bArr3 = new byte[16];
        bArr3[15] = (byte) i11;
        if (i13 == 0) {
            return cipher.doFinal(zze(bArr3, this.zzc));
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
            bArr2 = zze(copyOfRange, this.zzc);
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
        return cipher.doFinal(zze(doFinal, bArr2));
    }

    private static byte[] zze(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        byte[] bArr3 = new byte[length];
        for (int i11 = 0; i11 < length; i11++) {
            bArr3[i11] = (byte) (bArr[i11] ^ bArr2[i11]);
        }
        return bArr3;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i11 = (length - this.zzf) - 16;
        if (i11 >= 0) {
            Cipher cipher = (Cipher) zza.get();
            cipher.init(1, this.zze);
            Cipher cipher2 = cipher;
            byte[] zzd2 = zzd(cipher2, 0, bArr, 0, this.zzf);
            byte[] zzd3 = zzd(cipher2, 1, bArr2, 0, 0);
            byte[] zzd4 = zzd(cipher, 2, bArr, this.zzf, i11);
            int i12 = length - 16;
            byte b11 = 0;
            for (int i13 = 0; i13 < 16; i13++) {
                b11 = (byte) (b11 | (((bArr[i12 + i13] ^ zzd3[i13]) ^ zzd2[i13]) ^ zzd4[i13]));
            }
            if (b11 == 0) {
                Cipher cipher3 = (Cipher) zzb.get();
                cipher3.init(1, this.zze, new IvParameterSpec(zzd2));
                return cipher3.doFinal(bArr, this.zzf, i11);
            }
            throw new AEADBadTagException("tag mismatch");
        }
        throw new GeneralSecurityException("ciphertext too short");
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        throw null;
    }
}
