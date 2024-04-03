package org.threeten.bp.jdk8;

public final class Jdk8Methods {
    private Jdk8Methods() {
    }

    public static int compareInts(int i11, int i12) {
        if (i11 < i12) {
            return -1;
        }
        return i11 > i12 ? 1 : 0;
    }

    public static int compareLongs(long j11, long j12) {
        int i11 = (j11 > j12 ? 1 : (j11 == j12 ? 0 : -1));
        if (i11 < 0) {
            return -1;
        }
        return i11 > 0 ? 1 : 0;
    }

    public static boolean equals(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        if (obj2 == null) {
            return false;
        }
        return obj.equals(obj2);
    }

    public static long floorDiv(long j11, long j12) {
        return j11 >= 0 ? j11 / j12 : ((j11 + 1) / j12) - 1;
    }

    public static long floorMod(long j11, long j12) {
        return ((j11 % j12) + j12) % j12;
    }

    public static <T> T requireNonNull(T t11) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException("Value must not be null");
    }

    public static int safeAdd(int i11, int i12) {
        int i13 = i11 + i12;
        if ((i11 ^ i13) >= 0 || (i11 ^ i12) < 0) {
            return i13;
        }
        throw new ArithmeticException("Addition overflows an int: " + i11 + " + " + i12);
    }

    public static int safeMultiply(int i11, int i12) {
        long j11 = ((long) i11) * ((long) i12);
        if (j11 >= -2147483648L && j11 <= 2147483647L) {
            return (int) j11;
        }
        throw new ArithmeticException("Multiplication overflows an int: " + i11 + " * " + i12);
    }

    public static int safeSubtract(int i11, int i12) {
        int i13 = i11 - i12;
        if ((i11 ^ i13) >= 0 || (i11 ^ i12) >= 0) {
            return i13;
        }
        throw new ArithmeticException("Subtraction overflows an int: " + i11 + " - " + i12);
    }

    public static int safeToInt(long j11) {
        if (j11 <= 2147483647L && j11 >= -2147483648L) {
            return (int) j11;
        }
        throw new ArithmeticException("Calculation overflows an int: " + j11);
    }

    public static int floorDiv(int i11, int i12) {
        return i11 >= 0 ? i11 / i12 : ((i11 + 1) / i12) - 1;
    }

    public static int floorMod(long j11, int i11) {
        long j12 = (long) i11;
        return (int) (((j11 % j12) + j12) % j12);
    }

    public static <T> T requireNonNull(T t11, String str) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(str + " must not be null");
    }

    public static long safeAdd(long j11, long j12) {
        long j13 = j11 + j12;
        if ((j11 ^ j13) >= 0 || (j11 ^ j12) < 0) {
            return j13;
        }
        throw new ArithmeticException("Addition overflows a long: " + j11 + " + " + j12);
    }

    public static long safeMultiply(long j11, int i11) {
        if (i11 != -1) {
            if (i11 == 0) {
                return 0;
            }
            if (i11 == 1) {
                return j11;
            }
            long j12 = (long) i11;
            long j13 = j11 * j12;
            if (j13 / j12 == j11) {
                return j13;
            }
            throw new ArithmeticException("Multiplication overflows a long: " + j11 + " * " + i11);
        } else if (j11 != Long.MIN_VALUE) {
            return -j11;
        } else {
            throw new ArithmeticException("Multiplication overflows a long: " + j11 + " * " + i11);
        }
    }

    public static long safeSubtract(long j11, long j12) {
        long j13 = j11 - j12;
        if ((j11 ^ j13) >= 0 || (j11 ^ j12) >= 0) {
            return j13;
        }
        throw new ArithmeticException("Subtraction overflows a long: " + j11 + " - " + j12);
    }

    public static int floorMod(int i11, int i12) {
        return ((i11 % i12) + i12) % i12;
    }

    public static long safeMultiply(long j11, long j12) {
        if (j12 == 1) {
            return j11;
        }
        if (j11 == 1) {
            return j12;
        }
        if (j11 == 0 || j12 == 0) {
            return 0;
        }
        long j13 = j11 * j12;
        if (j13 / j12 == j11 && ((j11 != Long.MIN_VALUE || j12 != -1) && (j12 != Long.MIN_VALUE || j11 != -1))) {
            return j13;
        }
        throw new ArithmeticException("Multiplication overflows a long: " + j11 + " * " + j12);
    }
}
