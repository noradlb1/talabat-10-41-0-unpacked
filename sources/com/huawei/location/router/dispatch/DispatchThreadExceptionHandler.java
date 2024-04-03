package com.huawei.location.router.dispatch;

import java.lang.Thread;

public class DispatchThreadExceptionHandler implements Thread.UncaughtExceptionHandler {
    private DispatchBaseRunnable dispatchRunnable;
    private Thread.UncaughtExceptionHandler uncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();

    public DispatchThreadExceptionHandler(DispatchBaseRunnable dispatchBaseRunnable) {
        this.dispatchRunnable = dispatchBaseRunnable;
    }

    public void uncaughtException(Thread thread, Throwable th2) {
        if (th2 instanceof DispatchException) {
            DispatchException dispatchException = (DispatchException) th2;
            this.dispatchRunnable.onDispatchError(dispatchException.getExceptionCode(), dispatchException.getMessage());
            return;
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.uncaughtExceptionHandler;
        if (uncaughtExceptionHandler2 != null) {
            uncaughtExceptionHandler2.uncaughtException(thread, th2);
        }
    }
}
