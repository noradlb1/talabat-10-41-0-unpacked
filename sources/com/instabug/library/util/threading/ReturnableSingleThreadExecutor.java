package com.instabug.library.util.threading;

import com.instabug.library.apichecker.ReturnableRunnable;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qd.c;

public class ReturnableSingleThreadExecutor extends SingleThreadPoolExecutor {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ReturnableSingleThreadExecutor(@NotNull String str) {
        this(str, 0, (TimeUnit) null, (BlockingQueue) null, (ThreadFactory) null, 30, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, Constants.IDENTIFIER);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ReturnableSingleThreadExecutor(@NotNull String str, long j11) {
        this(str, j11, (TimeUnit) null, (BlockingQueue) null, (ThreadFactory) null, 28, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, Constants.IDENTIFIER);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ReturnableSingleThreadExecutor(@NotNull String str, long j11, @NotNull TimeUnit timeUnit) {
        this(str, j11, timeUnit, (BlockingQueue) null, (ThreadFactory) null, 24, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, Constants.IDENTIFIER);
        Intrinsics.checkNotNullParameter(timeUnit, "unit");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ReturnableSingleThreadExecutor(@NotNull String str, long j11, @NotNull TimeUnit timeUnit, @NotNull BlockingQueue<Runnable> blockingQueue) {
        this(str, j11, timeUnit, blockingQueue, (ThreadFactory) null, 16, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, Constants.IDENTIFIER);
        Intrinsics.checkNotNullParameter(timeUnit, "unit");
        Intrinsics.checkNotNullParameter(blockingQueue, "workQueue");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ReturnableSingleThreadExecutor(String str, long j11, TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? 60 : j11, (i11 & 4) != 0 ? TimeUnit.SECONDS : timeUnit, (i11 & 8) != 0 ? new LinkedBlockingQueue() : blockingQueue, (i11 & 16) != 0 ? new PriorityThreadFactory(str, 10) : threadFactory);
    }

    /* access modifiers changed from: private */
    /* renamed from: executeAndGet$lambda-0  reason: not valid java name */
    public static final Object m9389executeAndGet$lambda0(ReturnableRunnable returnableRunnable) {
        if (returnableRunnable == null) {
            return null;
        }
        try {
            return returnableRunnable.run();
        } catch (Throwable th2) {
            DefensiveRunnableKt.defensiveLog$default(th2, (String) null, 2, (Object) null);
            if (th2 instanceof OutOfMemoryError) {
                DefensiveRunnableKt.reportOOM(th2);
            }
            return null;
        }
    }

    @Nullable
    public <T> T executeAndGet(@Nullable ReturnableRunnable<T> returnableRunnable) {
        try {
            return submit(new c(returnableRunnable)).get();
        } catch (ExecutionException e11) {
            e11.printStackTrace();
            return null;
        } catch (InterruptedException e12) {
            e12.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ReturnableSingleThreadExecutor(@NotNull String str, long j11, @NotNull TimeUnit timeUnit, @NotNull BlockingQueue<Runnable> blockingQueue, @NotNull ThreadFactory threadFactory) {
        super(str, j11, timeUnit, blockingQueue, threadFactory);
        Intrinsics.checkNotNullParameter(str, Constants.IDENTIFIER);
        Intrinsics.checkNotNullParameter(timeUnit, "unit");
        Intrinsics.checkNotNullParameter(blockingQueue, "workQueue");
        Intrinsics.checkNotNullParameter(threadFactory, "threadFactory");
    }
}
