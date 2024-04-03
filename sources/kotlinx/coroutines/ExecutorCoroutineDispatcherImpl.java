package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.internal.ConcurrentKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\tH\u0016J\u001c\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\u0010\u0010\u001a\u00060\u0011j\u0002`\u0012H\u0016J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J$\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\n\u0010\u0010\u001a\u00060\u0011j\u0002`\u00122\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001e\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0016J.\u0010\"\u001a\b\u0012\u0002\b\u0003\u0018\u00010#*\u00020$2\n\u0010\u0010\u001a\u00060\u0011j\u0002`\u00122\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006%"}, d2 = {"Lkotlinx/coroutines/ExecutorCoroutineDispatcherImpl;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "executor", "Ljava/util/concurrent/Executor;", "(Ljava/util/concurrent/Executor;)V", "getExecutor", "()Ljava/util/concurrent/Executor;", "cancelJobOnRejection", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "Ljava/util/concurrent/RejectedExecutionException;", "close", "dispatch", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "equals", "", "other", "", "hashCode", "", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "toString", "", "scheduleBlock", "Ljava/util/concurrent/ScheduledFuture;", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ExecutorCoroutineDispatcherImpl extends ExecutorCoroutineDispatcher implements Delay {
    @NotNull
    private final Executor executor;

    public ExecutorCoroutineDispatcherImpl(@NotNull Executor executor2) {
        this.executor = executor2;
        ConcurrentKt.removeFutureOnCancel(getExecutor());
    }

    private final void cancelJobOnRejection(CoroutineContext coroutineContext, RejectedExecutionException rejectedExecutionException) {
        JobKt.cancel(coroutineContext, ExceptionsKt.CancellationException("The task was rejected", rejectedExecutionException));
    }

    private final ScheduledFuture<?> scheduleBlock(ScheduledExecutorService scheduledExecutorService, Runnable runnable, CoroutineContext coroutineContext, long j11) {
        try {
            return scheduledExecutorService.schedule(runnable, j11, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e11) {
            cancelJobOnRejection(coroutineContext, e11);
            return null;
        }
    }

    public void close() {
        Executor executor2 = getExecutor();
        ExecutorService executorService = executor2 instanceof ExecutorService ? (ExecutorService) executor2 : null;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
    @Nullable
    public Object delay(long j11, @NotNull Continuation<? super Unit> continuation) {
        return Delay.DefaultImpls.delay(this, j11, continuation);
    }

    public void dispatch(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        Runnable runnable2;
        try {
            Executor executor2 = getExecutor();
            AbstractTimeSource timeSource = AbstractTimeSourceKt.getTimeSource();
            if (timeSource == null || (runnable2 = timeSource.wrapTask(runnable)) == null) {
                runnable2 = runnable;
            }
            executor2.execute(runnable2);
        } catch (RejectedExecutionException e11) {
            AbstractTimeSource timeSource2 = AbstractTimeSourceKt.getTimeSource();
            if (timeSource2 != null) {
                timeSource2.unTrackTask();
            }
            cancelJobOnRejection(coroutineContext, e11);
            Dispatchers.getIO().dispatch(coroutineContext, runnable);
        }
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof ExecutorCoroutineDispatcherImpl) && ((ExecutorCoroutineDispatcherImpl) obj).getExecutor() == getExecutor();
    }

    @NotNull
    public Executor getExecutor() {
        return this.executor;
    }

    public int hashCode() {
        return System.identityHashCode(getExecutor());
    }

    @NotNull
    public DisposableHandle invokeOnTimeout(long j11, @NotNull Runnable runnable, @NotNull CoroutineContext coroutineContext) {
        ScheduledExecutorService scheduledExecutorService;
        Executor executor2 = getExecutor();
        ScheduledFuture<?> scheduledFuture = null;
        if (executor2 instanceof ScheduledExecutorService) {
            scheduledExecutorService = (ScheduledExecutorService) executor2;
        } else {
            scheduledExecutorService = null;
        }
        if (scheduledExecutorService != null) {
            scheduledFuture = scheduleBlock(scheduledExecutorService, runnable, coroutineContext, j11);
        }
        if (scheduledFuture != null) {
            return new DisposableFutureHandle(scheduledFuture);
        }
        return DefaultExecutor.INSTANCE.invokeOnTimeout(j11, runnable, coroutineContext);
    }

    public void scheduleResumeAfterDelay(long j11, @NotNull CancellableContinuation<? super Unit> cancellableContinuation) {
        ScheduledExecutorService scheduledExecutorService;
        Executor executor2 = getExecutor();
        ScheduledFuture<?> scheduledFuture = null;
        if (executor2 instanceof ScheduledExecutorService) {
            scheduledExecutorService = (ScheduledExecutorService) executor2;
        } else {
            scheduledExecutorService = null;
        }
        if (scheduledExecutorService != null) {
            scheduledFuture = scheduleBlock(scheduledExecutorService, new ResumeUndispatchedRunnable(this, cancellableContinuation), cancellableContinuation.getContext(), j11);
        }
        if (scheduledFuture != null) {
            JobKt.cancelFutureOnCancellation(cancellableContinuation, scheduledFuture);
        } else {
            DefaultExecutor.INSTANCE.scheduleResumeAfterDelay(j11, cancellableContinuation);
        }
    }

    @NotNull
    public String toString() {
        return getExecutor().toString();
    }
}
