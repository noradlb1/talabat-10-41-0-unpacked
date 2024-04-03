package com.google.common.hash;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;

@ElementTypesAreNonnullByDefault
final class Fingerprint2011 extends AbstractNonStreamingHashFunction {
    static final HashFunction FINGERPRINT_2011 = new Fingerprint2011();
    private static final long K0 = -6505348102511208375L;
    private static final long K1 = -8261664234251669945L;
    private static final long K2 = -4288712594273399085L;
    private static final long K3 = -4132994306676758123L;

    @VisibleForTesting
    public static long fingerprint(byte[] bArr, int i11, int i12) {
        long j11;
        long j12;
        if (i12 <= 32) {
            j11 = murmurHash64WithSeed(bArr, i11, i12, -1397348546323613475L);
        } else if (i12 <= 64) {
            j11 = hashLength33To64(bArr, i11, i12);
        } else {
            j11 = fullFingerprint(bArr, i11, i12);
        }
        long j13 = K0;
        if (i12 >= 8) {
            j12 = LittleEndianByteArray.load64(bArr, i11);
        } else {
            j12 = -6505348102511208375L;
        }
        if (i12 >= 9) {
            j13 = LittleEndianByteArray.load64(bArr, (i11 + i12) - 8);
        }
        long hash128to64 = hash128to64(j11 + j13, j12);
        if (hash128to64 == 0 || hash128to64 == 1) {
            return hash128to64 - 2;
        }
        return hash128to64;
    }

    private static long fullFingerprint(byte[] bArr, int i11, int i12) {
        byte[] bArr2 = bArr;
        int i13 = i12;
        long load64 = LittleEndianByteArray.load64(bArr, i11);
        int i14 = i11 + i13;
        long load642 = LittleEndianByteArray.load64(bArr2, i14 - 16) ^ K1;
        long load643 = LittleEndianByteArray.load64(bArr2, i14 - 56) ^ K0;
        long[] jArr = new long[2];
        long j11 = (long) i13;
        byte[] bArr3 = bArr;
        long[] jArr2 = new long[2];
        long[] jArr3 = jArr;
        weakHashLength32WithSeeds(bArr3, i14 - 64, j11, load642, jArr);
        weakHashLength32WithSeeds(bArr3, i14 - 32, j11 * K1, K0, jArr2);
        long shiftMix = load643 + (shiftMix(jArr3[1]) * K1);
        long rotateRight = Long.rotateRight(shiftMix + load64, 39) * K1;
        long rotateRight2 = Long.rotateRight(load642, 33) * K1;
        int i15 = i11;
        int i16 = (i13 - 1) & -64;
        while (true) {
            long rotateRight3 = Long.rotateRight(rotateRight + rotateRight2 + jArr3[0] + LittleEndianByteArray.load64(bArr2, i15 + 16), 37) * K1;
            long rotateRight4 = Long.rotateRight(rotateRight2 + jArr3[1] + LittleEndianByteArray.load64(bArr2, i15 + 48), 42) * K1;
            long j12 = rotateRight3 ^ jArr2[1];
            long j13 = rotateRight4 ^ jArr3[0];
            long rotateRight5 = Long.rotateRight(shiftMix ^ jArr2[0], 33);
            byte[] bArr4 = bArr;
            weakHashLength32WithSeeds(bArr4, i15, jArr3[1] * K1, j12 + jArr2[0], jArr3);
            weakHashLength32WithSeeds(bArr4, i15 + 32, jArr2[1] + rotateRight5, j13, jArr2);
            i15 += 64;
            i16 -= 64;
            if (i16 == 0) {
                return hash128to64(hash128to64(jArr3[0], jArr2[0]) + (shiftMix(j13) * K1) + j12, hash128to64(jArr3[1], jArr2[1]) + rotateRight5);
            }
            rotateRight = rotateRight5;
            shiftMix = j12;
            rotateRight2 = j13;
        }
    }

