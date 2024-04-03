package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;

public final class BackpressureHelper {
    private BackpressureHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static long add(@NonNull AtomicLong atomicLong, long j11) {
        long j12;
        do {
            j12 = atomicLong.get();
            if (j12 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
        } while (!atomicLong.compareAndSet(j12, addCap(j12, j11)));
        return j12;
    }

    public static long addCancel(@NonNull AtomicLong atomicLong, long j11) {
        long j12;
        do {
            j12 = atomicLong.get();
            if (j12 == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            if (j12 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
        } while (!atomicLong.compareAndSet(j12, addCap(j12, j11)));
        return j12;
    }

    public static long addCap(long j11, long j12) {
        long j13 = j11 + j12;
        if (j13 < 0) {
            return Long.MAX_VALUE;
        }
        return j13;
    }

    public static long multiplyCap(long j11, long j12) {
        long j13 = j11 * j12;
        if (((j11 | j12) >>> 31) == 0 || j13 / j11 == j12) {
            return j13;
        }
        return Long.MAX_VALUE;
    }

    public static long produced(@NonNull AtomicLong atomicLong, long j11) {
        long j12;
        long j13;
        do {
            j12 = atomicLong.get();
            if (j12 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
            j13 = j12 - j11;
            if (j13 < 0) {
                RxJavaPlugins.onError(new IllegalStateException("More produced than requested: " + j13));
                j13 = 0;
            }
        } while (!atomicLong.compareAndSet(j12, j13));
        return j13;
    }

    public static long producedCancel(@NonNull AtomicLong atomicLong, long j11) {
        long j12;
        long j13;
        do {
            j12 = atomicLong.get();
            if (j12 == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            if (j12 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
            j13 = j12 - j11;
            if (j13 < 0) {
                RxJavaPlugins.onError(new IllegalStateException("More produced than requested: " + j13));
                j13 = 0;
            }
        } while (!atomicLong.compareAndSet(j12, j13));
        return j13;
    }
}
