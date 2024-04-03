package com.google.firebase;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class StartupTime {
    @NonNull
    public static StartupTime create(long j11, long j12, long j13) {
        return new AutoValue_StartupTime(j11, j12, j13);
    }

    @NonNull
    public static StartupTime now() {
        return create(System.currentTimeMillis(), SystemClock.elapsedRealtime(), SystemClock.uptimeMillis());
    }

    public abstract long getElapsedRealtime();

    public abstract long getEpochMillis();

    public abstract long getUptimeMillis();
}
