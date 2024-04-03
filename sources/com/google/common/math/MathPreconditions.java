package com.google.common.math;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.math.BigInteger;
import java.math.RoundingMode;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@GwtCompatible
@ElementTypesAreNonnullByDefault
final class MathPreconditions {
    private MathPreconditions() {
    }

    public static void checkInRangeForRoundingInputs(boolean z11, double d11, RoundingMode roundingMode) {
        if (!z11) {
            throw new ArithmeticException("rounded value is out of range for input " + d11 + " and rounding mode " + roundingMode);
        }
    }

    public static void checkNoOverflow(boolean z11, String str, int i11, int i12) {
        if (!z11) {
            throw new ArithmeticException("overflow: " + str + "(" + i11 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + i12 + ")");
        }
    }

    @CanIgnoreReturnValue
    public static int checkNonNegative(String str, int i11) {
        if (i11 >= 0) {
            return i11;
        }
        throw new IllegalArgumentException(str + " (" + i11 + ") must be >= 0");
    }

    @CanIgnoreReturnValue
    public static int checkPositive(String str, int i11) {
        if (i11 > 0) {
            return i11;
        }
        throw new IllegalArgumentException(str + " (" + i11 + ") must be > 0");
    }

    public static void checkRoundingUnnecessary(boolean z11) {
        if (!z11) {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }

    public static void checkNoOverflow(boolean z11, String str, long j11, long j12) {
        if (!z11) {
            throw new ArithmeticException("overflow: " + str + "(" + j11 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + j12 + ")");
        }
    }

    @CanIgnoreReturnValue
    public static long checkNonNegative(String str, long j11) {
        if (j11 >= 0) {
            return j11;
        }
        throw new IllegalArgumentException(str + " (" + j11 + ") must be >= 0");
    }

    @CanIgnoreReturnValue
    public static long checkPositive(String str, long j11) {
        if (j11 > 0) {
            return j11;
        }
        throw new IllegalArgumentException(str + " (" + j11 + ") must be > 0");
    }

    @CanIgnoreReturnValue
    public static BigInteger checkNonNegative(String str, BigInteger bigInteger) {
        if (bigInteger.signum() >= 0) {
            return bigInteger;
        }
        throw new IllegalArgumentException(str + " (" + bigInteger + ") must be >= 0");
    }

    @CanIgnoreReturnValue
    public static BigInteger checkPositive(String str, BigInteger bigInteger) {
        if (bigInteger.signum() > 0) {
            return bigInteger;
        }
        throw new IllegalArgumentException(str + " (" + bigInteger + ") must be > 0");
    }

    @CanIgnoreReturnValue
    public static double checkNonNegative(String str, double d11) {
        if (d11 >= 0.0d) {
            return d11;
        }
        throw new IllegalArgumentException(str + " (" + d11 + ") must be >= 0");
    }
}
