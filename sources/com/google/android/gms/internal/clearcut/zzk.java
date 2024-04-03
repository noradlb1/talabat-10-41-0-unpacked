package com.google.android.gms.internal.clearcut;

import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class zzk {
    private static int zza(byte[] bArr, int i11) {
        return ((bArr[i11 + 3] & 255) << Ascii.CAN) | (bArr[i11] & 255) | ((bArr[i11 + 1] & 255) << 8) | ((bArr[i11 + 2] & 255) << Ascii.DLE);
    }

    private static long zza(long j11, long j12, long j13) {
        long j14 = (j11 ^ j12) * j13;
        long j15 = ((j14 ^ (j14 >>> 47)) ^ j12) * j13;
        return (j15 ^ (j15 >>> 47)) * j13;
    }

    public static long zza(byte[] bArr) {
        byte[] bArr2 = bArr;
        int length = bArr2.length;
        if (length < 0 || length > bArr2.length) {
            StringBuilder sb2 = new StringBuilder(67);
            sb2.append("Out of bound index with offput: 0 and length: ");
            sb2.append(length);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        int i11 = 37;
        if (length <= 32) {
            if (length > 16) {
                long j11 = ((long) (length << 1)) - 7286425919675154353L;
                long zzb = zzb(bArr2, 0) * -5435081209227447693L;
                long zzb2 = zzb(bArr2, 8);
                int i12 = length + 0;
                long zzb3 = zzb(bArr2, i12 - 8) * j11;
                return zza(Long.rotateRight(zzb + zzb2, 43) + Long.rotateRight(zzb3, 30) + (zzb(bArr2, i12 - 16) * -7286425919675154353L), zzb + Long.rotateRight(zzb2 - 7286425919675154353L, 18) + zzb3, j11);
            } else if (length >= 8) {
                long j12 = ((long) (length << 1)) - 7286425919675154353L;
                long zzb4 = zzb(bArr2, 0) - 7286425919675154353L;
                long zzb5 = zzb(bArr2, (length + 0) - 8);
                return zza((Long.rotateRight(zzb5, 37) * j12) + zzb4, (Long.rotateRight(zzb4, 25) + zzb5) * j12, j12);
            } else if (length >= 4) {
                return zza(((long) length) + ((((long) zza(bArr2, 0)) & 4294967295L) << 3), ((long) zza(bArr2, (length + 0) - 4)) & 4294967295L, ((long) (length << 1)) - 7286425919675154353L);
            } else if (length <= 0) {
                return -7286425919675154353L;
            } else {
                long j13 = (((long) ((bArr2[0] & 255) + ((bArr2[(length >> 1) + 0] & 255) << 8))) * -7286425919675154353L) ^ (((long) (length + ((bArr2[(length - 1) + 0] & 255) << 2))) * -4348849565147123417L);
                return (j13 ^ (j13 >>> 47)) * -7286425919675154353L;
            }
        } else if (length <= 64) {
            long j14 = ((long) (length << 1)) - 7286425919675154353L;
            long zzb6 = zzb(bArr2, 0) * -7286425919675154353L;
            long zzb7 = zzb(bArr2, 8);
            int i13 = length + 0;
            long zzb8 = zzb(bArr2, i13 - 8) * j14;
            long rotateRight = Long.rotateRight(zzb6 + zzb7, 43) + Long.rotateRight(zzb8, 30) + (zzb(bArr2, i13 - 16) * -7286425919675154353L);
            long j15 = j14;
            long zza = zza(rotateRight, Long.rotateRight(-7286425919675154353L + zzb7, 18) + zzb6 + zzb8, j15);
            byte[] bArr3 = bArr;
            long zzb9 = zzb(bArr3, 16) * j14;
            long zzb10 = zzb(bArr3, 24);
            long j16 = zzb6;
            long zzb11 = (rotateRight + zzb(bArr3, i13 - 32)) * j14;
            return zza(Long.rotateRight(zzb9 + zzb10, 43) + Long.rotateRight(zzb11, 30) + ((zza + zzb(bArr3, i13 - 24)) * j14), zzb9 + Long.rotateRight(zzb10 + j16, 18) + zzb11, j15);
        } else {
            long[] jArr = new long[2];
            long[] jArr2 = new long[2];
            long zzb12 = zzb(bArr2, 0) + 95310865018149119L;
            int i14 = length - 1;
            int i15 = ((i14 / 64) << 6) + 0;
            int i16 = i14 & 63;
            int i17 = (i15 + i16) - 63;
            long j17 = 2480279821605975764L;
            long j18 = 1390051526045402406L;
            int i18 = 0;
            while (true) {
                long rotateRight2 = (Long.rotateRight(((zzb12 + j17) + jArr[0]) + zzb(bArr2, i18 + 8), i11) * -5435081209227447693L) ^ jArr2[1];
                long rotateRight3 = (Long.rotateRight(j17 + jArr[1] + zzb(bArr2, i18 + 48), 42) * -5435081209227447693L) + jArr[0] + zzb(bArr2, i18 + 40);
                long rotateRight4 = Long.rotateRight(j18 + jArr2[0], 33) * -5435081209227447693L;
                int i19 = i16;
                int i21 = i15;
                zza(bArr, i18, jArr[1] * -5435081209227447693L, rotateRight2 + jArr2[0], jArr);
                zza(bArr, i18 + 32, rotateRight4 + jArr2[1], rotateRight3 + zzb(bArr2, i18 + 16), jArr2);
                int i22 = i18 + 64;
                if (i22 == i21) {
                    long j19 = ((rotateRight2 & 255) << 1) - 5435081209227447693L;
                    long j21 = jArr2[0] + ((long) i19);
                    jArr2[0] = j21;
                    long j22 = jArr[0] + j21;
                    jArr[0] = j22;
                    jArr2[0] = jArr2[0] + j22;
                    long rotateRight5 = (Long.rotateRight(((rotateRight4 + rotateRight3) + jArr[0]) + zzb(bArr2, i17 + 8), 37) * j19) ^ (jArr2[1] * 9);
                    long rotateRight6 = (Long.rotateRight(rotateRight3 + jArr[1] + zzb(bArr2, i17 + 48), 42) * j19) + (jArr[0] * 9) + zzb(bArr2, i17 + 40);
                    long rotateRight7 = Long.rotateRight(rotateRight2 + jArr2[0], 33) * j19;
                    zza(bArr, i17, jArr[1] * j19, rotateRight5 + jArr2[0], jArr);
                    zza(bArr, i17 + 32, rotateRight7 + jArr2[1], zzb(bArr2, i17 + 16) + rotateRight6, jArr2);
                    long j23 = j19;
                    return zza(zza(jArr[0], jArr2[0], j23) + (((rotateRight6 >>> 47) ^ rotateRight6) * -4348849565147123417L) + rotateRight5, zza(jArr[1], jArr2[1], j23) + rotateRight7, j23);
                }
                i18 = i22;
                i15 = i21;
                i16 = i19;
                zzb12 = rotateRight4;
                j18 = rotateRight2;
                j17 = rotateRight3;
                i11 = 37;
            }
        }
    }

    private static void zza(byte[] bArr, int i11, long j11, long j12, long[] jArr) {
        long zzb = zzb(bArr, i11);
        long zzb2 = zzb(bArr, i11 + 8);
        long zzb3 = zzb(bArr, i11 + 16);
        long zzb4 = zzb(bArr, i11 + 24);
        long j13 = j11 + zzb;
        long j14 = zzb2 + j13 + zzb3;
        jArr[0] = j14 + zzb4;
        jArr[1] = Long.rotateRight(j12 + j13 + zzb4, 21) + Long.rotateRight(j14, 44) + j13;
    }

    private static long zzb(byte[] bArr, int i11) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr, i11, 8);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        return wrap.getLong();
    }
}
