package org.apache.commons.lang3;

import java.util.Random;

public class RandomUtils {
    private static final Random RANDOM = new Random();

    public static byte[] nextBytes(int i11) {
        boolean z11;
        if (i11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Validate.isTrue(z11, "Count cannot be negative.", new Object[0]);
        byte[] bArr = new byte[i11];
        RANDOM.nextBytes(bArr);
        return bArr;
    }

    public static double nextDouble(double d11, double d12) {
        boolean z11;
        boolean z12 = true;
        if (d12 >= d11) {
            z11 = true;
        } else {
            z11 = false;
        }
        Validate.isTrue(z11, "Start value must be smaller or equal to end value.", new Object[0]);
        if (d11 < 0.0d) {
            z12 = false;
        }
        Validate.isTrue(z12, "Both range values must be non-negative.", new Object[0]);
        if (d11 == d12) {
            return d11;
        }
        return d11 + ((d12 - d11) * RANDOM.nextDouble());
    }

    public static float nextFloat(float f11, float f12) {
        boolean z11;
        boolean z12 = true;
        if (f12 >= f11) {
            z11 = true;
        } else {
            z11 = false;
        }
        Validate.isTrue(z11, "Start value must be smaller or equal to end value.", new Object[0]);
        if (f11 < 0.0f) {
            z12 = false;
        }
        Validate.isTrue(z12, "Both range values must be non-negative.", new Object[0]);
        if (f11 == f12) {
            return f11;
        }
        return f11 + ((f12 - f11) * RANDOM.nextFloat());
    }

    public static int nextInt(int i11, int i12) {
        boolean z11;
        boolean z12 = true;
        if (i12 >= i11) {
            z11 = true;
        } else {
            z11 = false;
        }
        Validate.isTrue(z11, "Start value must be smaller or equal to end value.", new Object[0]);
        if (i11 < 0) {
            z12 = false;
        }
        Validate.isTrue(z12, "Both range values must be non-negative.", new Object[0]);
        if (i11 == i12) {
            return i11;
        }
        return i11 + RANDOM.nextInt(i12 - i11);
    }

    public static long nextLong(long j11, long j12) {
        boolean z11;
        boolean z12 = true;
        if (j12 >= j11) {
            z11 = true;
        } else {
            z11 = false;
        }
        Validate.isTrue(z11, "Start value must be smaller or equal to end value.", new Object[0]);
        if (j11 < 0) {
            z12 = false;
        }
        Validate.isTrue(z12, "Both range values must be non-negative.", new Object[0]);
        if (j11 == j12) {
            return j11;
        }
        return (long) nextDouble((double) j11, (double) j12);
    }
}
