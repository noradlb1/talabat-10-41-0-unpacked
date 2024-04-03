package j$.lang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public abstract /* synthetic */ class a {
    public static int a(long j11, long j12) {
        int i11 = (j11 > j12 ? 1 : (j11 == j12 ? 0 : -1));
        if (i11 < 0) {
            return -1;
        }
        return i11 == 0 ? 0 : 1;
    }

    public static /* synthetic */ long b(long j11, long j12) {
        long j13 = j11 / j12;
        return (j11 - (j12 * j13) != 0 && (((j11 ^ j12) >> 63) | 1) < 0) ? j13 - 1 : j13;
    }

    public static /* synthetic */ List c(Object[] objArr) {
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            Objects.requireNonNull(obj);
            arrayList.add(obj);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static /* synthetic */ long d(long j11, long j12) {
        int numberOfLeadingZeros = Long.numberOfLeadingZeros(~j12) + Long.numberOfLeadingZeros(j12) + Long.numberOfLeadingZeros(~j11) + Long.numberOfLeadingZeros(j11);
        if (numberOfLeadingZeros > 65) {
            return j11 * j12;
        }
        if (numberOfLeadingZeros >= 64) {
            int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
            boolean z11 = true;
            boolean z12 = i11 >= 0;
            if (j12 == Long.MIN_VALUE) {
                z11 = false;
            }
            if (z11 || z12) {
                long j13 = j11 * j12;
                if (i11 == 0 || j13 / j11 == j12) {
                    return j13;
                }
            }
        }
        throw new ArithmeticException();
    }

    public static /* synthetic */ long e(long j11, long j12) {
        long j13 = j11 + j12;
        boolean z11 = true;
        boolean z12 = (j12 ^ j11) < 0;
        if ((j11 ^ j13) < 0) {
            z11 = false;
        }
        if (z12 || z11) {
            return j13;
        }
        throw new ArithmeticException();
    }

    public static /* synthetic */ long f(long j11, long j12) {
        long j13 = j11 % j12;
        if (j13 == 0) {
            return 0;
        }
        return (((j11 ^ j12) >> 63) | 1) > 0 ? j13 : j13 + j12;
    }

    public static /* synthetic */ long g(long j11, long j12) {
        long j13 = j11 - j12;
        boolean z11 = true;
        boolean z12 = (j12 ^ j11) >= 0;
        if ((j11 ^ j13) < 0) {
            z11 = false;
        }
        if (z12 || z11) {
            return j13;
        }
        throw new ArithmeticException();
    }
}
