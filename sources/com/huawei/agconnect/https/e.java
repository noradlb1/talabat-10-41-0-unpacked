package com.huawei.agconnect.https;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public interface e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f47655a = new e() {

        /* renamed from: b  reason: collision with root package name */
        Executor f47656b = new ThreadPoolExecutor(0, 8, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "AGC-Https-Thread");
            }
        });

        public Executor a() {
            return this.f47656b;
        }
    };

    Executor a();
}
