package com.newrelic.agent.android.util;

import com.talabat.sidemenu.SideMenuRewardViewHolder;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class NamedThreadFactory implements ThreadFactory {
    final ThreadGroup group = Thread.currentThread().getThreadGroup();
    final String namePrefix;
    final AtomicInteger threadNumber = new AtomicInteger(1);

    public NamedThreadFactory(String str) {
        this.namePrefix = "NR_" + str + SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE;
    }

    public Thread newThread(Runnable runnable) {
        ThreadGroup threadGroup = this.group;
        String str = this.namePrefix;
        int andIncrement = this.threadNumber.getAndIncrement();
        Thread thread = new Thread(threadGroup, runnable, str + andIncrement, 0);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (thread.getPriority() != 5) {
            thread.setPriority(5);
        }
        return thread;
    }
}
