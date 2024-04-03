package com.google.firebase.database.core.utilities;

public class OffsetClock implements Clock {
    private final Clock baseClock;
    private long offset;

    public OffsetClock(Clock clock, long j11) {
        this.baseClock = clock;
        this.offset = j11;
    }

    public long millis() {
        return this.baseClock.millis() + this.offset;
    }

    public void setOffset(long j11) {
        this.offset = j11;
    }
}
