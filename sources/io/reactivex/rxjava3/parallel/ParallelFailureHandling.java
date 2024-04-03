package io.reactivex.rxjava3.parallel;

import io.reactivex.rxjava3.functions.BiFunction;

public enum ParallelFailureHandling implements BiFunction<Long, Throwable, ParallelFailureHandling> {
    STOP,
    ERROR,
    SKIP,
    RETRY;

    public ParallelFailureHandling apply(Long l11, Throwable th2) {
        return this;
    }
}
