package com.huawei.location.router.dispatch;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class FutureDispatch<V> extends FutureTask<V> {
    private final Callable<V> callable;

    public FutureDispatch(Callable<V> callable2) {
        super(callable2);
        this.callable = callable2;
    }

    public Callable<V> getCallable() {
        return this.callable;
    }
}
