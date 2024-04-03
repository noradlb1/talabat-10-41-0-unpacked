package com.google.android.libraries.places.internal;

import android.annotation.TargetApi;
import android.os.SystemClock;

final class zzd {
    private static final boolean zza;

    static {
        boolean z11;
        try {
            SystemClock.elapsedRealtimeNanos();
            z11 = true;
        } catch (Throwable unused) {
            z11 = false;
        }
        zza = z11;
    }

    @TargetApi(17)
    public static long zza() {
        if (zza) {
            return SystemClock.elapsedRealtimeNanos();
        }
        return SystemClock.elapsedRealtime() * 1000000;
    }
}
