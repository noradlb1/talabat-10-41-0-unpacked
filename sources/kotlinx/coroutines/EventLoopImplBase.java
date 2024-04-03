package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.DurationKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import kotlinx.coroutines.internal.ThreadSafeHeap;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v0.a;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\b \u0018\u00002\u00020\u00012\u00020\u0002:\u0004789:B\u0007¢\u0006\u0004\b6\u0010\rJ\u001b\u0010\u0007\u001a\u00020\u00062\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0017\u0010\rJ\u000f\u0010\u0018\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0018\u0010\rJ%\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00112\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ#\u0010 \u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u00112\n\u0010\u001e\u001a\u00060\u0003j\u0002`\u0004H\u0004¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\"\u0010#J!\u0010&\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020$2\n\u0010\u001e\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b&\u0010'J\u001b\u0010(\u001a\u00020\u000b2\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004H\u0016¢\u0006\u0004\b(\u0010)J\u001d\u0010*\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000e¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u000bH\u0004¢\u0006\u0004\b,\u0010\rR$\u0010.\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00068B@BX\u000e¢\u0006\f\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0014\u00103\u001a\u00020\u00068TX\u0004¢\u0006\u0006\u001a\u0004\b2\u0010/R\u0014\u00105\u001a\u00020\u00118TX\u0004¢\u0006\u0006\u001a\u0004\b4\u0010#¨\u0006;"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase;", "Lkotlinx/coroutines/EventLoopImplPlatform;", "Lkotlinx/coroutines/Delay;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "task", "", "enqueueImpl", "(Ljava/lang/Runnable;)Z", "dequeue", "()Ljava/lang/Runnable;", "", "closeQueue", "()V", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "shouldUnpark", "(Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;)Z", "", "now", "delayedTask", "", "scheduleImpl", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)I", "rescheduleAllDelayed", "shutdown", "timeMillis", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "scheduleResumeAfterDelay", "(JLkotlinx/coroutines/CancellableContinuation;)V", "block", "Lkotlinx/coroutines/DisposableHandle;", "g", "(JLjava/lang/Runnable;)Lkotlinx/coroutines/DisposableHandle;", "processNextEvent", "()J", "Lkotlin/coroutines/CoroutineContext;", "context", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "enqueue", "(Ljava/lang/Runnable;)V", "schedule", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)V", "f", "value", "isCompleted", "()Z", "setCompleted", "(Z)V", "e", "isEmpty", "a", "nextTime", "<init>", "DelayedResumeTask", "DelayedRunnableTask", "DelayedTask", "DelayedTaskQueue", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public abstract class EventLoopImplBase extends EventLoopImplPlatform implements Delay {
    private static final /* synthetic */ AtomicReferenceFieldUpdater _delayed$FU;
    private static final /* synthetic */ AtomicReferenceFieldUpdater _queue$FU;
    @NotNull
    private volatile /* synthetic */ Object _delayed = null;
    @NotNull
    private volatile /* synthetic */ int _isCompleted = 0;
    @NotNull
    private volatile /* synthetic */ Object _queue = null;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedResumeTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "nanoTime", "", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/EventLoopImplBase;JLkotlinx/coroutines/CancellableContinuation;)V", "run", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class DelayedResumeTask extends DelayedTask {
        @NotNull
        private final CancellableContinuation<Unit> cont;

        public DelayedResumeTask(long j11, @NotNull CancellableContinuation<? super Unit> cancellableContinuation) {
            super(j11);
            this.cont = cancellableContinuation;
        }

        public void run() {
            this.cont.resumeUndispatched(EventLoopImplBase.this, Unit.INSTANCE);
        }

        @NotNull
        public String toString() {
            return super.toString() + this.cont;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0012\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedRunnableTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "nanoTime", "", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "(JLjava/lang/Runnable;)V", "run", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class DelayedRunnableTask extends DelayedTask {
        @NotNull
        private final Runnable block;

        public DelayedRunnableTask(long j11, @NotNull Runnable runnable) {
            super(j11);
            this.block = runnable;
        }

        public void run() {
            this.block.run();
        }

        @NotNull
        public String toString() {
            return super.toString() + this.block;
        }
    }

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b \u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u00032\u00020\u00042\u00020\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0011\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0000H\u0002J\u0006\u0010\u001a\u001a\u00020\u001bJ\u001e\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020\u0007J\b\u0010$\u001a\u00020%H\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R0\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f2\f\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f8V@VX\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "nanoTime", "", "(J)V", "_heap", "", "value", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "heap", "getHeap", "()Lkotlinx/coroutines/internal/ThreadSafeHeap;", "setHeap", "(Lkotlinx/coroutines/internal/ThreadSafeHeap;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "compareTo", "other", "dispose", "", "scheduleTask", "now", "delayed", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "eventLoop", "Lkotlinx/coroutines/EventLoopImplBase;", "timeToExecute", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static abstract class DelayedTask implements Runnable, Comparable<DelayedTask>, DisposableHandle, ThreadSafeHeapNode {
        @Nullable
        private volatile Object _heap;
        private int index = -1;
        @JvmField
        public long nanoTime;

        public DelayedTask(long j11) {
            this.nanoTime = j11;
        }

        public final synchronized void dispose() {
            DelayedTaskQueue delayedTaskQueue;
            Object obj = this._heap;
            if (obj != EventLoop_commonKt.DISPOSED_TASK) {
                if (obj instanceof DelayedTaskQueue) {
                    delayedTaskQueue = (DelayedTaskQueue) obj;
                } else {
                    delayedTaskQueue = null;
                }
                if (delayedTaskQueue != null) {
                    delayedTaskQueue.remove(this);
                }
                this._heap = EventLoop_commonKt.DISPOSED_TASK;
            }
        }

        @Nullable
        public ThreadSafeHeap<?> getHeap() {
            Object obj = this._heap;
            if (obj instanceof ThreadSafeHeap) {
                return (ThreadSafeHeap) obj;
            }
            return null;
        }

        public int getIndex() {
            return this.index;
        }

        public final synchronized int scheduleTask(long j11, @NotNull DelayedTaskQueue delayedTaskQueue, @NotNull EventLoopImplBase eventLoopImplBase) {
            if (this._heap == EventLoop_commonKt.DISPOSED_TASK) {
                return 2;
            }
            synchronized (delayedTaskQueue) {
                DelayedTask delayedTask = (DelayedTask) delayedTaskQueue.firstImpl();
                if (eventLoopImplBase.isCompleted()) {
                    return 1;
                }
                if (delayedTask == null) {
                    delayedTaskQueue.timeNow = j11;
                } else {
                    long j12 = delayedTask.nanoTime;
                    if (j12 - j11 < 0) {
                        j11 = j12;
                    }
                    if (j11 - delayedTaskQueue.timeNow > 0) {
                        delayedTaskQueue.timeNow = j11;
                    }
                }
                long j13 = this.nanoTime;
                long j14 = delayedTaskQueue.timeNow;
                if (j13 - j14 < 0) {
                    this.nanoTime = j14;
                }
                delayedTaskQueue.addImpl(this);
                return 0;
            }
        }

        public void setHeap(@Nullable ThreadSafeHeap<?> threadSafeHeap) {
            boolean z11;
            if (this._heap != EventLoop_commonKt.DISPOSED_TASK) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                this._heap = threadSafeHeap;
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        public void setIndex(int i11) {
            this.index = i11;
        }

        public final boolean timeToExecute(long j11) {
            return j11 - this.nanoTime >= 0;
        }

        @NotNull
        public String toString() {
            return "Delayed[nanos=" + this.nanoTime + AbstractJsonLexerKt.END_LIST;
        }

        public int compareTo(@NotNull DelayedTask delayedTask) {
            int i11 = ((this.nanoTime - delayedTask.nanoTime) > 0 ? 1 : ((this.nanoTime - delayedTask.nanoTime) == 0 ? 0 : -1));
            if (i11 > 0) {
                return 1;
            }
            return i11 < 0 ? -1 : 0;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "timeNow", "", "(J)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class DelayedTaskQueue extends ThreadSafeHeap<DelayedTask> {
        @JvmField
        public long timeNow;

        public DelayedTaskQueue(long j11) {
            this.timeNow = j11;
        }
    }

    static {
        Class<EventLoopImplBase> cls = EventLoopImplBase.class;
        Class<Object> cls2 = Object.class;
        _queue$FU = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_queue");
        _delayed$FU = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_delayed");
    }

    private final void closeQueue() {
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                if (a.a(_queue$FU, this, (Object) null, EventLoop_commonKt.CLOSED_EMPTY)) {
                    return;
                }
            } else if (obj instanceof LockFreeTaskQueueCore) {
                ((LockFreeTaskQueueCore) obj).close();
                return;
            } else if (obj != EventLoop_commonKt.CLOSED_EMPTY) {
                LockFreeTaskQueueCore lockFreeTaskQueueCore = new LockFreeTaskQueueCore(8, true);
                lockFreeTaskQueueCore.addLast((Runnable) obj);
                if (a.a(_queue$FU, this, obj, lockFreeTaskQueueCore)) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    private final Runnable dequeue() {
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                return null;
            }
            if (obj instanceof LockFreeTaskQueueCore) {
                LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) obj;
                Object removeFirstOrNull = lockFreeTaskQueueCore.removeFirstOrNull();
                if (removeFirstOrNull != LockFreeTaskQueueCore.REMOVE_FROZEN) {
                    return (Runnable) removeFirstOrNull;
                }
                a.a(_queue$FU, this, obj, lockFreeTaskQueueCore.next());
            } else if (obj == EventLoop_commonKt.CLOSED_EMPTY) {
                return null;
            } else {
                if (a.a(_queue$FU, this, obj, (Object) null)) {
                    return (Runnable) obj;
                }
            }
        }
    }

    private final boolean enqueueImpl(Runnable runnable) {
        while (true) {
            Object obj = this._queue;
            if (isCompleted()) {
                return false;
            }
            if (obj == null) {
                if (a.a(_queue$FU, this, (Object) null, runnable)) {
                    return true;
                }
            } else if (obj instanceof LockFreeTaskQueueCore) {
                LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) obj;
                int addLast = lockFreeTaskQueueCore.addLast(runnable);
                if (addLast == 0) {
                    return true;
                }
                if (addLast == 1) {
                    a.a(_queue$FU, this, obj, lockFreeTaskQueueCore.next());
                } else if (addLast == 2) {
                    return false;
                }
            } else if (obj == EventLoop_commonKt.CLOSED_EMPTY) {
                return false;
            } else {
                LockFreeTaskQueueCore lockFreeTaskQueueCore2 = new LockFreeTaskQueueCore(8, true);
                lockFreeTaskQueueCore2.addLast((Runnable) obj);
                lockFreeTaskQueueCore2.addLast(runnable);
                if (a.a(_queue$FU, this, obj, lockFreeTaskQueueCore2)) {
                    return true;
                }
            }
        }
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [int, boolean] */
    /* access modifiers changed from: private */
    public final boolean isCompleted() {
        return this._isCompleted;
    }

    private final void rescheduleAllDelayed() {
        long j11;
        DelayedTask delayedTask;
        AbstractTimeSource timeSource = AbstractTimeSourceKt.getTimeSource();
        if (timeSource != null) {
            j11 = timeSource.nanoTime();
        } else {
            j11 = System.nanoTime();
        }
        while (true) {
            DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) this._delayed;
            if (delayedTaskQueue != null && (delayedTask = (DelayedTask) delayedTaskQueue.removeFirstOrNull()) != null) {
                c(j11, delayedTask);
            } else {
                return;
            }
        }
    }

    private final int scheduleImpl(long j11, DelayedTask delayedTask) {
        if (isCompleted()) {
            return 1;
        }
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) this._delayed;
        if (delayedTaskQueue == null) {
            a.a(_delayed$FU, this, (Object) null, new DelayedTaskQueue(j11));
            Object obj = this._delayed;
            Intrinsics.checkNotNull(obj);
            delayedTaskQueue = (DelayedTaskQueue) obj;
        }
        return delayedTask.scheduleTask(j11, delayedTaskQueue, this);
    }

    private final void setCompleted(boolean z11) {
        this._isCompleted = z11 ? 1 : 0;
    }

    private final boolean shouldUnpark(DelayedTask delayedTask) {
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) this._delayed;
        return (delayedTaskQueue != null ? (DelayedTask) delayedTaskQueue.peek() : null) == delayedTask;
    }

    public long a() {
        DelayedTask delayedTask;
        long j11;
        if (super.a() == 0) {
            return 0;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (obj instanceof LockFreeTaskQueueCore) {
                if (!((LockFreeTaskQueueCore) obj).isEmpty()) {
                    return 0;
                }
            } else if (obj == EventLoop_commonKt.CLOSED_EMPTY) {
                return Long.MAX_VALUE;
            } else {
                return 0;
            }
        }
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) this._delayed;
        if (delayedTaskQueue == null || (delayedTask = (DelayedTask) delayedTaskQueue.peek()) == null) {
            return Long.MAX_VALUE;
        }
        long j12 = delayedTask.nanoTime;
        AbstractTimeSource timeSource = AbstractTimeSourceKt.getTimeSource();
        if (timeSource != null) {
            j11 = timeSource.nanoTime();
        } else {
            j11 = System.nanoTime();
        }
        return RangesKt___RangesKt.coerceAtLeast(j12 - j11, 0);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
    @Nullable
    public Object delay(long j11, @NotNull Continuation<? super Unit> continuation) {
        return Delay.DefaultImpls.delay(this, j11, continuation);
    }

    public final void dispatch(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        enqueue(runnable);
    }

    public boolean e() {
        if (!isUnconfinedQueueEmpty()) {
            return false;
        }
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) this._delayed;
        if (delayedTaskQueue != null && !delayedTaskQueue.isEmpty()) {
            return false;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (obj instanceof LockFreeTaskQueueCore) {
                return ((LockFreeTaskQueueCore) obj).isEmpty();
            }
            if (obj != EventLoop_commonKt.CLOSED_EMPTY) {
                return false;
            }
        }
        return true;
    }

    public void enqueue(@NotNull Runnable runnable) {
        if (enqueueImpl(runnable)) {
            d();
        } else {
            DefaultExecutor.INSTANCE.enqueue(runnable);
        }
    }

    public final void f() {
        this._queue = null;
        this._delayed = null;
    }

    @NotNull
    public final DisposableHandle g(long j11, @NotNull Runnable runnable) {
        long j12;
        long delayToNanos = EventLoop_commonKt.delayToNanos(j11);
        if (delayToNanos >= DurationKt.MAX_MILLIS) {
            return NonDisposableHandle.INSTANCE;
        }
        AbstractTimeSource timeSource = AbstractTimeSourceKt.getTimeSource();
        if (timeSource != null) {
            j12 = timeSource.nanoTime();
        } else {
            j12 = System.nanoTime();
        }
        DelayedRunnableTask delayedRunnableTask = new DelayedRunnableTask(delayToNanos + j12, runnable);
        schedule(j12, delayedRunnableTask);
        return delayedRunnableTask;
    }

    @NotNull
    public DisposableHandle invokeOnTimeout(long j11, @NotNull Runnable runnable, @NotNull CoroutineContext coroutineContext) {
        return Delay.DefaultImpls.invokeOnTimeout(this, j11, runnable, coroutineContext);
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0057  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long processNextEvent() {
        /*
            r9 = this;
            boolean r0 = r9.processUnconfinedEvent()
            r1 = 0
            if (r0 == 0) goto L_0x0009
            return r1
        L_0x0009:
            java.lang.Object r0 = r9._delayed
            kotlinx.coroutines.EventLoopImplBase$DelayedTaskQueue r0 = (kotlinx.coroutines.EventLoopImplBase.DelayedTaskQueue) r0
            if (r0 == 0) goto L_0x004d
            boolean r3 = r0.isEmpty()
            if (r3 != 0) goto L_0x004d
            kotlinx.coroutines.AbstractTimeSource r3 = kotlinx.coroutines.AbstractTimeSourceKt.getTimeSource()
            if (r3 == 0) goto L_0x0020
            long r3 = r3.nanoTime()
            goto L_0x0024
        L_0x0020:
            long r3 = java.lang.System.nanoTime()
        L_0x0024:
            monitor-enter(r0)
            kotlinx.coroutines.internal.ThreadSafeHeapNode r5 = r0.firstImpl()     // Catch:{ all -> 0x004a }
            r6 = 0
            if (r5 != 0) goto L_0x002e
            monitor-exit(r0)
            goto L_0x0045
        L_0x002e:
            kotlinx.coroutines.EventLoopImplBase$DelayedTask r5 = (kotlinx.coroutines.EventLoopImplBase.DelayedTask) r5     // Catch:{ all -> 0x004a }
            boolean r7 = r5.timeToExecute(r3)     // Catch:{ all -> 0x004a }
            r8 = 0
            if (r7 == 0) goto L_0x003c
            boolean r5 = r9.enqueueImpl(r5)     // Catch:{ all -> 0x004a }
            goto L_0x003d
        L_0x003c:
            r5 = r8
        L_0x003d:
            if (r5 == 0) goto L_0x0044
            kotlinx.coroutines.internal.ThreadSafeHeapNode r5 = r0.removeAtImpl(r8)     // Catch:{ all -> 0x004a }
            r6 = r5
        L_0x0044:
            monitor-exit(r0)
        L_0x0045:
            kotlinx.coroutines.EventLoopImplBase$DelayedTask r6 = (kotlinx.coroutines.EventLoopImplBase.DelayedTask) r6
            if (r6 != 0) goto L_0x0024
            goto L_0x004d
        L_0x004a:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        L_0x004d:
            java.lang.Runnable r0 = r9.dequeue()
            if (r0 == 0) goto L_0x0057
            r0.run()
            return r1
        L_0x0057:
            long r0 = r9.a()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.EventLoopImplBase.processNextEvent():long");
    }

    public final void schedule(long j11, @NotNull DelayedTask delayedTask) {
        int scheduleImpl = scheduleImpl(j11, delayedTask);
        if (scheduleImpl != 0) {
            if (scheduleImpl == 1) {
                c(j11, delayedTask);
            } else if (scheduleImpl != 2) {
                throw new IllegalStateException("unexpected result".toString());
            }
        } else if (shouldUnpark(delayedTask)) {
            d();
        }
    }

    public void scheduleResumeAfterDelay(long j11, @NotNull CancellableContinuation<? super Unit> cancellableContinuation) {
        long j12;
        long delayToNanos = EventLoop_commonKt.delayToNanos(j11);
        if (delayToNanos < DurationKt.MAX_MILLIS) {
            AbstractTimeSource timeSource = AbstractTimeSourceKt.getTimeSource();
            if (timeSource != null) {
                j12 = timeSource.nanoTime();
            } else {
                j12 = System.nanoTime();
            }
            DelayedResumeTask delayedResumeTask = new DelayedResumeTask(delayToNanos + j12, cancellableContinuation);
            schedule(j12, delayedResumeTask);
            CancellableContinuationKt.disposeOnCancellation(cancellableContinuation, delayedResumeTask);
        }
    }

    public void shutdown() {
        ThreadLocalEventLoop.INSTANCE.resetEventLoop$kotlinx_coroutines_core();
        setCompleted(true);
        closeQueue();
        do {
        } while (processNextEvent() <= 0);
        rescheduleAllDelayed();
    }
}
