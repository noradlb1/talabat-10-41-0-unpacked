package com.huawei.agconnect.credential.obs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class v {

    /* renamed from: a  reason: collision with root package name */
    private static final int f47617a;

    /* renamed from: b  reason: collision with root package name */
    private static final int f47618b;

    /* renamed from: c  reason: collision with root package name */
    private static final int f47619c;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f47617a = availableProcessors;
        f47618b = (availableProcessors * 2) + 1;
        f47619c = availableProcessors + 1;
    }

    public static ExecutorService a() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f47619c, f47618b, 1, TimeUnit.SECONDS, new LinkedBlockingQueue());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }
}
