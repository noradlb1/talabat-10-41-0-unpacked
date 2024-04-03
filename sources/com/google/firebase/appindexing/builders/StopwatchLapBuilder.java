package com.google.firebase.appindexing.builders;

import androidx.annotation.NonNull;

public class StopwatchLapBuilder extends IndexableBuilder<StopwatchLapBuilder> {
    public StopwatchLapBuilder() {
        super("StopwatchLap");
    }

    @NonNull
    public StopwatchLapBuilder setAccumulatedTime(long j11) {
        return (StopwatchLapBuilder) put("accumulatedTime", j11);
    }

    @NonNull
    public StopwatchLapBuilder setElapsedTime(long j11) {
        return (StopwatchLapBuilder) put("elapsedTime", j11);
    }
}
