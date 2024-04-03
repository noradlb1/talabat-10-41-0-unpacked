package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B!\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014J\r\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u0004\u0018\u00010\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u000f8TX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/BlockingCoroutine;", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "", "state", "", "a", "joinBlocking", "()Ljava/lang/Object;", "Ljava/lang/Thread;", "blockedThread", "Ljava/lang/Thread;", "Lkotlinx/coroutines/EventLoop;", "eventLoop", "Lkotlinx/coroutines/EventLoop;", "", "g", "()Z", "isScopedCoroutine", "Lkotlin/coroutines/CoroutineContext;", "parentContext", "<init>", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Thread;Lkotlinx/coroutines/EventLoop;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
final class BlockingCoroutine<T> extends AbstractCoroutine<T> {
    @NotNull
    private final Thread blockedThread;
    @Nullable
    private final EventLoop eventLoop;

    public BlockingCoroutine(@NotNull CoroutineContext coroutineContext, @NotNull Thread thread, @Nullable EventLoop eventLoop2) {
        super(coroutineContext, true, true);
        this.blockedThread = thread;
        this.eventLoop = eventLoop2;
    }

    public void a(@Nullable Object obj) {
        Unit unit;
        if (!Intrinsics.areEqual((Object) Thread.currentThread(), (Object) this.blockedThread)) {
            Thread thread = this.blockedThread;
            AbstractTimeSource timeSource = AbstractTimeSourceKt.getTimeSource();
            if (timeSource != null) {
                timeSource.unpark(thread);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                LockSupport.unpark(thread);
            }
        }
    }

    public boolean g() {
        return true;
    }

    public final T joinBlocking() {
        long j11;
        Unit unit;
        AbstractTimeSource timeSource = AbstractTimeSourceKt.getTimeSource();
        if (timeSource != null) {
            timeSource.registerTimeLoopThread();
        }
        try {
            EventLoop eventLoop2 = this.eventLoop;
            CompletedExceptionally completedExceptionally = null;
            if (eventLoop2 != null) {
                EventLoop.incrementUseCount$default(eventLoop2, false, 1, (Object) null);
            }
            while (!Thread.interrupted()) {
                EventLoop eventLoop3 = this.eventLoop;
                if (eventLoop3 != null) {
                    j11 = eventLoop3.processNextEvent();
                } else {
                    j11 = Long.MAX_VALUE;
                }
                if (!isCompleted()) {
                    AbstractTimeSource timeSource2 = AbstractTimeSourceKt.getTimeSource();
                    if (timeSource2 != null) {
                        timeSource2.parkNanos(this, j11);
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    if (unit == null) {
                        LockSupport.parkNanos(this, j11);
                    }
                } else {
                    EventLoop eventLoop4 = this.eventLoop;
                    if (eventLoop4 != null) {
                        EventLoop.decrementUseCount$default(eventLoop4, false, 1, (Object) null);
                    }
                    AbstractTimeSource timeSource3 = AbstractTimeSourceKt.getTimeSource();
                    if (timeSource3 != null) {
                        timeSource3.unregisterTimeLoopThread();
                    }
                    T unboxState = JobSupportKt.unboxState(getState$kotlinx_coroutines_core());
                    if (unboxState instanceof CompletedExceptionally) {
                        completedExceptionally = (CompletedExceptionally) unboxState;
                    }
                    if (completedExceptionally == null) {
                        return unboxState;
                    }
                    throw completedExceptionally.cause;
                }
            }
            InterruptedException interruptedException = new InterruptedException();
            cancelCoroutine(interruptedException);
            throw interruptedException;
        } catch (Throwable th2) {
            AbstractTimeSource timeSource4 = AbstractTimeSourceKt.getTimeSource();
            if (timeSource4 != null) {
                timeSource4.unregisterTimeLoopThread();
            }
            throw th2;
        }
    }
}
