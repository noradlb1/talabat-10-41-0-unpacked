package com.google.common.math;

import com.google.android.exoplayer2.C;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.tagmanager.ModuleDescriptor;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Longs;
import com.google.common.primitives.UnsignedLongs;
import com.huawei.hms.flutter.map.constants.Param;
import java.math.RoundingMode;
import net.bytebuddy.jar.asm.Opcodes;
import okhttp3.internal.connection.RealConnection;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class LongMath {
    @VisibleForTesting
    static final long FLOOR_SQRT_MAX_LONG = 3037000499L;
    @VisibleForTesting
    static final long MAX_POWER_OF_SQRT2_UNSIGNED = -5402926248376769404L;
    @VisibleForTesting
    static final long MAX_SIGNED_POWER_OF_TWO = 4611686018427387904L;
    private static final int SIEVE_30 = -545925251;
    static final int[] biggestBinomials = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 3810779, 121977, 16175, 4337, 1733, 887, 534, 361, 265, 206, Opcodes.RET, Opcodes.D2L, 125, 111, 101, 94, 88, 83, 79, 76, 74, 72, 70, 69, 68, 67, 67, 66, 66, 66, 66};
    @VisibleForTesting
    static final int[] biggestSimpleBinomials = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 2642246, 86251, 11724, 3218, 1313, 684, 419, 287, ModuleDescriptor.MODULE_VERSION, Opcodes.RET, Opcodes.F2I, 119, 105, 95, 87, 81, 76, 73, 70, 68, 66, 64, 63, 62, 62, 61, 61, 61};
    static final long[] factorials = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600, 6227020800L, 87178291200L, 1307674368000L, 20922789888000L, 355687428096000L, 6402373705728000L, 121645100408832000L, 2432902008176640000L};
    @GwtIncompatible
    @J2ktIncompatible
    @VisibleForTesting
    static final long[] halfPowersOf10 = {3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, 3162277660L, 31622776601L, 316227766016L, 3162277660168L, 31622776601683L, 316227766016837L, 3162277660168379L, 31622776601683793L, 316227766016837933L, 3162277660168379331L};
    @VisibleForTesting
    static final byte[] maxLog10ForLeadingZeros = {19, Ascii.DC2, Ascii.DC2, Ascii.DC2, Ascii.DC2, 17, 17, 17, Ascii.DLE, Ascii.DLE, Ascii.DLE, Ascii.SI, Ascii.SI, Ascii.SI, Ascii.SI, Ascii.SO, Ascii.SO, Ascii.SO, Ascii.CR, Ascii.CR, Ascii.CR, 12, 12, 12, 12, 11, 11, 11, 10, 10, 10, 9, 9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0};
    private static final long[][] millerRabinBaseSets = {new long[]{291830, 126401071349994536L}, new long[]{885594168, 725270293939359937L, 3569819667048198375L}, new long[]{273919523040L, 15, 7363882082L, 992620450144556L}, new long[]{47636622961200L, 2, 2570940, 211991001, 3749873356L}, new long[]{7999252175582850L, 2, 4130806001517L, 149795463772692060L, 186635894390467037L, 3967304179347715805L}, new long[]{585226005592931976L, 2, 123635709730000L, 9233062284813009L, 43835965440333360L, 761179012939631437L, 1263739024124850375L}, new long[]{Long.MAX_VALUE, 2, 325, 9375, 28178, 450775, 9780504, 1795265022}};
    @GwtIncompatible
    @J2ktIncompatible
    @VisibleForTesting
    static final long[] powersOf10 = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, C.NANOS_PER_SECOND, RealConnection.IDLE_CONNECTION_HEALTHY_NS, 100000000000L, MediaPeriodQueue.INITIAL_RENDERER_POSITION_OFFSET_US, 10000000000000L, 100000000000000L, 1000000000000000L, 10000000000000000L, 100000000000000000L, 1000000000000000000L};

    /* renamed from: com.google.common.math.LongMath$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$math$RoundingMode;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                java.math.RoundingMode[] r0 = java.math.RoundingMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$java$math$RoundingMode = r0
                java.math.RoundingMode r1 = java.math.RoundingMode.UNNECESSARY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x001d }
                java.math.RoundingMode r1 = java.math.RoundingMode.DOWN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x0028 }
                java.math.RoundingMode r1 = java.math.RoundingMode.FLOOR     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x0033 }
                java.math.RoundingMode r1 = java.math.RoundingMode.UP     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x003e }
                java.math.RoundingMode r1 = java.math.RoundingMode.CEILING     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x0049 }
                java.math.RoundingMode r1 = java.math.RoundingMode.HALF_DOWN     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x0054 }
                java.math.RoundingMode r1 = java.math.RoundingMode.HALF_UP     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x0060 }
                java.math.RoundingMode r1 = java.math.RoundingMode.HALF_EVEN     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.LongMath.AnonymousClass1.<clinit>():void");
        }
    }

    public enum MillerRabinTester {
        SMALL {
            public long mulMod(long j11, long j12, long j13) {
                return (j11 * j12) % j13;
            }

            public long squareMod(long j11, long j12) {
                return (j11 * j11) % j12;
            }
        },
        LARGE {
            private long plusMod(long j11, long j12, long j13) {
                int i11 = (j11 > (j13 - j12) ? 1 : (j11 == (j13 - j12) ? 0 : -1));
                long j14 = j11 + j12;
                return i11 >= 0 ? j14 - j13 : j14;
            }

            private long times2ToThe32Mod(long j11, long j12) {
                int i11 = 32;
                do {
                    int min = Math.min(i11, Long.numberOfLeadingZeros(j11));
                    j11 = UnsignedLongs.remainder(j11 << min, j12);
                    i11 -= min;
                } while (i11 > 0);
                return j11;
            }

            public long mulMod(long j11, long j12, long j13) {
                long j14 = j13;
                long j15 = j11 >>> 32;
                long j16 = j12 >>> 32;
                long j17 = j11 & 4294967295L;
                long j18 = j12 & 4294967295L;
                long times2ToThe32Mod = times2ToThe32Mod(j15 * j16, j14) + (j15 * j18);
                if (times2ToThe32Mod < 0) {
                    times2ToThe32Mod = UnsignedLongs.remainder(times2ToThe32Mod, j14);
                }
                Long.signum(j17);
                return plusMod(times2ToThe32Mod(times2ToThe32Mod + (j16 * j17), j14), UnsignedLongs.remainder(j17 * j18, j14), j13);
            }

            public long squareMod(long j11, long j12) {
                long j13 = j11 >>> 32;
                long j14 = j11 & 4294967295L;
                long times2ToThe32Mod = times2ToThe32Mod(j13 * j13, j12);
                long j15 = j13 * j14 * 2;
                if (j15 < 0) {
                    j15 = UnsignedLongs.remainder(j15, j12);
                }
                return plusMod(times2ToThe32Mod(times2ToThe32Mod + j15, j12), UnsignedLongs.remainder(j14 * j14, j12), j12);
            }
        };

        private long powMod(long j11, long j12, long j13) {
            long j14 = 1;
            while (j12 != 0) {
                if ((j12 & 1) != 0) {
                    j14 = mulMod(j14, j11, j13);
                }
                j11 = squareMod(j11, j13);
                j12 >>= 1;
            }
            return j14;
        }

        public static boolean test(long j11, long j12) {
            return (j12 <= LongMath.FLOOR_SQRT_MAX_LONG ? SMALL : LARGE).testWitness(j11, j12);
        }

        private boolean testWitness(long j11, long j12) {
            long j13 = j12;
            long j14 = j13 - 1;
            int numberOfTrailingZeros = Long.numberOfTrailingZeros(j14);
            long j15 = j14 >> numberOfTrailingZeros;
            long j16 = j11 % j13;
            if (j16 == 0) {
                return true;
            }
            long powMod = powMod(j16, j15, j12);
            if (powMod == 1) {
                return true;
            }
            int i11 = 0;
            while (powMod != j14) {
                i11++;
                if (i11 == numberOfTrailingZeros) {
                    return false;
                }
                powMod = squareMod(powMod, j13);
            }
            return true;
        }

        public abstract long mulMod(long j11, long j12, long j13);

        public abstract long squareMod(long j11, long j12);
    }

    private LongMath() {
    }

    public static long binomial(int i11, int i12) {
        boolean z11;
        MathPreconditions.checkNonNegative("n", i11);
        MathPreconditions.checkNonNegative("k", i12);
        if (i12 <= i11) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "k (%s) > n (%s)", i12, i11);
        if (i12 > (i11 >> 1)) {
            i12 = i11 - i12;
        }
        long j11 = 1;
        if (i12 == 0) {
            return 1;
        }
        if (i12 == 1) {
            return (long) i11;
        }
        long[] jArr = factorials;
        if (i11 < jArr.length) {
            return jArr[i11] / (jArr[i12] * jArr[i11 - i12]);
        }
        int[] iArr = biggestBinomials;
        if (i12 >= iArr.length || i11 > iArr[i12]) {
            return Long.MAX_VALUE;
        }
        int[] iArr2 = biggestSimpleBinomials;
        if (i12 >= iArr2.length || i11 > iArr2[i12]) {
            long j12 = (long) i11;
            int log2 = log2(j12, RoundingMode.CEILING);
            int i13 = i11 - 1;
            int i14 = log2;
            int i15 = 2;
            long j13 = j12;
            long j14 = 1;
            while (i15 <= i12) {
                i14 += log2;
                if (i14 < 63) {
                    j13 *= (long) i13;
                    j14 *= (long) i15;
                } else {
                    j11 = multiplyFraction(j11, j13, j14);
                    j13 = (long) i13;
                    j14 = (long) i15;
                    i14 = log2;
                }
                i15++;
                i13--;
            }
            return multiplyFraction(j11, j13, j14);
        }
        int i16 = i11 - 1;
        long j15 = (long) i11;
        for (int i17 = 2; i17 <= i12; i17++) {
            j15 = (j15 * ((long) i16)) / ((long) i17);
            i16--;
        }
        return j15;
    }

    public static long ceilingPowerOfTwo(long j11) {
        MathPreconditions.checkPositive(Param.X, j11);
        if (j11 <= 4611686018427387904L) {
            return 1 << (-Long.numberOfLeadingZeros(j11 - 1));
        }
        throw new ArithmeticException("ceilingPowerOfTwo(" + j11 + ") is not representable as a long");
    }

    public static long checkedAdd(long j11, long j12) {
        boolean z11;
        long j13 = j11 + j12;
        boolean z12 = true;
        if ((j11 ^ j12) < 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if ((j11 ^ j13) < 0) {
            z12 = false;
        }
        MathPreconditions.checkNoOverflow(z11 | z12, "checkedAdd", j11, j12);
        return j13;
    }

    public static long checkedMultiply(long j11, long j12) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        int numberOfLeadingZeros = Long.numberOfLeadingZeros(j11) + Long.numberOfLeadingZeros(~j11) + Long.numberOfLeadingZeros(j12) + Long.numberOfLeadingZeros(~j12);
        if (numberOfLeadingZeros > 65) {
            return j11 * j12;
        }
        if (numberOfLeadingZeros >= 64) {
            z11 = true;
        } else {
            z11 = false;
        }
        MathPreconditions.checkNoOverflow(z11, "checkedMultiply", j11, j12);
        int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
        if (i11 >= 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (j12 != Long.MIN_VALUE) {
            z13 = true;
        } else {
            z13 = false;
        }
        MathPreconditions.checkNoOverflow(z12 | z13, "checkedMultiply", j11, j12);
        long j13 = j11 * j12;
        if (i11 == 0 || j13 / j11 == j12) {
            z14 = true;
        } else {
            z14 = false;
        }
        MathPreconditions.checkNoOverflow(z14, "checkedMultiply", j11, j12);
        return j13;
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static long checkedPow(long j11, int i11) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        MathPreconditions.checkNonNegative("exponent", i11);
        if (j11 >= -2) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (j11 <= 2) {
            z12 = true;
        } else {
            z12 = false;
        }
        long j12 = 1;
        if (z11 && z12) {
            int i12 = (int) j11;
            if (i12 == -2) {
                if (i11 < 64) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                MathPreconditions.checkNoOverflow(z14, "checkedPow", j11, (long) i11);
                if ((i11 & 1) == 0) {
                    return 1 << i11;
                }
                return -1 << i11;
            } else if (i12 != -1) {
                if (i12 != 0) {
                    if (i12 == 1) {
                        return 1;
                    }
                    if (i12 == 2) {
                        if (i11 < 63) {
                            z15 = true;
                        } else {
                            z15 = false;
                        }
                        MathPreconditions.checkNoOverflow(z15, "checkedPow", j11, (long) i11);
                        return 1 << i11;
                    }
                    throw new AssertionError();
                } else if (i11 == 0) {
                    return 1;
                } else {
                    return 0;
                }
            } else if ((i11 & 1) == 0) {
                return 1;
            } else {
                return -1;
            }
        } else {
            long j13 = j11;
            int i13 = i11;
            while (i13 != 0) {
                if (i13 == 1) {
                    return checkedMultiply(j12, j13);
                }
                if ((i13 & 1) != 0) {
                    j12 = checkedMultiply(j12, j13);
                }
                long j14 = j12;
                int i14 = i13 >> 1;
                if (i14 > 0) {
                    if (-3037000499L > j13 || j13 > FLOOR_SQRT_MAX_LONG) {
                        z13 = false;
                    } else {
                        z13 = true;
                    }
                    MathPreconditions.checkNoOverflow(z13, "checkedPow", j13, (long) i14);
                    j13 *= j13;
                }
                i13 = i14;
                j12 = j14;
            }
            return j12;
        }
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static long checkedSubtract(long j11, long j12) {
        boolean z11;
        long j13 = j11 - j12;
        boolean z12 = true;
        if ((j11 ^ j12) >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if ((j11 ^ j13) < 0) {
            z12 = false;
        }
        MathPreconditions.checkNoOverflow(z11 | z12, "checkedSubtract", j11, j12);
        return j13;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004a, code lost:
        if (r9 > 0) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004d, code lost:
        if (r9 < 0) goto L_0x0058;
     */
    @com.google.common.annotations.GwtIncompatible
    @com.google.common.annotations.J2ktIncompatible
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long divide(long r9, long r11, java.math.RoundingMode r13) {
        /*
            com.google.common.base.Preconditions.checkNotNull(r13)
            long r0 = r9 / r11
            long r2 = r11 * r0
            long r2 = r9 - r2
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x0010
            return r0
        L_0x0010:
            long r9 = r9 ^ r11
            r7 = 63
            long r9 = r9 >> r7
            int r9 = (int) r9
            r10 = 1
            r9 = r9 | r10
            int[] r7 = com.google.common.math.LongMath.AnonymousClass1.$SwitchMap$java$math$RoundingMode
            int r8 = r13.ordinal()
            r7 = r7[r8]
            r8 = 0
            switch(r7) {
                case 1: goto L_0x0050;
                case 2: goto L_0x0057;
                case 3: goto L_0x004d;
                case 4: goto L_0x0058;
                case 5: goto L_0x004a;
                case 6: goto L_0x0029;
                case 7: goto L_0x0029;
                case 8: goto L_0x0029;
                default: goto L_0x0023;
            }
        L_0x0023:
            java.lang.AssertionError r9 = new java.lang.AssertionError
            r9.<init>()
            throw r9
        L_0x0029:
            long r2 = java.lang.Math.abs(r2)
            long r11 = java.lang.Math.abs(r11)
            long r11 = r11 - r2
            long r2 = r2 - r11
            int r11 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r11 != 0) goto L_0x0047
            java.math.RoundingMode r11 = java.math.RoundingMode.HALF_UP
            if (r13 == r11) goto L_0x0058
            java.math.RoundingMode r11 = java.math.RoundingMode.HALF_EVEN
            if (r13 != r11) goto L_0x0057
            r11 = 1
            long r11 = r11 & r0
            int r11 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x0057
            goto L_0x0058
        L_0x0047:
            if (r11 <= 0) goto L_0x0057
            goto L_0x0058
        L_0x004a:
            if (r9 <= 0) goto L_0x0057
            goto L_0x0058
        L_0x004d:
            if (r9 >= 0) goto L_0x0057
            goto L_0x0058
        L_0x0050:
            if (r6 != 0) goto L_0x0053
            goto L_0x0054
        L_0x0053:
            r10 = r8
        L_0x0054:
            com.google.common.math.MathPreconditions.checkRoundingUnnecessary(r10)
        L_0x0057:
            r10 = r8
        L_0x0058:
            if (r10 == 0) goto L_0x005c
            long r9 = (long) r9
            long r0 = r0 + r9
        L_0x005c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.LongMath.divide(long, long, java.math.RoundingMode):long");
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static long factorial(int i11) {
        MathPreconditions.checkNonNegative("n", i11);
        long[] jArr = factorials;
        if (i11 < jArr.length) {
            return jArr[i11];
        }
        return Long.MAX_VALUE;
    }

    public static boolean fitsInInt(long j11) {
        return ((long) ((int) j11)) == j11;
    }

    public static long floorPowerOfTwo(long j11) {
        MathPreconditions.checkPositive(Param.X, j11);
        return 1 << (63 - Long.numberOfLeadingZeros(j11));
    }

    public static long gcd(long j11, long j12) {
        MathPreconditions.checkNonNegative("a", j11);
        MathPreconditions.checkNonNegative("b", j12);
        if (j11 == 0) {
            return j12;
        }
        if (j12 == 0) {
            return j11;
        }
        int numberOfTrailingZeros = Long.numberOfTrailingZeros(j11);
        long j13 = j11 >> numberOfTrailingZeros;
        int numberOfTrailingZeros2 = Long.numberOfTrailingZeros(j12);
        long j14 = j12 >> numberOfTrailingZeros2;
        while (j13 != j14) {
            long j15 = j13 - j14;
            long j16 = (j15 >> 63) & j15;
            long j17 = (j15 - j16) - j16;
            j14 += j16;
            j13 = j17 >> Long.numberOfTrailingZeros(j17);
        }
        return j13 << Math.min(numberOfTrailingZeros, numberOfTrailingZeros2);
    }

    public static boolean isPowerOfTwo(long j11) {
        boolean z11 = true;
        boolean z12 = j11 > 0;
        if ((j11 & (j11 - 1)) != 0) {
            z11 = false;
        }
        return z12 & z11;
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static boolean isPrime(long j11) {
        if (j11 < 2) {
            MathPreconditions.checkNonNegative("n", j11);
            return false;
        } else if (j11 < 66) {
            if (((722865708377213483 >> (((int) j11) - 2)) & 1) != 0) {
                return true;
            }
            return false;
        } else if (((1 << ((int) (j11 % 30))) & SIEVE_30) != 0 || j11 % 7 == 0 || j11 % 11 == 0 || j11 % 13 == 0) {
            return false;
        } else {
            if (j11 < 289) {
                return true;
            }
            for (long[] jArr : millerRabinBaseSets) {
                if (j11 <= jArr[0]) {
                    for (int i11 = 1; i11 < jArr.length; i11++) {
                        if (!MillerRabinTester.test(jArr[i11], j11)) {
                            return false;
                        }
                    }
                    return true;
                }
            }
            throw new AssertionError();
        }
    }

    @VisibleForTesting
    public static int lessThanBranchFree(long j11, long j12) {
        return (int) ((~(~(j11 - j12))) >>> 63);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0037, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0027, code lost:
        return r0 + r4;
     */
    @com.google.common.annotations.GwtIncompatible
    @com.google.common.annotations.J2ktIncompatible
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int log10(long r4, java.math.RoundingMode r6) {
        /*
            java.lang.String r0 = "x"
            com.google.common.math.MathPreconditions.checkPositive((java.lang.String) r0, (long) r4)
            int r0 = log10Floor(r4)
            long[] r1 = powersOf10
            r2 = r1[r0]
            int[] r1 = com.google.common.math.LongMath.AnonymousClass1.$SwitchMap$java$math$RoundingMode
            int r6 = r6.ordinal()
            r6 = r1[r6]
            switch(r6) {
                case 1: goto L_0x002d;
                case 2: goto L_0x0037;
                case 3: goto L_0x0037;
                case 4: goto L_0x0028;
                case 5: goto L_0x0028;
                case 6: goto L_0x001e;
                case 7: goto L_0x001e;
                case 8: goto L_0x001e;
                default: goto L_0x0018;
            }
        L_0x0018:
            java.lang.AssertionError r4 = new java.lang.AssertionError
            r4.<init>()
            throw r4
        L_0x001e:
            long[] r6 = halfPowersOf10
            r1 = r6[r0]
            int r4 = lessThanBranchFree(r1, r4)
        L_0x0026:
            int r0 = r0 + r4
            return r0
        L_0x0028:
            int r4 = lessThanBranchFree(r2, r4)
            goto L_0x0026
        L_0x002d:
            int r4 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x0033
            r4 = 1
            goto L_0x0034
        L_0x0033:
            r4 = 0
        L_0x0034:
            com.google.common.math.MathPreconditions.checkRoundingUnnecessary(r4)
        L_0x0037:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.LongMath.log10(long, java.math.RoundingMode):int");
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static int log10Floor(long j11) {
        byte b11 = maxLog10ForLeadingZeros[Long.numberOfLeadingZeros(j11)];
        return b11 - lessThanBranchFree(j11, powersOf10[b11]);
    }

    public static int log2(long j11, RoundingMode roundingMode) {
        MathPreconditions.checkPositive(Param.X, j11);
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(j11));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 64 - Long.numberOfLeadingZeros(j11 - 1);
            case 6:
            case 7:
            case 8:
                int numberOfLeadingZeros = Long.numberOfLeadingZeros(j11);
                return (63 - numberOfLeadingZeros) + lessThanBranchFree(MAX_POWER_OF_SQRT2_UNSIGNED >>> numberOfLeadingZeros, j11);
            default:
                throw new AssertionError("impossible");
        }
        return 63 - Long.numberOfLeadingZeros(j11);
    }

    public static long mean(long j11, long j12) {
        return (j11 & j12) + ((j11 ^ j12) >> 1);
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static int mod(long j11, int i11) {
        return (int) mod(j11, (long) i11);
    }

    public static long multiplyFraction(long j11, long j12, long j13) {
        if (j11 == 1) {
            return j12 / j13;
        }
        long gcd = gcd(j11, j13);
        return (j11 / gcd) * (j12 / (j13 / gcd));
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static long pow(long j11, int i11) {
        long j12;
        MathPreconditions.checkNonNegative("exponent", i11);
        if (-2 > j11 || j11 > 2) {
            long j13 = 1;
            while (i11 != 0) {
                if (i11 == 1) {
                    return j13 * j11;
                }
                if ((i11 & 1) == 0) {
                    j12 = 1;
                } else {
                    j12 = j11;
                }
                j13 *= j12;
                j11 *= j11;
                i11 >>= 1;
            }
            return j13;
        }
        int i12 = (int) j11;
        if (i12 != -2) {
            if (i12 != -1) {
                if (i12 != 0) {
                    if (i12 == 1) {
                        return 1;
                    }
                    if (i12 != 2) {
                        throw new AssertionError();
                    } else if (i11 < 64) {
                        return 1 << i11;
                    } else {
                        return 0;
                    }
                } else if (i11 == 0) {
                    return 1;
                } else {
                    return 0;
                }
            } else if ((i11 & 1) == 0) {
                return 1;
            } else {
                return -1;
            }
        } else if (i11 >= 64) {
            return 0;
        } else {
            if ((i11 & 1) == 0) {
                return 1 << i11;
            }
            return -(1 << i11);
        }
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static double roundToDouble(long j11, RoundingMode roundingMode) {
        int i11;
        boolean z11;
        double d11;
        long j12;
        long j13 = j11;
        double d12 = (double) j13;
        long j14 = (long) d12;
        if (j14 == Long.MAX_VALUE) {
            i11 = -1;
        } else {
            i11 = Longs.compare(j13, j14);
        }
        int[] iArr = AnonymousClass1.$SwitchMap$java$math$RoundingMode;
        switch (iArr[roundingMode.ordinal()]) {
            case 1:
                if (i11 == 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                MathPreconditions.checkRoundingUnnecessary(z11);
                return d12;
            case 2:
                if (j13 >= 0) {
                    if (i11 >= 0) {
                        return d12;
                    }
                    return DoubleUtils.nextDown(d12);
                } else if (i11 <= 0) {
                    return d12;
                } else {
                    return Math.nextUp(d12);
                }
            case 3:
                if (i11 >= 0) {
                    return d12;
                }
                return DoubleUtils.nextDown(d12);
            case 4:
                if (j13 >= 0) {
                    if (i11 <= 0) {
                        return d12;
                    }
                    return Math.nextUp(d12);
                } else if (i11 >= 0) {
                    return d12;
                } else {
                    return DoubleUtils.nextDown(d12);
                }
            case 5:
                if (i11 <= 0) {
                    return d12;
                }
                return Math.nextUp(d12);
            case 6:
            case 7:
            case 8:
                if (i11 >= 0) {
                    d11 = Math.nextUp(d12);
                    j12 = (long) Math.ceil(d11);
                } else {
                    double nextDown = DoubleUtils.nextDown(d12);
                    long j15 = j14;
                    j14 = (long) Math.floor(nextDown);
                    d11 = d12;
                    d12 = nextDown;
                    j12 = j15;
                }
                long j16 = j13 - j14;
                long j17 = j12 - j13;
                if (j12 == Long.MAX_VALUE) {
                    j17++;
                }
                int compare = Longs.compare(j16, j17);
                if (compare < 0) {
                    return d12;
                }
                if (compare > 0) {
                    return d11;
                }
                int i12 = iArr[roundingMode.ordinal()];
                if (i12 != 6) {
                    if (i12 != 7) {
                        if (i12 != 8) {
                            throw new AssertionError("impossible");
                        } else if ((DoubleUtils.getSignificand(d12) & 1) == 0) {
                            return d12;
                        } else {
                            return d11;
                        }
                    } else if (j13 >= 0) {
                        return d11;
                    } else {
                        return d12;
                    }
                } else if (j13 >= 0) {
                    return d12;
                } else {
                    return d11;
                }
            default:
                throw new AssertionError("impossible");
        }
    }

    public static long saturatedAdd(long j11, long j12) {
        long j13 = j11 + j12;
        boolean z11 = true;
        boolean z12 = (j12 ^ j11) < 0;
        if ((j11 ^ j13) < 0) {
            z11 = false;
        }
        return z12 | z11 ? j13 : ((j13 >>> 63) ^ 1) + Long.MAX_VALUE;
    }

    public static long saturatedMultiply(long j11, long j12) {
        boolean z11;
        boolean z12;
        int numberOfLeadingZeros = Long.numberOfLeadingZeros(j11) + Long.numberOfLeadingZeros(~j11) + Long.numberOfLeadingZeros(j12) + Long.numberOfLeadingZeros(~j12);
        if (numberOfLeadingZeros > 65) {
            return j11 * j12;
        }
        long j13 = ((j11 ^ j12) >>> 63) + Long.MAX_VALUE;
        boolean z13 = true;
        if (numberOfLeadingZeros < 64) {
            z11 = true;
        } else {
            z11 = false;
        }
        int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
        if (i11 < 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (j12 != Long.MIN_VALUE) {
            z13 = false;
        }
        if (z11 || (z13 & z12)) {
            return j13;
        }
        long j14 = j11 * j12;
        if (i11 == 0 || j14 / j11 == j12) {
            return j14;
        }
        return j13;
    }

    public static long saturatedPow(long j11, int i11) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        MathPreconditions.checkNonNegative("exponent", i11);
        if (j11 >= -2) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (j11 <= 2) {
            z12 = true;
        } else {
            z12 = false;
        }
        long j12 = 1;
        if (z11 && z12) {
            int i12 = (int) j11;
            if (i12 != -2) {
                if (i12 != -1) {
                    if (i12 != 0) {
                        if (i12 == 1) {
                            return 1;
                        }
                        if (i12 != 2) {
                            throw new AssertionError();
                        } else if (i11 >= 63) {
                            return Long.MAX_VALUE;
                        } else {
                            return 1 << i11;
                        }
                    } else if (i11 == 0) {
                        return 1;
                    } else {
                        return 0;
                    }
                } else if ((i11 & 1) == 0) {
                    return 1;
                } else {
                    return -1;
                }
            } else if (i11 >= 64) {
                return ((long) (i11 & 1)) + Long.MAX_VALUE;
            } else {
                if ((i11 & 1) == 0) {
                    return 1 << i11;
                }
                return -1 << i11;
            }
        } else {
            long j13 = ((j11 >>> 63) & ((long) (i11 & 1))) + Long.MAX_VALUE;
            while (i11 != 0) {
                if (i11 == 1) {
                    return saturatedMultiply(j12, j11);
                }
                if ((i11 & 1) != 0) {
                    j12 = saturatedMultiply(j12, j11);
                }
                i11 >>= 1;
                if (i11 > 0) {
                    if (-3037000499L > j11) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    if (j11 > FLOOR_SQRT_MAX_LONG) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    if (z13 || z14) {
                        return j13;
                    }
                    j11 *= j11;
                }
            }
            return j12;
        }
    }

    public static long saturatedSubtract(long j11, long j12) {
        long j13 = j11 - j12;
        boolean z11 = true;
        boolean z12 = (j12 ^ j11) >= 0;
        if ((j11 ^ j13) < 0) {
            z11 = false;
        }
        return z12 | z11 ? j13 : ((j13 >>> 63) ^ 1) + Long.MAX_VALUE;
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static long sqrt(long j11, RoundingMode roundingMode) {
        MathPreconditions.checkNonNegative(Param.X, j11);
        if (fitsInInt(j11)) {
            return (long) IntMath.sqrt((int) j11, roundingMode);
        }
        long sqrt = (long) Math.sqrt((double) j11);
        long j12 = sqrt * sqrt;
        boolean z11 = true;
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                if (j12 != j11) {
                    z11 = false;
                }
                MathPreconditions.checkRoundingUnnecessary(z11);
                return sqrt;
            case 2:
            case 3:
                if (j11 < j12) {
                    return sqrt - 1;
                }
                return sqrt;
            case 4:
            case 5:
                if (j11 > j12) {
                    return sqrt + 1;
                }
                return sqrt;
            case 6:
            case 7:
            case 8:
                if (j11 >= j12) {
                    z11 = false;
                }
                long j13 = sqrt - (z11 ? 1 : 0);
                return j13 + ((long) lessThanBranchFree((j13 * j13) + j13, j11));
            default:
                throw new AssertionError();
        }
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static long mod(long j11, long j12) {
        if (j12 > 0) {
            long j13 = j11 % j12;
            return j13 >= 0 ? j13 : j13 + j12;
        }
        throw new ArithmeticException("Modulus must be positive");
    }
}
