package org.mockito.internal.util;

import org.mockito.internal.exceptions.Reporter;

public class Timer {
    private final long durationMillis;
    private long startTime = -1;

    public Timer(long j11) {
        validateInput(j11);
        this.durationMillis = j11;
    }

    private void validateInput(long j11) {
        if (j11 < 0) {
            throw Reporter.cannotCreateTimerWithNegativeDurationTime(j11);
        }
    }

    public long duration() {
        return this.durationMillis;
    }

    public boolean isCounting() {
        return System.currentTimeMillis() - this.startTime <= this.durationMillis;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
    }
}
