package com.huawei.hms.dtm;

import com.talabat.sidemenu.SideMenuRewardViewHolder;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class r implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicInteger f48672a = new AtomicInteger(1);

    /* renamed from: b  reason: collision with root package name */
    public final String f48673b;

    public r(String str) {
        this.f48673b = str;
    }

    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.f48673b + SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE + this.f48672a.getAndIncrement());
        thread.setUncaughtExceptionHandler(new s());
        thread.setDaemon(false);
        return thread;
    }
}
