package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.Thread;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
@J2ktIncompatible
public final class ThreadFactoryBuilder {
    @CheckForNull
    private ThreadFactory backingThreadFactory = null;
    @CheckForNull
    private Boolean daemon = null;
    @CheckForNull
    private String nameFormat = null;
    @CheckForNull
    private Integer priority = null;
    @CheckForNull
    private Thread.UncaughtExceptionHandler uncaughtExceptionHandler = null;

    private static ThreadFactory doBuild(ThreadFactoryBuilder threadFactoryBuilder) {
        AtomicLong atomicLong;
        final String str = threadFactoryBuilder.nameFormat;
        final Boolean bool = threadFactoryBuilder.daemon;
        final Integer num = threadFactoryBuilder.priority;
        final Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = threadFactoryBuilder.uncaughtExceptionHandler;
        ThreadFactory threadFactory = threadFactoryBuilder.backingThreadFactory;
        if (threadFactory == null) {
            threadFactory = Executors.defaultThreadFactory();
        }
        final ThreadFactory threadFactory2 = threadFactory;
        if (str != null) {
            atomicLong = new AtomicLong(0);
        } else {
            atomicLong = null;
        }
        final AtomicLong atomicLong2 = atomicLong;
        return new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                Thread newThread = threadFactory2.newThread(runnable);
                Objects.requireNonNull(newThread);
                String str = str;
                if (str != null) {
                    AtomicLong atomicLong = atomicLong2;
                    Objects.requireNonNull(atomicLong);
                    newThread.setName(ThreadFactoryBuilder.format(str, Long.valueOf(atomicLong.getAndIncrement())));
                }
                Boolean bool = bool;
                if (bool != null) {
                    newThread.setDaemon(bool.booleanValue());
                }
                Integer num = num;
                if (num != null) {
                    newThread.setPriority(num.intValue());
                }
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler = uncaughtExceptionHandler2;
                if (uncaughtExceptionHandler != null) {
                    newThread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
                }
                return newThread;
            }
        };
    }

    /* access modifiers changed from: private */
    public static String format(String str, Object... objArr) {
        return String.format(Locale.ROOT, str, objArr);
    }

    public ThreadFactory build() {
        return doBuild(this);
    }

    @CanIgnoreReturnValue
    public ThreadFactoryBuilder setDaemon(boolean z11) {
        this.daemon = Boolean.valueOf(z11);
        return this;
    }

    @CanIgnoreReturnValue
    public ThreadFactoryBuilder setNameFormat(String str) {
        format(str, 0);
        this.nameFormat = str;
        return this;
    }

    @CanIgnoreReturnValue
    public ThreadFactoryBuilder setPriority(int i11) {
        boolean z11;
        boolean z12 = false;
        if (i11 >= 1) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "Thread priority (%s) must be >= %s", i11, 1);
        if (i11 <= 10) {
            z12 = true;
        }
        Preconditions.checkArgument(z12, "Thread priority (%s) must be <= %s", i11, 10);
        this.priority = Integer.valueOf(i11);
        return this;
    }

    @CanIgnoreReturnValue
    public ThreadFactoryBuilder setThreadFactory(ThreadFactory threadFactory) {
        this.backingThreadFactory = (ThreadFactory) Preconditions.checkNotNull(threadFactory);
        return this;
    }

    @CanIgnoreReturnValue
    public ThreadFactoryBuilder setUncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler2) {
        this.uncaughtExceptionHandler = (Thread.UncaughtExceptionHandler) Preconditions.checkNotNull(uncaughtExceptionHandler2);
        return this;
    }
}