    @VisibleForTesting
    public static long hash128to64(long j11, long j12) {
        long j13 = (j12 ^ j11) * K3;
        long j14 = (j11 ^ (j13 ^ (j13 >>> 47))) * K3;
        return (j14 ^ (j14 >>> 47)) * K3;
    }

    private static long hashLength33To64(byte[] bArr, int i11, int i12) {
        byte[] bArr2 = bArr;
        int i13 = i12;
        long load64 = LittleEndianByteArray.load64(bArr2, i11 + 24);
        long j11 = (long) i13;
        int i14 = i11 + i13;
        int i15 = i14 - 16;
        long load642 = LittleEndianByteArray.load64(bArr, i11) + ((j11 + LittleEndianByteArray.load64(bArr2, i15)) * K0);
        long rotateRight = Long.rotateRight(load642 + load64, 52);
        long rotateRight2 = Long.rotateRight(load642, 37);
        long load643 = load642 + LittleEndianByteArray.load64(bArr2, i11 + 8);
        int i16 = i11 + 16;
        long load644 = load643 + LittleEndianByteArray.load64(bArr2, i16);
        long j12 = load64 + load644;
        long rotateRight3 = rotateRight + Long.rotateRight(load644, 31) + rotateRight2 + Long.rotateRight(load643, 7);
        long load645 = LittleEndianByteArray.load64(bArr2, i16) + LittleEndianByteArray.load64(bArr2, i14 - 32);
        long load646 = LittleEndianByteArray.load64(bArr2, i14 - 8);
        long j13 = rotateRight3;
        long rotateRight4 = Long.rotateRight(load645 + load646, 52);
        long rotateRight5 = Long.rotateRight(load645, 37);
        long load647 = load645 + LittleEndianByteArray.load64(bArr2, i14 - 24);
        long load648 = load647 + LittleEndianByteArray.load64(bArr2, i15);
        long rotateRight6 = rotateRight4 + Long.rotateRight(load648, 31);
        long j14 = j13;
        return shiftMix((shiftMix(((j12 + rotateRight6 + rotateRight5 + Long.rotateRight(load647, 7)) * K2) + ((load646 + load648 + j14) * K0)) * K0) + j14) * K2;
    }

    @VisibleForTesting
    public static long murmurHash64WithSeed(byte[] bArr, int i11, int i12, long j11) {
        int i13 = i12 & -8;
        int i14 = i12 & 7;
        long j12 = j11 ^ (((long) i12) * K3);
        for (int i15 = 0; i15 < i13; i15 += 8) {
            j12 = (j12 ^ (shiftMix(LittleEndianByteArray.load64(bArr, i11 + i15) * K3) * K3)) * K3;
        }
        if (i14 != 0) {
            j12 = (LittleEndianByteArray.load64Safely(bArr, i11 + i13, i14) ^ j12) * K3;
        }
        return shiftMix(shiftMix(j12) * K3);
    }

    private static long shiftMix(long j11) {
        return j11 ^ (j11 >>> 47);
    }

    private static void weakHashLength32WithSeeds(byte[] bArr, int i11, long j11, long j12, long[] jArr) {
        long load64 = LittleEndianByteArray.load64(bArr, i11);
        long load642 = LittleEndianByteArray.load64(bArr, i11 + 8);
        long load643 = LittleEndianByteArray.load64(bArr, i11 + 16);
        long load644 = LittleEndianByteArray.load64(bArr, i11 + 24);
        long j13 = j11 + load64;
        long j14 = load642 + j13 + load643;
        jArr[0] = j14 + load644;
        jArr[1] = Long.rotateRight(j12 + j13 + load644, 51) + Long.rotateRight(j14, 23) + j13;
    }

    public int bits() {
        return 64;
    }

    public HashCode hashBytes(byte[] bArr, int i11, int i12) {
        Preconditions.checkPositionIndexes(i11, i11 + i12, bArr.length);
        return HashCode.fromLong(fingerprint(bArr, i11, i12));
    }

    public String toString() {
        return "Hashing.fingerprint2011()";
    }
}
