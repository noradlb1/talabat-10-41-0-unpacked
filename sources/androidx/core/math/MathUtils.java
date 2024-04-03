package androidx.core.math;

public class MathUtils {
    private MathUtils() {
    }

    public static int addExact(int i11, int i12) {
        int i13 = i11 + i12;
        if (((i11 ^ i13) & (i12 ^ i13)) >= 0) {
            return i13;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static double clamp(double d11, double d12, double d13) {
        return d11 < d12 ? d12 : d11 > d13 ? d13 : d11;
    }

    public static float clamp(float f11, float f12, float f13) {
        return f11 < f12 ? f12 : f11 > f13 ? f13 : f11;
    }

    public static int clamp(int i11, int i12, int i13) {
        return i11 < i12 ? i12 : i11 > i13 ? i13 : i11;
    }

    public static long clamp(long j11, long j12, long j13) {
        return j11 < j12 ? j12 : j11 > j13 ? j13 : j11;
    }

    public static int decrementExact(int i11) {
        if (i11 != Integer.MIN_VALUE) {
            return i11 - 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int incrementExact(int i11) {
        if (i11 != Integer.MAX_VALUE) {
            return i11 + 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int multiplyExact(int i11, int i12) {
        long j11 = ((long) i11) * ((long) i12);
        int i13 = (int) j11;
        if (((long) i13) == j11) {
            return i13;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int negateExact(int i11) {
        if (i11 != Integer.MIN_VALUE) {
            return -i11;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int subtractExact(int i11, int i12) {
        int i13 = i11 - i12;
        if (((i11 ^ i13) & (i12 ^ i11)) >= 0) {
            return i13;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int toIntExact(long j11) {
        int i11 = (int) j11;
        if (((long) i11) == j11) {
            return i11;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long addExact(long j11, long j12) {
        long j13 = j11 + j12;
        if (((j11 ^ j13) & (j12 ^ j13)) >= 0) {
            return j13;
        }
        throw new ArithmeticException("long overflow");
    }

    public static long decrementExact(long j11) {
        if (j11 != Long.MIN_VALUE) {
            return j11 - 1;
        }
        throw new ArithmeticException("long overflow");
    }

    public static long incrementExact(long j11) {
        if (j11 != Long.MAX_VALUE) {
            return j11 + 1;
        }
        throw new ArithmeticException("long overflow");
    }

    public static long multiplyExact(long j11, long j12) {
        long j13 = j11 * j12;
        if (((Math.abs(j11) | Math.abs(j12)) >>> 31) == 0 || ((j12 == 0 || j13 / j12 == j11) && (j11 != Long.MIN_VALUE || j12 != -1))) {
            return j13;
        }
        throw new ArithmeticException("long overflow");
    }

    public static long negateExact(long j11) {
        if (j11 != Long.MIN_VALUE) {
            return -j11;
        }
        throw new ArithmeticException("long overflow");
    }

    public static long subtractExact(long j11, long j12) {
        long j13 = j11 - j12;
        if (((j11 ^ j13) & (j12 ^ j11)) >= 0) {
            return j13;
        }
        throw new ArithmeticException("long overflow");
    }
}
