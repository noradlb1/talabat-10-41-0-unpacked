package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.BloomFilter;
import com.google.common.math.LongMath;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLongArray;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
enum BloomFilterStrategies implements BloomFilter.Strategy {
    MURMUR128_MITZ_32 {
        public <T> boolean mightContain(@ParametricNullness T t11, Funnel<? super T> funnel, int i11, LockFreeBitArray lockFreeBitArray) {
            long bitSize = lockFreeBitArray.bitSize();
            long asLong = Hashing.murmur3_128().hashObject(t11, funnel).asLong();
            int i12 = (int) asLong;
            int i13 = (int) (asLong >>> 32);
            for (int i14 = 1; i14 <= i11; i14++) {
                int i15 = (i14 * i13) + i12;
                if (i15 < 0) {
                    i15 = ~i15;
                }
                if (!lockFreeBitArray.get(((long) i15) % bitSize)) {
                    return false;
                }
            }
            return true;
        }

        public <T> boolean put(@ParametricNullness T t11, Funnel<? super T> funnel, int i11, LockFreeBitArray lockFreeBitArray) {
            long bitSize = lockFreeBitArray.bitSize();
            long asLong = Hashing.murmur3_128().hashObject(t11, funnel).asLong();
            int i12 = (int) asLong;
            int i13 = (int) (asLong >>> 32);
            boolean z11 = false;
            for (int i14 = 1; i14 <= i11; i14++) {
                int i15 = (i14 * i13) + i12;
                if (i15 < 0) {
                    i15 = ~i15;
                }
                z11 |= lockFreeBitArray.set(((long) i15) % bitSize);
            }
            return z11;
        }
    },
    MURMUR128_MITZ_64 {
        private long lowerEight(byte[] bArr) {
            return Longs.fromBytes(bArr[7], bArr[6], bArr[5], bArr[4], bArr[3], bArr[2], bArr[1], bArr[0]);
        }

        private long upperEight(byte[] bArr) {
            return Longs.fromBytes(bArr[15], bArr[14], bArr[13], bArr[12], bArr[11], bArr[10], bArr[9], bArr[8]);
        }

        public <T> boolean mightContain(@ParametricNullness T t11, Funnel<? super T> funnel, int i11, LockFreeBitArray lockFreeBitArray) {
            long bitSize = lockFreeBitArray.bitSize();
            byte[] bytesInternal = Hashing.murmur3_128().hashObject(t11, funnel).getBytesInternal();
            long lowerEight = lowerEight(bytesInternal);
            long upperEight = upperEight(bytesInternal);
            for (int i12 = 0; i12 < i11; i12++) {
                if (!lockFreeBitArray.get((Long.MAX_VALUE & lowerEight) % bitSize)) {
                    return false;
                }
                lowerEight += upperEight;
            }
            return true;
        }

        public <T> boolean put(@ParametricNullness T t11, Funnel<? super T> funnel, int i11, LockFreeBitArray lockFreeBitArray) {
            long bitSize = lockFreeBitArray.bitSize();
            byte[] bytesInternal = Hashing.murmur3_128().hashObject(t11, funnel).getBytesInternal();
            long lowerEight = lowerEight(bytesInternal);
            long upperEight = upperEight(bytesInternal);
            boolean z11 = false;
            for (int i12 = 0; i12 < i11; i12++) {
                z11 |= lockFreeBitArray.set((Long.MAX_VALUE & lowerEight) % bitSize);
                lowerEight += upperEight;
            }
            return z11;
        }
    };

    public static final class LockFreeBitArray {
        private static final int LONG_ADDRESSABLE_BITS = 6;
        private final LongAddable bitCount;
        final AtomicLongArray data;

        public LockFreeBitArray(long j11) {
            Preconditions.checkArgument(j11 > 0, "data length is zero!");
            this.data = new AtomicLongArray(Ints.checkedCast(LongMath.divide(j11, 64, RoundingMode.CEILING)));
            this.bitCount = LongAddables.create();
        }

        public static long[] toPlainArray(AtomicLongArray atomicLongArray) {
            int length = atomicLongArray.length();
            long[] jArr = new long[length];
            for (int i11 = 0; i11 < length; i11++) {
                jArr[i11] = atomicLongArray.get(i11);
            }
            return jArr;
        }

        public long bitCount() {
            return this.bitCount.sum();
        }

        public long bitSize() {
            return ((long) this.data.length()) * 64;
        }

        public LockFreeBitArray copy() {
            return new LockFreeBitArray(toPlainArray(this.data));
        }

        public int dataLength() {
            return this.data.length();
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof LockFreeBitArray) {
                return Arrays.equals(toPlainArray(this.data), toPlainArray(((LockFreeBitArray) obj).data));
            }
            return false;
        }

        public boolean get(long j11) {
            return ((1 << ((int) j11)) & this.data.get((int) (j11 >>> 6))) != 0;
        }

        public int hashCode() {
            return Arrays.hashCode(toPlainArray(this.data));
        }

        public void putAll(LockFreeBitArray lockFreeBitArray) {
            boolean z11;
            if (this.data.length() == lockFreeBitArray.data.length()) {
                z11 = true;
            } else {
                z11 = false;
            }
            Preconditions.checkArgument(z11, "BitArrays must be of equal length (%s != %s)", this.data.length(), lockFreeBitArray.data.length());
            for (int i11 = 0; i11 < this.data.length(); i11++) {
                putData(i11, lockFreeBitArray.data.get(i11));
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void putData(int r12, long r13) {
            /*
                r11 = this;
            L_0x0000:
                java.util.concurrent.atomic.AtomicLongArray r0 = r11.data
                long r7 = r0.get(r12)
                long r9 = r7 | r13
                int r0 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
                if (r0 != 0) goto L_0x000e
                r12 = 0
                goto L_0x001a
            L_0x000e:
                java.util.concurrent.atomic.AtomicLongArray r1 = r11.data
                r2 = r12
                r3 = r7
                r5 = r9
                boolean r0 = r1.compareAndSet(r2, r3, r5)
                if (r0 == 0) goto L_0x0000
                r12 = 1
            L_0x001a:
                if (r12 == 0) goto L_0x002b
                int r12 = java.lang.Long.bitCount(r9)
                int r13 = java.lang.Long.bitCount(r7)
                int r12 = r12 - r13
                com.google.common.hash.LongAddable r13 = r11.bitCount
                long r0 = (long) r12
                r13.add(r0)
            L_0x002b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.hash.BloomFilterStrategies.LockFreeBitArray.putData(int, long):void");
        }

        public boolean set(long j11) {
            long j12;
            long j13;
            if (get(j11)) {
                return false;
            }
            int i11 = (int) (j11 >>> 6);
            long j14 = 1 << ((int) j11);
            do {
                j12 = this.data.get(i11);
                j13 = j12 | j14;
                if (j12 == j13) {
                    return false;
                }
            } while (!this.data.compareAndSet(i11, j12, j13));
            this.bitCount.increment();
            return true;
        }

        public LockFreeBitArray(long[] jArr) {
            Preconditions.checkArgument(jArr.length > 0, "data length is zero!");
            this.data = new AtomicLongArray(jArr);
            this.bitCount = LongAddables.create();
            long j11 = 0;
            for (long bitCount2 : jArr) {
                j11 += (long) Long.bitCount(bitCount2);
            }
            this.bitCount.add(j11);
        }
    }
}
