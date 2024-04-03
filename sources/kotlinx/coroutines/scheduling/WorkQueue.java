package kotlinx.coroutines.scheduling;

import i9.o;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v0.a;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0000\b\u0000\u0018\u00002\u00020*B\u0007¢\u0006\u0004\b\u0001\u0010\u0002J!\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0000¢\u0006\u0004\b\u001a\u0010\u0019J\u001f\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001e\u001a\u00020\r*\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\u001c\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030 8\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010&\u001a\u00020#8@X\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0014\u0010(\u001a\u00020#8@X\u0004¢\u0006\u0006\u001a\u0004\b'\u0010%¨\u0006)"}, d2 = {"Lkotlinx/coroutines/scheduling/WorkQueue;", "<init>", "()V", "Lkotlinx/coroutines/scheduling/Task;", "task", "", "fair", "add", "(Lkotlinx/coroutines/scheduling/Task;Z)Lkotlinx/coroutines/scheduling/Task;", "addLast", "(Lkotlinx/coroutines/scheduling/Task;)Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalQueue", "", "offloadAllWorkTo", "(Lkotlinx/coroutines/scheduling/GlobalQueue;)V", "poll", "()Lkotlinx/coroutines/scheduling/Task;", "pollBuffer", "queue", "pollTo", "(Lkotlinx/coroutines/scheduling/GlobalQueue;)Z", "victim", "", "tryStealBlockingFrom", "(Lkotlinx/coroutines/scheduling/WorkQueue;)J", "tryStealFrom", "blockingOnly", "tryStealLastScheduled", "(Lkotlinx/coroutines/scheduling/WorkQueue;Z)J", "decrementIfBlocking", "(Lkotlinx/coroutines/scheduling/Task;)V", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "buffer", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "", "getBufferSize$kotlinx_coroutines_core", "()I", "bufferSize", "getSize$kotlinx_coroutines_core", "size", "kotlinx-coroutines-core", ""}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WorkQueue {
    private static final /* synthetic */ AtomicIntegerFieldUpdater blockingTasksInBuffer$FU;
    private static final /* synthetic */ AtomicIntegerFieldUpdater consumerIndex$FU;
    private static final /* synthetic */ AtomicReferenceFieldUpdater lastScheduledTask$FU;
    private static final /* synthetic */ AtomicIntegerFieldUpdater producerIndex$FU;
    @NotNull
    private volatile /* synthetic */ int blockingTasksInBuffer = 0;
    @NotNull
    private final AtomicReferenceArray<Task> buffer = new AtomicReferenceArray<>(128);
    @NotNull
    private volatile /* synthetic */ int consumerIndex = 0;
    @NotNull
    private volatile /* synthetic */ Object lastScheduledTask = null;
    @NotNull
    private volatile /* synthetic */ int producerIndex = 0;

    static {
        Class<WorkQueue> cls = WorkQueue.class;
        lastScheduledTask$FU = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "lastScheduledTask");
        producerIndex$FU = AtomicIntegerFieldUpdater.newUpdater(cls, "producerIndex");
        consumerIndex$FU = AtomicIntegerFieldUpdater.newUpdater(cls, "consumerIndex");
        blockingTasksInBuffer$FU = AtomicIntegerFieldUpdater.newUpdater(cls, "blockingTasksInBuffer");
    }

    public static /* synthetic */ Task add$default(WorkQueue workQueue, Task task, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return workQueue.add(task, z11);
    }

    private final Task addLast(Task task) {
        boolean z11 = true;
        if (task.taskContext.getTaskMode() != 1) {
            z11 = false;
        }
        if (z11) {
            blockingTasksInBuffer$FU.incrementAndGet(this);
        }
        if (getBufferSize$kotlinx_coroutines_core() == 127) {
            return task;
        }
        int i11 = this.producerIndex & 127;
        while (this.buffer.get(i11) != null) {
            Thread.yield();
        }
        this.buffer.lazySet(i11, task);
        producerIndex$FU.incrementAndGet(this);
        return null;
    }

    private final void decrementIfBlocking(Task task) {
        if (task != null) {
            boolean z11 = true;
            if (task.taskContext.getTaskMode() != 1) {
                z11 = false;
            }
            if (z11) {
                blockingTasksInBuffer$FU.decrementAndGet(this);
            }
        }
    }

    private final Task pollBuffer() {
        Task andSet;
        while (true) {
            int i11 = this.consumerIndex;
            if (i11 - this.producerIndex == 0) {
                return null;
            }
            int i12 = i11 & 127;
            if (consumerIndex$FU.compareAndSet(this, i11, i11 + 1) && (andSet = this.buffer.getAndSet(i12, (Object) null)) != null) {
                decrementIfBlocking(andSet);
                return andSet;
            }
        }
    }

    private final boolean pollTo(GlobalQueue globalQueue) {
        Task pollBuffer = pollBuffer();
        if (pollBuffer == null) {
            return false;
        }
        globalQueue.addLast(pollBuffer);
        return true;
    }

    private final long tryStealLastScheduled(WorkQueue workQueue, boolean z11) {
        Task task;
        do {
            task = (Task) workQueue.lastScheduledTask;
            if (task == null) {
                return -2;
            }
            if (z11) {
                boolean z12 = true;
                if (task.taskContext.getTaskMode() != 1) {
                    z12 = false;
                }
                if (!z12) {
                    return -2;
                }
            }
            long nanoTime = TasksKt.schedulerTimeSource.nanoTime() - task.submissionTime;
            long j11 = TasksKt.WORK_STEALING_TIME_RESOLUTION_NS;
            if (nanoTime < j11) {
                return j11 - nanoTime;
            }
        } while (!a.a(lastScheduledTask$FU, workQueue, task, (Object) null));
        add$default(this, task, false, 2, (Object) null);
        return -1;
    }

    @Nullable
    public final Task add(@NotNull Task task, boolean z11) {
        if (z11) {
            return addLast(task);
        }
        Task task2 = (Task) lastScheduledTask$FU.getAndSet(this, task);
        if (task2 == null) {
            return null;
        }
        return addLast(task2);
    }

    public final int getBufferSize$kotlinx_coroutines_core() {
        return this.producerIndex - this.consumerIndex;
    }

    public final int getSize$kotlinx_coroutines_core() {
        return this.lastScheduledTask != null ? getBufferSize$kotlinx_coroutines_core() + 1 : getBufferSize$kotlinx_coroutines_core();
    }

    public final void offloadAllWorkTo(@NotNull GlobalQueue globalQueue) {
        Task task = (Task) lastScheduledTask$FU.getAndSet(this, (Object) null);
        if (task != null) {
            globalQueue.addLast(task);
        }
        do {
        } while (pollTo(globalQueue));
    }

    @Nullable
    public final Task poll() {
        Task task = (Task) lastScheduledTask$FU.getAndSet(this, (Object) null);
        return task == null ? pollBuffer() : task;
    }

    public final long tryStealBlockingFrom(@NotNull WorkQueue workQueue) {
        int i11 = workQueue.consumerIndex;
        int i12 = workQueue.producerIndex;
        AtomicReferenceArray<Task> atomicReferenceArray = workQueue.buffer;
        while (true) {
            boolean z11 = true;
            if (i11 == i12) {
                break;
            }
            int i13 = i11 & 127;
            if (workQueue.blockingTasksInBuffer == 0) {
                break;
            }
            Task task = atomicReferenceArray.get(i13);
            if (task != null) {
                if (task.taskContext.getTaskMode() != 1) {
                    z11 = false;
                }
                if (z11 && o.a(atomicReferenceArray, i13, task, (Object) null)) {
                    blockingTasksInBuffer$FU.decrementAndGet(workQueue);
                    add$default(this, task, false, 2, (Object) null);
                    return -1;
                }
            }
            i11++;
        }
        return tryStealLastScheduled(workQueue, true);
    }

    public final long tryStealFrom(@NotNull WorkQueue workQueue) {
        Task pollBuffer = workQueue.pollBuffer();
        if (pollBuffer == null) {
            return tryStealLastScheduled(workQueue, false);
        }
        add$default(this, pollBuffer, false, 2, (Object) null);
        return -1;
    }
}
