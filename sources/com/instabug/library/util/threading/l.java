package com.instabug.library.util.threading;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class l extends SingleThreadPoolExecutor {
    public l(String str) {
        super(str, 15, TimeUnit.SECONDS, new LinkedBlockingQueue(), new PriorityThreadFactory("network-single-executor", 10));
    }
}
