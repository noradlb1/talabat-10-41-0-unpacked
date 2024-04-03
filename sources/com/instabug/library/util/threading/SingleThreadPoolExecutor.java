package com.instabug.library.util.threading;

import io.flutter.plugins.firebase.crashlytics.Constants;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SingleThreadPoolExecutor extends ThreadPoolExecutor {
    @Nullable
    private String identifier;
    @Nullable
    private n listener;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SingleThreadPoolExecutor(@NotNull String str) {
        this(str, 0, (TimeUnit) null, (BlockingQueue) null, (ThreadFactory) null, 30, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, Constants.IDENTIFIER);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SingleThreadPoolExecutor(@NotNull String str, long j11) {
        this(str, j11, (TimeUnit) null, (BlockingQueue) null, (ThreadFactory) null, 28, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, Constants.IDENTIFIER);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SingleThreadPoolExecutor(@NotNull String str, long j11, @NotNull TimeUnit timeUnit) {
        this(str, j11, timeUnit, (BlockingQueue) null, (ThreadFactory) null, 24, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, Constants.IDENTIFIER);
        Intrinsics.checkNotNullParameter(timeUnit, "unit");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SingleThreadPoolExecutor(@NotNull String str, long j11, @NotNull TimeUnit timeUnit, @NotNull BlockingQueue<Runnable> blockingQueue) {
        this(str, j11, timeUnit, blockingQueue, (ThreadFactory) null, 16, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, Constants.IDENTIFIER);
        Intrinsics.checkNotNullParameter(timeUnit, "unit");
        Intrinsics.checkNotNullParameter(blockingQueue, "workQueue");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SingleThreadPoolExecutor(String str, long j11, TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? 60 : j11, (i11 & 4) != 0 ? TimeUnit.SECONDS : timeUnit, (i11 & 8) != 0 ? new LinkedBlockingQueue() : blockingQueue, (i11 & 16) != 0 ? new PriorityThreadFactory(str, 10) : threadFactory);
    }

    public void afterExecute(@Nullable Runnable runnable, @Nullable Throwable th2) {
        n nVar;
        try {
            super.afterExecute(runnable, th2);
            if (getActiveCount() == 0 && (nVar = this.listener) != null) {
                nVar.a(this.identifier);
            }
        } catch (Throwable th3) {
            DefensiveRunnableKt.defensiveLog$default(th3, (String) null, 2, (Object) null);
            if (th3 instanceof OutOfMemoryError) {
                DefensiveRunnableKt.reportOOM(th3);
            }
        }
    }

    public void execute(@Nullable Runnable runnable) {
        super.execute(DefensiveRunnableKt.runDefensive(runnable));
    }

    @NotNull
    public SingleThreadPoolExecutor setIdentifier(@Nullable String str) {
        if (str != null) {
            this.identifier = str;
        }
        return this;
    }

    @NotNull
    public SingleThreadPoolExecutor setThreadPoolIdleListener(@Nullable n nVar) {
        this.listener = nVar;
        return this;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SingleThreadPoolExecutor(@NotNull String str, long j11, @NotNull TimeUnit timeUnit, @NotNull BlockingQueue<Runnable> blockingQueue, @NotNull ThreadFactory threadFactory) {
        super(1, 1, j11, timeUnit, blockingQueue, threadFactory);
        Intrinsics.checkNotNullParameter(str, Constants.IDENTIFIER);
        Intrinsics.checkNotNullParameter(timeUnit, "unit");
        Intrinsics.checkNotNullParameter(blockingQueue, "workQueue");
        Intrinsics.checkNotNullParameter(threadFactory, "threadFactory");
    }
}
