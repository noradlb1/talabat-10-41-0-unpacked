package com.huawei.hms.push;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class o {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f49778a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static ThreadPoolExecutor f49779b = new ThreadPoolExecutor(1, 50, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());

    public static ThreadPoolExecutor a() {
        ThreadPoolExecutor threadPoolExecutor;
        synchronized (f49778a) {
            threadPoolExecutor = f49779b;
        }
        return threadPoolExecutor;
    }
}
