package com.bumptech.glide.util;

import android.annotation.TargetApi;
import android.os.SystemClock;

public final class LogTime {
    private static final double MILLIS_MULTIPLIER = (1.0d / Math.pow(10.0d, 6.0d));

    private LogTime() {
    }

    public static double getElapsedMillis(long j11) {
        return ((double) (getLogTime() - j11)) * MILLIS_MULTIPLIER;
    }

    @TargetApi(17)
    public static long getLogTime() {
        return SystemClock.elapsedRealtimeNanos();
    }
}
