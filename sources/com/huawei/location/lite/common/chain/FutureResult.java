package com.huawei.location.lite.common.chain;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureResult<T> implements Future<T> {
    private final CountDownLatch countDownLatch = new CountDownLatch(1);
    private T result;

    public boolean cancel(boolean z11) {
        return false;
    }

    public T get() throws ExecutionException, InterruptedException {
        this.countDownLatch.await();
        return this.result;
    }

    public T get(long j11, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        if (this.countDownLatch.await(j11, timeUnit)) {
            return this.result;
        }
        throw new TimeoutException();
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return false;
    }

    public void setResult(T t11) {
        this.result = t11;
        this.countDownLatch.countDown();
    }
}
