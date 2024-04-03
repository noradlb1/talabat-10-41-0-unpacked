package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.common.base.Ascii;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhg  reason: invalid package */
public final class zzhg {
    public static byte[] zza(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        long zzb = zzb(bArr3, 0, 0);
        long zzb2 = zzb(bArr3, 3, 2) & 67108611;
        long zzb3 = zzb(bArr3, 6, 4) & 67092735;
        long zzb4 = zzb(bArr3, 9, 6) & 66076671;
        long zzb5 = zzb(bArr3, 12, 8) & 1048575;
        int i11 = 17;
        byte[] bArr5 = new byte[17];
        long j11 = 0;
        int i12 = 0;
        long j12 = 0;
        long j13 = 0;
        long j14 = 0;
        long j15 = 0;
        while (true) {
            int length = bArr4.length;
            if (i12 < length) {
                int min = Math.min(16, length - i12);
                System.arraycopy(bArr4, i12, bArr5, 0, min);
                bArr5[min] = 1;
                if (min != 16) {
                    Arrays.fill(bArr5, min + 1, i11, (byte) 0);
                }
                long j16 = zzb5 * 5;
                long j17 = zzb4 * 5;
                long j18 = zzb3 * 5;
                long zzb6 = j15 + zzb(bArr5, 0, 0);
                long zzb7 = j12 + zzb(bArr5, 3, 2);
                long zzb8 = j11 + zzb(bArr5, 6, 4);
                long zzb9 = j13 + zzb(bArr5, 9, 6);
                long zzb10 = j14 + (zzb(bArr5, 12, 8) | ((long) (bArr5[16] << Ascii.CAN)));
                long j19 = zzb7 * zzb;
                long j21 = zzb7 * zzb2;
                long j22 = zzb7 * zzb3;
                long j23 = zzb9 * zzb;
                long j24 = zzb7 * zzb4;
                long j25 = zzb10 * zzb;
                long j26 = (zzb6 * zzb) + (zzb7 * j16) + (zzb8 * j17) + (zzb9 * j18) + (zzb2 * 5 * zzb10);
                long j27 = (zzb6 * zzb2) + j19 + (zzb8 * j16) + (zzb9 * j17) + (j18 * zzb10) + (j26 >> 26);
                long j28 = (zzb6 * zzb3) + j21 + (zzb8 * zzb) + (zzb9 * j16) + (j17 * zzb10) + (j27 >> 26);
                long j29 = (zzb6 * zzb4) + j22 + (zzb8 * zzb2) + j23 + (zzb10 * j16) + (j28 >> 26);
                long j31 = (zzb6 * zzb5) + j24 + (zzb8 * zzb3) + (zzb9 * zzb2) + j25 + (j29 >> 26);
                long j32 = (j26 & 67108863) + ((j31 >> 26) * 5);
                j12 = (j27 & 67108863) + (j32 >> 26);
                i12 += 16;
                j11 = j28 & 67108863;
                j13 = j29 & 67108863;
                j14 = j31 & 67108863;
                i11 = 17;
                j15 = j32 & 67108863;
            } else {
                long j33 = j11 + (j12 >> 26);
                long j34 = j33 & 67108863;
                long j35 = j13 + (j33 >> 26);
                long j36 = j35 & 67108863;
                long j37 = j14 + (j35 >> 26);
                long j38 = j37 & 67108863;
                long j39 = j15 + ((j37 >> 26) * 5);
                long j41 = j39 & 67108863;
                long j42 = j41 + 5;
                long j43 = (j12 & 67108863) + (j39 >> 26);
                long j44 = j43 + (j42 >> 26);
                long j45 = (j44 >> 26) + j34;
                long j46 = j36 + (j45 >> 26);
                long j47 = (j38 + (j46 >> 26)) - 67108864;
                long j48 = j47 >> 63;
                long j49 = ~j48;
                long j50 = (j43 & j48) | (j44 & 67108863 & j49);
                long j51 = (j34 & j48) | (j45 & 67108863 & j49);
                long j52 = (j36 & j48) | (j46 & 67108863 & j49);
                long j53 = (j38 & j48) | (j47 & j49);
                long zzc = (((j48 & j41) | (j42 & 67108863 & j49) | (j50 << 26)) & 4294967295L) + zzc(bArr3, 16);
                long zzc2 = (((j50 >> 6) | (j51 << 20)) & 4294967295L) + zzc(bArr3, 20);
                long zzc3 = (((j51 >> 12) | (j52 << 14)) & 4294967295L) + zzc(bArr3, 24);
                long zzc4 = (((j52 >> 18) | (j53 << 8)) & 4294967295L) + zzc(bArr3, 28);
                byte[] bArr6 = new byte[16];
                zzd(bArr6, zzc & 4294967295L, 0);
                long j54 = zzc2 + (zzc >> 32);
                zzd(bArr6, j54 & 4294967295L, 4);
                long j55 = zzc3 + (j54 >> 32);
                zzd(bArr6, j55 & 4294967295L, 8);
                zzd(bArr6, (zzc4 + (j55 >> 32)) & 4294967295L, 12);
                return bArr6;
            }
        }
    }

    private static long zzb(byte[] bArr, int i11, int i12) {
        return (zzc(bArr, i11) >> i12) & 67108863;
    }

    private static long zzc(byte[] bArr, int i11) {
        int i12 = (bArr[i11 + 1] & 255) << 8;
        return ((long) (((bArr[i11 + 3] & 255) << Ascii.CAN) | i12 | (bArr[i11] & 255) | ((bArr[i11 + 2] & 255) << Ascii.DLE))) & 4294967295L;
    }

    private static void zzd(byte[] bArr, long j11, int i11) {
        for (int i12 = 0; i12 < 4; i12++) {
            bArr[i11 + i12] = (byte) ((int) (255 & j11));
            j11 >>= 8;
        }
    }
}
