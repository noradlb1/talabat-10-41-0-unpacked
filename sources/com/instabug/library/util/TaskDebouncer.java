package com.instabug.library.util;

import androidx.annotation.IntRange;
import androidx.annotation.Keep;
import io.reactivex.Observable;

@Keep
public class TaskDebouncer {
    private long lastRun;
    private final long timeout;

    public TaskDebouncer(@IntRange(from = 0) long j11) {
        this.timeout = j11;
    }

    private long getElapsedTime() {
        return System.currentTimeMillis() - this.lastRun;
    }

    private void updateLastRun(long j11) {
        this.lastRun = j11;
    }

    public void debounce(Runnable runnable) {
        if (getElapsedTime() >= this.timeout) {
            updateLastRun(System.currentTimeMillis());
            runnable.run();
        }
    }

    public <T> Observable<T> debounce(Observable<T> observable) {
        if (getElapsedTime() < this.timeout) {
            return Observable.empty();
        }
        updateLastRun(System.currentTimeMillis());
        return observable;
    }
}
