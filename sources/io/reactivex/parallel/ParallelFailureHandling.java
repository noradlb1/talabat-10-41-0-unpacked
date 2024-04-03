package io.reactivex.parallel;

import io.reactivex.functions.BiFunction;

public enum ParallelFailureHandling implements BiFunction<Long, Throwable, ParallelFailureHandling> {
    STOP,
    ERROR,
    SKIP,
    RETRY;

    public ParallelFailureHandling apply(Long l11, Throwable th2) {
        return this;
    }
}
