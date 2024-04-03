package com.huawei.hms.dtm.core;

import com.talabat.sidemenu.SideMenuRewardViewHolder;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.huawei.hms.dtm.core.u  reason: case insensitive filesystem */
public class C0442u implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicInteger f48605a = new AtomicInteger(1);

    /* renamed from: b  reason: collision with root package name */
    private final String f48606b;

    public C0442u(String str) {
        this.f48606b = str;
    }

    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.f48606b + SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE + this.f48605a.getAndIncrement());
        thread.setUncaughtExceptionHandler(new C0447v());
        thread.setDaemon(false);
        return thread;
    }
}
