package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.ArrayQueue;
import kotlinx.coroutines.internal.LimitedDispatcherKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0006\u0010\u0007\u001a\u00020\u0002J\b\u0010\b\u001a\u00020\u0002H\u0016J\u0012\u0010\f\u001a\u00020\u000b2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tJ\u0010\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u000fJ\b\u0010\u0012\u001a\u00020\u000bH\u0016R\u0016\u0010\u0013\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0018\u00010\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00048TX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001d\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001eR\u0011\u0010 \u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b \u0010\u001e¨\u0006#"}, d2 = {"Lkotlinx/coroutines/EventLoop;", "Lkotlinx/coroutines/CoroutineDispatcher;", "", "unconfined", "", "delta", "processNextEvent", "processUnconfinedEvent", "shouldBeProcessedFromContext", "Lkotlinx/coroutines/DispatchedTask;", "task", "", "dispatchUnconfined", "incrementUseCount", "decrementUseCount", "", "parallelism", "limitedParallelism", "shutdown", "useCount", "J", "shared", "Z", "Lkotlinx/coroutines/internal/ArrayQueue;", "unconfinedQueue", "Lkotlinx/coroutines/internal/ArrayQueue;", "a", "()J", "nextTime", "isActive", "()Z", "isUnconfinedLoopActive", "isUnconfinedQueueEmpty", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public abstract class EventLoop extends CoroutineDispatcher {
    private boolean shared;
    @Nullable
    private ArrayQueue<DispatchedTask<?>> unconfinedQueue;
    private long useCount;

    public static /* synthetic */ void decrementUseCount$default(EventLoop eventLoop, boolean z11, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 1) != 0) {
                z11 = false;
            }
            eventLoop.decrementUseCount(z11);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrementUseCount");
    }

    private final long delta(boolean z11) {
        return z11 ? 4294967296L : 1;
    }

    public static /* synthetic */ void incrementUseCount$default(EventLoop eventLoop, boolean z11, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 1) != 0) {
                z11 = false;
            }
            eventLoop.incrementUseCount(z11);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
    }

    public long a() {
        ArrayQueue<DispatchedTask<?>> arrayQueue = this.unconfinedQueue;
        if (arrayQueue != null && !arrayQueue.isEmpty()) {
            return 0;
        }
        return Long.MAX_VALUE;
    }

    public final void decrementUseCount(boolean z11) {
        long delta = this.useCount - delta(z11);
        this.useCount = delta;
        if (delta <= 0 && this.shared) {
            shutdown();
        }
    }

    public final void dispatchUnconfined(@NotNull DispatchedTask<?> dispatchedTask) {
        ArrayQueue<DispatchedTask<?>> arrayQueue = this.unconfinedQueue;
        if (arrayQueue == null) {
            arrayQueue = new ArrayQueue<>();
            this.unconfinedQueue = arrayQueue;
        }
        arrayQueue.addLast(dispatchedTask);
    }

    public final void incrementUseCount(boolean z11) {
        this.useCount += delta(z11);
        if (!z11) {
            this.shared = true;
        }
    }

    public final boolean isActive() {
        return this.useCount > 0;
    }

    public final boolean isUnconfinedLoopActive() {
        return this.useCount >= delta(true);
    }

    public final boolean isUnconfinedQueueEmpty() {
        ArrayQueue<DispatchedTask<?>> arrayQueue = this.unconfinedQueue;
        if (arrayQueue != null) {
            return arrayQueue.isEmpty();
        }
        return true;
    }

    @NotNull
    public final CoroutineDispatcher limitedParallelism(int i11) {
        LimitedDispatcherKt.checkParallelism(i11);
        return this;
    }

    public long processNextEvent() {
        return !processUnconfinedEvent() ? Long.MAX_VALUE : 0;
    }

    public final boolean processUnconfinedEvent() {
        DispatchedTask removeFirstOrNull;
        ArrayQueue<DispatchedTask<?>> arrayQueue = this.unconfinedQueue;
        if (arrayQueue == null || (removeFirstOrNull = arrayQueue.removeFirstOrNull()) == null) {
            return false;
        }
        removeFirstOrNull.run();
        return true;
    }

    public boolean shouldBeProcessedFromContext() {
        return false;
    }

    public void shutdown() {
    }
}
