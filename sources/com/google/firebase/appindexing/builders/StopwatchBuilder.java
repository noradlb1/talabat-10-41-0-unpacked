package com.google.firebase.appindexing.builders;

import androidx.annotation.NonNull;
import com.google.firebase.appindexing.internal.zzae;
import java.util.Calendar;

public final class StopwatchBuilder extends IndexableBuilder<StopwatchBuilder> {
    @NonNull
    public static final String PAUSED = "Paused";
    @NonNull
    public static final String STARTED = "Started";
    @NonNull
    public static final String UNKNOWN = "Unknown";

    public StopwatchBuilder() {
        super("Stopwatch");
    }

    @NonNull
    public StopwatchBuilder setElapsedTime(long j11) {
        put("elapsedTime", j11);
        return this;
    }

    @NonNull
    public StopwatchBuilder setLaps(@NonNull StopwatchLapBuilder... stopwatchLapBuilderArr) {
        put("laps", (S[]) stopwatchLapBuilderArr);
        return this;
    }

    @NonNull
    public StopwatchBuilder setStartTime(@NonNull Calendar calendar) {
        put("startTime", zzae.zza(calendar));
        return this;
    }

    @NonNull
    public StopwatchBuilder setStopwatchStatus(@NonNull String str) {
        String str2;
        if ("Started".equals(str) || "Paused".equals(str) || "Unknown".equals(str)) {
            put("stopwatchStatus", str);
            return this;
        }
        String valueOf = String.valueOf(str);
        if (valueOf.length() != 0) {
            str2 = "Invalid stopwatch status ".concat(valueOf);
        } else {
            str2 = new String("Invalid stopwatch status ");
        }
        throw new IllegalArgumentException(str2);
    }
}
