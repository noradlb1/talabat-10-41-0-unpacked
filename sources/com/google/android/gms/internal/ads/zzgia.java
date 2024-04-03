package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import java.util.Arrays;

final class zzgia {
    public static byte[] zza(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        long zzb = zzb(bArr3, 0, 0);
        long zzb2 = zzb(bArr3, 3, 2) & 67108611;
        long zzb3 = zzb(bArr3, 6, 4) & 67092735;
        long zzb4 = zzb(bArr3, 9, 6) & 66076671;
        long zzb5 = zzb(bArr3, 12, 8) & 1048575;
        long j11 = zzb2 * 5;
        long j12 = zzb3 * 5;
        long j13 = zzb4 * 5;
        long j14 = zzb5 * 5;
        int i11 = 17;
        byte[] bArr5 = new byte[17];
        long j15 = 0;
        int i12 = 0;
        long j16 = 0;
        long j17 = 0;
        long j18 = 0;
        long j19 = 0;
        while (true) {
            int length = bArr4.length;
            if (i12 < length) {
                int min = Math.min(16, length - i12);
                System.arraycopy(bArr4, i12, bArr5, 0, min);
                bArr5[min] = 1;
                if (min != 16) {
                    Arrays.fill(bArr5, min + 1, i11, (byte) 0);
                }
                long zzb6 = j19 + zzb(bArr5, 0, 0);
                long zzb7 = j16 + zzb(bArr5, 3, 2);
                long zzb8 = j15 + zzb(bArr5, 6, 4);
                long zzb9 = j17 + zzb(bArr5, 9, 6);
                long zzb10 = j18 + (zzb(bArr5, 12, 8) | ((long) (bArr5[16] << Ascii.CAN)));
                long j21 = (zzb6 * zzb) + (zzb7 * j14) + (zzb8 * j13) + (zzb9 * j12) + (zzb10 * j11);
                long j22 = (zzb6 * zzb2) + (zzb7 * zzb) + (zzb8 * j14) + (zzb9 * j13) + (zzb10 * j12) + (j21 >> 26);
                long j23 = (zzb6 * zzb3) + (zzb7 * zzb2) + (zzb8 * zzb) + (zzb9 * j14) + (zzb10 * j13) + (j22 >> 26);
                long j24 = (zzb6 * zzb4) + (zzb7 * zzb3) + (zzb8 * zzb2) + (zzb9 * zzb) + (zzb10 * j14) + (j23 >> 26);
                long j25 = (zzb6 * zzb5) + (zzb7 * zzb4) + (zzb8 * zzb3) + (zzb9 * zzb2) + (zzb10 * zzb) + (j24 >> 26);
                j18 = j25 & 67108863;
                long j26 = (j21 & 67108863) + ((j25 >> 26) * 5);
                j19 = j26 & 67108863;
                j16 = (j22 & 67108863) + (j26 >> 26);
                i12 += 16;
                j17 = j24 & 67108863;
                j15 = j23 & 67108863;
                i11 = 17;
            } else {
                long j27 = j15 + (j16 >> 26);
                long j28 = j27 & 67108863;
                long j29 = j17 + (j27 >> 26);
                long j31 = j29 & 67108863;
                long j32 = j18 + (j29 >> 26);
                long j33 = j32 & 67108863;
                long j34 = j19 + ((j32 >> 26) * 5);
                long j35 = j34 & 67108863;
                long j36 = (j16 & 67108863) + (j34 >> 26);
                long j37 = j35 + 5;
                long j38 = (j37 >> 26) + j36;
                long j39 = j28 + (j38 >> 26);
                long j41 = j31 + (j39 >> 26);
                long j42 = (j33 + (j41 >> 26)) - 67108864;
                long j43 = j42 >> 63;
                long j44 = ~j43;
                long j45 = (j36 & j43) | (j38 & 67108863 & j44);
                long j46 = (j28 & j43) | (j39 & 67108863 & j44);
                long j47 = (j31 & j43) | (j41 & 67108863 & j44);
                long zzc = (((j35 & j43) | (j37 & 67108863 & j44) | (j45 << 26)) & 4294967295L) + zzc(bArr3, 16);
                long zzc2 = (((j45 >> 6) | (j46 << 20)) & 4294967295L) + zzc(bArr3, 20) + (zzc >> 32);
                long zzc3 = (((j46 >> 12) | (j47 << 14)) & 4294967295L) + zzc(bArr3, 24) + (zzc2 >> 32);
                long zzc4 = zzc(bArr3, 28);
                byte[] bArr6 = new byte[16];
                zzd(bArr6, zzc & 4294967295L, 0);
                zzd(bArr6, zzc2 & 4294967295L, 4);
                zzd(bArr6, zzc3 & 4294967295L, 8);
                zzd(bArr6, ((((((j42 & j44) | (j33 & j43)) << 8) | (j47 >> 18)) & 4294967295L) + zzc4 + (zzc3 >> 32)) & 4294967295L, 12);
                return bArr6;
            }
        }
    }

    private static long zzb(byte[] bArr, int i11, int i12) {
        return (zzc(bArr, i11) >> i12) & 67108863;
    }

    private static long zzc(byte[] bArr, int i11) {
        return ((long) (((bArr[i11 + 3] & 255) << Ascii.CAN) | (bArr[i11] & 255) | ((bArr[i11 + 1] & 255) << 8) | ((bArr[i11 + 2] & 255) << Ascii.DLE))) & 4294967295L;
    }

    private static void zzd(byte[] bArr, long j11, int i11) {
        int i12 = 0;
        while (i12 < 4) {
            bArr[i11 + i12] = (byte) ((int) (255 & j11));
            i12++;
            j11 >>= 8;
        }
    }
}
