package j$.time.temporal;

import j$.time.Duration;

public interface TemporalUnit {
    l f(l lVar, long j11);

    Duration getDuration();

    boolean isDateBased();

    boolean isDurationEstimated();
}
