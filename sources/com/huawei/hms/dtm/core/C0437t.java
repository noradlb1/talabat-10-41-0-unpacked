package com.huawei.hms.dtm.core;

import com.huawei.hms.dtm.core.util.Logger;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/* renamed from: com.huawei.hms.dtm.core.t  reason: case insensitive filesystem */
public class C0437t implements RejectedExecutionHandler {
    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        Logger.info(Thread.currentThread().getName() + " task queue is full.");
    }
}
