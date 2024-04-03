package com.huawei.hms.dtm;

import java.lang.Thread;

public class s implements Thread.UncaughtExceptionHandler {
    public void uncaughtException(Thread thread, Throwable th2) {
        B.b("HMS-DTM", thread.getName() + "#" + th2.getClass().getSimpleName());
    }
}
