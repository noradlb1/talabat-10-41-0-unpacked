package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.common.base.Ascii;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import org.apache.commons.compress.archivers.tar.TarConstants;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjx  reason: invalid package */
public final class zzjx {
    static final byte[][] zza = {new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new byte[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new byte[]{-32, -21, 122, 124, 59, 65, -72, -82, Ascii.SYN, 86, -29, -6, -15, -97, -60, 106, -38, 9, -115, -21, -100, TarConstants.LF_SYMLINK, -79, -3, -122, 98, 5, Ascii.SYN, 95, 73, -72, 0}, new byte[]{95, -100, -107, -68, -93, 80, -116, 36, -79, -48, -79, 85, -100, -125, -17, 91, 4, 68, 92, -60, TarConstants.LF_PAX_EXTENDED_HEADER_UC, Ascii.FS, -114, -122, -40, 34, 78, -35, -48, -97, 17, 87}, new byte[]{-20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE}, new byte[]{-19, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE}, new byte[]{-18, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE}};

    public static void zza(long[] jArr, byte[] bArr, byte[] bArr2) throws InvalidKeyException {
        long[] jArr2 = jArr;
        byte[] bArr3 = bArr2;
        int i11 = 32;
        if (bArr3.length == 32) {
            byte[] copyOf = Arrays.copyOf(bArr3, 32);
            copyOf[31] = (byte) (copyOf[31] & Byte.MAX_VALUE);
            int i12 = 0;
            int i13 = 0;
            while (i13 < 7) {
                byte[][] bArr4 = zza;
                if (!MessageDigest.isEqual(bArr4[i13], copyOf)) {
                    i13++;
                } else {
                    throw new InvalidKeyException("Banned public key: ".concat(zzvt.zza(bArr4[i13])));
                }
            }
            long[] zzk = zzjz.zzk(copyOf);
            long[] jArr3 = new long[19];
            long[] jArr4 = new long[19];
            jArr4[0] = 1;
            long[] jArr5 = new long[19];
            jArr5[0] = 1;
            long[] jArr6 = new long[19];
            long[] jArr7 = new long[19];
            long[] jArr8 = new long[19];
            jArr8[0] = 1;
            long[] jArr9 = new long[19];
            long[] jArr10 = new long[19];
            jArr10[0] = 1;
            int i14 = 10;
            System.arraycopy(zzk, 0, jArr3, 0, 10);
            int i15 = 0;
            while (i15 < i11) {
                byte b11 = bArr[(32 - i15) - 1] & 255;
                while (i12 < 8) {
                    int i16 = (b11 >> (7 - i12)) & 1;
                    zzb(jArr5, jArr3, i16);
                    zzb(jArr6, jArr4, i16);
                    long[] copyOf2 = Arrays.copyOf(jArr5, i14);
                    byte b12 = b11;
                    long[] jArr11 = new long[19];
                    int i17 = i15;
                    long[] jArr12 = new long[19];
                    int i18 = i12;
                    long[] jArr13 = new long[19];
                    int i19 = i16;
                    long[] jArr14 = new long[19];
                    long[] jArr15 = jArr10;
                    long[] jArr16 = new long[19];
                    long[] jArr17 = new long[19];
                    zzjz.zzi(jArr5, jArr5, jArr6);
                    zzjz.zzh(jArr6, copyOf2, jArr6);
                    long[] copyOf3 = Arrays.copyOf(jArr3, 10);
                    zzjz.zzi(jArr3, jArr3, jArr4);
                    zzjz.zzh(jArr4, copyOf3, jArr4);
                    zzjz.zzb(jArr13, jArr3, jArr6);
                    zzjz.zzb(jArr14, jArr5, jArr4);
                    zzjz.zze(jArr13);
                    zzjz.zzd(jArr13);
                    zzjz.zze(jArr14);
                    zzjz.zzd(jArr14);
                    long[] jArr18 = jArr3;
                    System.arraycopy(jArr13, 0, copyOf3, 0, 10);
                    zzjz.zzi(jArr13, jArr13, jArr14);
                    zzjz.zzh(jArr14, copyOf3, jArr14);
                    zzjz.zzg(jArr17, jArr13);
                    zzjz.zzg(jArr16, jArr14);
                    zzjz.zzb(jArr14, jArr16, zzk);
                    zzjz.zze(jArr14);
                    zzjz.zzd(jArr14);
                    System.arraycopy(jArr17, 0, jArr7, 0, 10);
                    System.arraycopy(jArr14, 0, jArr8, 0, 10);
                    zzjz.zzg(jArr11, jArr5);
                    zzjz.zzg(jArr12, jArr6);
                    zzjz.zzb(jArr9, jArr11, jArr12);
                    zzjz.zze(jArr9);
                    zzjz.zzd(jArr9);
                    zzjz.zzh(jArr12, jArr11, jArr12);
                    long[] jArr19 = new long[19];
                    Arrays.fill(jArr19, 10, 18, 0);
                    zzjz.zzf(jArr19, jArr12, 121665);
                    zzjz.zzd(jArr19);
                    zzjz.zzi(jArr19, jArr19, jArr11);
                    long[] jArr20 = jArr15;
                    zzjz.zzb(jArr20, jArr12, jArr19);
                    zzjz.zze(jArr20);
                    zzjz.zzd(jArr20);
                    int i21 = i19;
                    zzb(jArr9, jArr7, i21);
                    zzb(jArr20, jArr8, i21);
                    i12 = i18 + 1;
                    long[] jArr21 = jArr;
                    byte[] bArr5 = bArr2;
                    jArr3 = jArr7;
                    b11 = b12;
                    i15 = i17;
                    jArr7 = jArr18;
                    i14 = 10;
                    long[] jArr22 = jArr8;
                    jArr8 = jArr4;
                    jArr4 = jArr22;
                    long[] jArr23 = jArr9;
                    jArr9 = jArr5;
                    jArr5 = jArr23;
                    long[] jArr24 = jArr20;
                    jArr10 = jArr6;
                    jArr6 = jArr24;
                }
                long[] jArr25 = jArr3;
                i15++;
                long[] jArr26 = jArr;
                byte[] bArr6 = bArr2;
                i11 = 32;
                i12 = 0;
                i14 = 10;
            }
            int i22 = i14;
            long[] jArr27 = new long[i22];
            long[] jArr28 = new long[i22];
            long[] jArr29 = new long[i22];
            long[] jArr30 = new long[i22];
            long[] jArr31 = new long[i22];
            long[] jArr32 = new long[i22];
            long[] jArr33 = new long[i22];
            long[] jArr34 = new long[i22];
            long[] jArr35 = new long[i22];
            long[] jArr36 = new long[i22];
            long[] jArr37 = jArr3;
            long[] jArr38 = new long[i22];
            zzjz.zzg(jArr28, jArr6);
            zzjz.zzg(jArr38, jArr28);
            zzjz.zzg(jArr36, jArr38);
            zzjz.zza(jArr29, jArr36, jArr6);
            zzjz.zza(jArr30, jArr29, jArr28);
            zzjz.zzg(jArr36, jArr30);
            zzjz.zza(jArr31, jArr36, jArr29);
            zzjz.zzg(jArr36, jArr31);
            zzjz.zzg(jArr38, jArr36);
            zzjz.zzg(jArr36, jArr38);
            zzjz.zzg(jArr38, jArr36);
            zzjz.zzg(jArr36, jArr38);
            zzjz.zza(jArr32, jArr36, jArr31);
            zzjz.zzg(jArr36, jArr32);
            zzjz.zzg(jArr38, jArr36);
            for (int i23 = 2; i23 < 10; i23 += 2) {
                zzjz.zzg(jArr36, jArr38);
                zzjz.zzg(jArr38, jArr36);
            }
            zzjz.zza(jArr33, jArr38, jArr32);
            zzjz.zzg(jArr36, jArr33);
            zzjz.zzg(jArr38, jArr36);
            for (int i24 = 2; i24 < 20; i24 += 2) {
                zzjz.zzg(jArr36, jArr38);
                zzjz.zzg(jArr38, jArr36);
            }
            zzjz.zza(jArr36, jArr38, jArr33);
            zzjz.zzg(jArr38, jArr36);
            zzjz.zzg(jArr36, jArr38);
            for (int i25 = 2; i25 < 10; i25 += 2) {
                zzjz.zzg(jArr38, jArr36);
                zzjz.zzg(jArr36, jArr38);
            }
            zzjz.zza(jArr34, jArr36, jArr32);
            zzjz.zzg(jArr36, jArr34);
            zzjz.zzg(jArr38, jArr36);
            for (int i26 = 2; i26 < 50; i26 += 2) {
                zzjz.zzg(jArr36, jArr38);
                zzjz.zzg(jArr38, jArr36);
            }
            zzjz.zza(jArr35, jArr38, jArr34);
            zzjz.zzg(jArr38, jArr35);
            zzjz.zzg(jArr36, jArr38);
            for (int i27 = 2; i27 < 100; i27 += 2) {
                zzjz.zzg(jArr38, jArr36);
                zzjz.zzg(jArr36, jArr38);
            }
            zzjz.zza(jArr38, jArr36, jArr35);
            zzjz.zzg(jArr36, jArr38);
            zzjz.zzg(jArr38, jArr36);
            for (int i28 = 2; i28 < 50; i28 += 2) {
                zzjz.zzg(jArr36, jArr38);
                zzjz.zzg(jArr38, jArr36);
            }
            zzjz.zza(jArr36, jArr38, jArr34);
            zzjz.zzg(jArr38, jArr36);
            zzjz.zzg(jArr36, jArr38);
            zzjz.zzg(jArr38, jArr36);
            zzjz.zzg(jArr36, jArr38);
            zzjz.zzg(jArr38, jArr36);
            zzjz.zza(jArr27, jArr38, jArr30);
            long[] jArr39 = jArr;
            zzjz.zza(jArr39, jArr5, jArr27);
            long[] jArr40 = new long[10];
            long[] jArr41 = new long[10];
            long[] jArr42 = new long[11];
            long[] jArr43 = new long[11];
            long[] jArr44 = new long[11];
            zzjz.zza(jArr40, zzk, jArr39);
            zzjz.zzi(jArr41, zzk, jArr39);
            long[] jArr45 = new long[10];
            jArr45[0] = 486662;
            zzjz.zzi(jArr43, jArr41, jArr45);
            zzjz.zza(jArr43, jArr43, jArr4);
            long[] jArr46 = jArr37;
            zzjz.zzi(jArr43, jArr43, jArr46);
            zzjz.zza(jArr43, jArr43, jArr40);
            zzjz.zza(jArr43, jArr43, jArr46);
            zzjz.zzf(jArr42, jArr43, 4);
            zzjz.zzd(jArr42);
            zzjz.zza(jArr43, jArr40, jArr4);
            zzjz.zzh(jArr43, jArr43, jArr4);
            zzjz.zza(jArr44, jArr41, jArr46);
            zzjz.zzi(jArr43, jArr43, jArr44);
            zzjz.zzg(jArr43, jArr43);
            if (!MessageDigest.isEqual(zzjz.zzj(jArr42), zzjz.zzj(jArr43))) {
                throw new IllegalStateException("Arithmetic error in curve multiplication with the public key: ".concat(zzvt.zza(bArr2)));
            }
            return;
        }
        throw new InvalidKeyException("Public key length is not 32-byte");
    }

    public static void zzb(long[] jArr, long[] jArr2, int i11) {
        for (int i12 = 0; i12 < 10; i12++) {
            int i13 = (int) jArr[i12];
            int i14 = (-i11) & (((int) jArr2[i12]) ^ i13);
            jArr[i12] = (long) (i13 ^ i14);
            jArr2[i12] = (long) (i14 ^ ((int) jArr2[i12]));
        }
    }
}
