package okhttp3.internal.concurrent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u00013B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010!\u001a\u00020\"J\r\u0010#\u001a\u00020\u000eH\u0000¢\u0006\u0002\b$J8\u0010%\u001a\u00020\"2\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020\u000e2\u000e\b\u0004\u0010)\u001a\b\u0012\u0004\u0012\u00020\"0*H\bø\u0001\u0000J\u0006\u0010+\u001a\u00020,J.\u0010-\u001a\u00020\"2\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010&\u001a\u00020'2\u000e\b\u0004\u0010)\u001a\b\u0012\u0004\u0012\u00020'0*H\bø\u0001\u0000J\u0018\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020\b2\b\b\u0002\u0010&\u001a\u00020'J%\u0010/\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\b2\u0006\u0010&\u001a\u00020'2\u0006\u00100\u001a\u00020\u000eH\u0000¢\u0006\u0002\b1J\u0006\u0010\u001c\u001a\u00020\"J\b\u00102\u001a\u00020\u0005H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0016R\u001a\u0010\u001c\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 \u0002\u0007\n\u0005\b20\u0001¨\u00064"}, d2 = {"Lokhttp3/internal/concurrent/TaskQueue;", "", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "name", "", "(Lokhttp3/internal/concurrent/TaskRunner;Ljava/lang/String;)V", "activeTask", "Lokhttp3/internal/concurrent/Task;", "getActiveTask$okhttp", "()Lokhttp3/internal/concurrent/Task;", "setActiveTask$okhttp", "(Lokhttp3/internal/concurrent/Task;)V", "cancelActiveTask", "", "getCancelActiveTask$okhttp", "()Z", "setCancelActiveTask$okhttp", "(Z)V", "futureTasks", "", "getFutureTasks$okhttp", "()Ljava/util/List;", "getName$okhttp", "()Ljava/lang/String;", "scheduledTasks", "", "getScheduledTasks", "shutdown", "getShutdown$okhttp", "setShutdown$okhttp", "getTaskRunner$okhttp", "()Lokhttp3/internal/concurrent/TaskRunner;", "cancelAll", "", "cancelAllAndDecide", "cancelAllAndDecide$okhttp", "execute", "delayNanos", "", "cancelable", "block", "Lkotlin/Function0;", "idleLatch", "Ljava/util/concurrent/CountDownLatch;", "schedule", "task", "scheduleAndDecide", "recurrence", "scheduleAndDecide$okhttp", "toString", "AwaitIdleTask", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TaskQueue {
    @Nullable
    private Task activeTask;
    private boolean cancelActiveTask;
    @NotNull
    private final List<Task> futureTasks = new ArrayList();
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f27528name;
    private boolean shutdown;
    @NotNull
    private final TaskRunner taskRunner;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lokhttp3/internal/concurrent/TaskQueue$AwaitIdleTask;", "Lokhttp3/internal/concurrent/Task;", "()V", "latch", "Ljava/util/concurrent/CountDownLatch;", "getLatch", "()Ljava/util/concurrent/CountDownLatch;", "runOnce", "", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class AwaitIdleTask extends Task {
        @NotNull
        private final CountDownLatch latch = new CountDownLatch(1);

        public AwaitIdleTask() {
            super(Intrinsics.stringPlus(Util.okHttpName, " awaitIdle"), false);
        }

        @NotNull
        public final CountDownLatch getLatch() {
            return this.latch;
        }

        public long runOnce() {
            this.latch.countDown();
            return -1;
        }
    }

    public TaskQueue(@NotNull TaskRunner taskRunner2, @NotNull String str) {
        Intrinsics.checkNotNullParameter(taskRunner2, "taskRunner");
        Intrinsics.checkNotNullParameter(str, "name");
        this.taskRunner = taskRunner2;
        this.f27528name = str;
    }

    public static /* synthetic */ void execute$default(TaskQueue taskQueue, String str, long j11, boolean z11, Function0 function0, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            j11 = 0;
        }
        if ((i11 & 4) != 0) {
            z11 = true;
        }
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function0, "block");
        taskQueue.schedule(new TaskQueue$execute$1(str, z11, function0), j11);
    }

    public static /* synthetic */ void schedule$default(TaskQueue taskQueue, Task task, long j11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            j11 = 0;
        }
        taskQueue.schedule(task, j11);
    }

    public final void cancelAll() {
        if (!Util.assertionsEnabled || !Thread.holdsLock(this)) {
            synchronized (this.taskRunner) {
                if (cancelAllAndDecide$okhttp()) {
                    getTaskRunner$okhttp().kickCoordinator$okhttp(this);
                }
                Unit unit = Unit.INSTANCE;
            }
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    public final boolean cancelAllAndDecide$okhttp() {
        Task task = this.activeTask;
        if (task != null) {
            Intrinsics.checkNotNull(task);
            if (task.getCancelable()) {
                this.cancelActiveTask = true;
            }
        }
        int size = this.futureTasks.size() - 1;
        boolean z11 = false;
        if (size >= 0) {
            while (true) {
                int i11 = size - 1;
                if (this.futureTasks.get(size).getCancelable()) {
                    Task task2 = this.futureTasks.get(size);
                    if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
                        TaskLoggerKt.log(task2, this, "canceled");
                    }
                    this.futureTasks.remove(size);
                    z11 = true;
                }
                if (i11 < 0) {
                    break;
                }
                size = i11;
            }
        }
        return z11;
    }

    public final void execute(@NotNull String str, long j11, boolean z11, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function0, "block");
        schedule(new TaskQueue$execute$1(str, z11, function0), j11);
    }

    @Nullable
    public final Task getActiveTask$okhttp() {
        return this.activeTask;
    }

    public final boolean getCancelActiveTask$okhttp() {
        return this.cancelActiveTask;
    }

    @NotNull
    public final List<Task> getFutureTasks$okhttp() {
        return this.futureTasks;
    }

    @NotNull
    public final String getName$okhttp() {
        return this.f27528name;
    }

    @NotNull
    public final List<Task> getScheduledTasks() {
        List<Task> list;
        synchronized (this.taskRunner) {
            list = CollectionsKt___CollectionsKt.toList(getFutureTasks$okhttp());
        }
        return list;
    }

    public final boolean getShutdown$okhttp() {
        return this.shutdown;
    }

    @NotNull
    public final TaskRunner getTaskRunner$okhttp() {
        return this.taskRunner;
    }

    @NotNull
    public final CountDownLatch idleLatch() {
        synchronized (this.taskRunner) {
            if (getActiveTask$okhttp() != null || !getFutureTasks$okhttp().isEmpty()) {
                Task activeTask$okhttp = getActiveTask$okhttp();
                if (activeTask$okhttp instanceof AwaitIdleTask) {
                    CountDownLatch latch = ((AwaitIdleTask) activeTask$okhttp).getLatch();
                    return latch;
                }
                for (Task next : getFutureTasks$okhttp()) {
                    if (next instanceof AwaitIdleTask) {
                        CountDownLatch latch2 = ((AwaitIdleTask) next).getLatch();
                        return latch2;
                    }
                }
                AwaitIdleTask awaitIdleTask = new AwaitIdleTask();
                if (scheduleAndDecide$okhttp(awaitIdleTask, 0, false)) {
                    getTaskRunner$okhttp().kickCoordinator$okhttp(this);
                }
                CountDownLatch latch3 = awaitIdleTask.getLatch();
                return latch3;
            }
            CountDownLatch countDownLatch = new CountDownLatch(0);
            return countDownLatch;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0028, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void schedule(@org.jetbrains.annotations.NotNull okhttp3.internal.concurrent.Task r3, long r4) {
        /*
            r2 = this;
            java.lang.String r0 = "task"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            okhttp3.internal.concurrent.TaskRunner r0 = r2.taskRunner
            monitor-enter(r0)
            boolean r1 = r2.getShutdown$okhttp()     // Catch:{ all -> 0x0054 }
            if (r1 == 0) goto L_0x0042
            boolean r4 = r3.getCancelable()     // Catch:{ all -> 0x0054 }
            if (r4 == 0) goto L_0x0029
            okhttp3.internal.concurrent.TaskRunner$Companion r4 = okhttp3.internal.concurrent.TaskRunner.Companion     // Catch:{ all -> 0x0054 }
            java.util.logging.Logger r4 = r4.getLogger()     // Catch:{ all -> 0x0054 }
            java.util.logging.Level r5 = java.util.logging.Level.FINE     // Catch:{ all -> 0x0054 }
            boolean r4 = r4.isLoggable(r5)     // Catch:{ all -> 0x0054 }
            if (r4 == 0) goto L_0x0027
            java.lang.String r4 = "schedule canceled (queue is shutdown)"
            okhttp3.internal.concurrent.TaskLoggerKt.log(r3, r2, r4)     // Catch:{ all -> 0x0054 }
        L_0x0027:
            monitor-exit(r0)
            return
        L_0x0029:
            okhttp3.internal.concurrent.TaskRunner$Companion r4 = okhttp3.internal.concurrent.TaskRunner.Companion     // Catch:{ all -> 0x0054 }
            java.util.logging.Logger r4 = r4.getLogger()     // Catch:{ all -> 0x0054 }
            java.util.logging.Level r5 = java.util.logging.Level.FINE     // Catch:{ all -> 0x0054 }
            boolean r4 = r4.isLoggable(r5)     // Catch:{ all -> 0x0054 }
            if (r4 == 0) goto L_0x003c
            java.lang.String r4 = "schedule failed (queue is shutdown)"
            okhttp3.internal.concurrent.TaskLoggerKt.log(r3, r2, r4)     // Catch:{ all -> 0x0054 }
        L_0x003c:
            java.util.concurrent.RejectedExecutionException r3 = new java.util.concurrent.RejectedExecutionException     // Catch:{ all -> 0x0054 }
            r3.<init>()     // Catch:{ all -> 0x0054 }
            throw r3     // Catch:{ all -> 0x0054 }
        L_0x0042:
            r1 = 0
            boolean r3 = r2.scheduleAndDecide$okhttp(r3, r4, r1)     // Catch:{ all -> 0x0054 }
            if (r3 == 0) goto L_0x0050
            okhttp3.internal.concurrent.TaskRunner r3 = r2.getTaskRunner$okhttp()     // Catch:{ all -> 0x0054 }
            r3.kickCoordinator$okhttp(r2)     // Catch:{ all -> 0x0054 }
        L_0x0050:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0054 }
            monitor-exit(r0)
            return
        L_0x0054:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.concurrent.TaskQueue.schedule(okhttp3.internal.concurrent.Task, long):void");
    }

    public final boolean scheduleAndDecide$okhttp(@NotNull Task task, long j11, boolean z11) {
        boolean z12;
        String str;
        Intrinsics.checkNotNullParameter(task, "task");
        task.initQueue$okhttp(this);
        long nanoTime = this.taskRunner.getBackend().nanoTime();
        long j12 = nanoTime + j11;
        int indexOf = this.futureTasks.indexOf(task);
        if (indexOf != -1) {
            if (task.getNextExecuteNanoTime$okhttp() <= j12) {
                if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
                    TaskLoggerKt.log(task, this, "already scheduled");
                }
                return false;
            }
            this.futureTasks.remove(indexOf);
        }
        task.setNextExecuteNanoTime$okhttp(j12);
        if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
            if (z11) {
                str = Intrinsics.stringPlus("run again after ", TaskLoggerKt.formatDuration(j12 - nanoTime));
            } else {
                str = Intrinsics.stringPlus("scheduled after ", TaskLoggerKt.formatDuration(j12 - nanoTime));
            }
            TaskLoggerKt.log(task, this, str);
        }
        Iterator<Task> it = this.futureTasks.iterator();
        int i11 = 0;
        while (true) {
            if (!it.hasNext()) {
                i11 = -1;
                break;
            }
            if (it.next().getNextExecuteNanoTime$okhttp() - nanoTime > j11) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                break;
            }
            i11++;
        }
        if (i11 == -1) {
            i11 = this.futureTasks.size();
        }
        this.futureTasks.add(i11, task);
        if (i11 == 0) {
            return true;
        }
        return false;
    }

    public final void setActiveTask$okhttp(@Nullable Task task) {
        this.activeTask = task;
    }

    public final void setCancelActiveTask$okhttp(boolean z11) {
        this.cancelActiveTask = z11;
    }

    public final void setShutdown$okhttp(boolean z11) {
        this.shutdown = z11;
    }

    public final void shutdown() {
        if (!Util.assertionsEnabled || !Thread.holdsLock(this)) {
            synchronized (this.taskRunner) {
                setShutdown$okhttp(true);
                if (cancelAllAndDecide$okhttp()) {
                    getTaskRunner$okhttp().kickCoordinator$okhttp(this);
                }
                Unit unit = Unit.INSTANCE;
            }
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    @NotNull
    public String toString() {
        return this.f27528name;
    }

    public static /* synthetic */ void schedule$default(TaskQueue taskQueue, String str, long j11, Function0 function0, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            j11 = 0;
        }
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function0, "block");
        taskQueue.schedule(new TaskQueue$schedule$2(str, function0), j11);
    }

    public final void schedule(@NotNull String str, long j11, @NotNull Function0<Long> function0) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function0, "block");
        schedule(new TaskQueue$schedule$2(str, function0), j11);
    }
}
