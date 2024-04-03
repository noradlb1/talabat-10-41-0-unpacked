package com.huawei.hms.framework.common;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExcutorEnhance extends ThreadPoolExecutor {
    public ThreadPoolExcutorEnhance(int i11, int i12, long j11, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i11, i12, j11, timeUnit, blockingQueue, threadFactory);
    }

    public void beforeExecute(Thread thread, Runnable runnable) {
        if (runnable instanceof RunnableEnhance) {
            String parentName = ((RunnableEnhance) runnable).getParentName();
            int lastIndexOf = parentName.lastIndexOf(" -->");
            if (lastIndexOf != -1) {
                parentName = StringUtils.substring(parentName, lastIndexOf + 4);
            }
            String name2 = thread.getName();
            int lastIndexOf2 = name2.lastIndexOf(" -->");
            if (lastIndexOf2 != -1) {
                name2 = StringUtils.substring(name2, lastIndexOf2 + 4);
            }
            thread.setName(parentName + " -->" + name2);
        }
        super.beforeExecute(thread, runnable);
    }

    public void execute(Runnable runnable) {
        super.execute(new RunnableEnhance(runnable));
    }

    public ThreadPoolExcutorEnhance(int i11, int i12, int i13, TimeUnit timeUnit, LinkedBlockingQueue<Runnable> linkedBlockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i11, i12, (long) i13, timeUnit, linkedBlockingQueue, threadFactory, rejectedExecutionHandler);
    }
}
