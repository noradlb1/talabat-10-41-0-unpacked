package androidx.paging;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/paging/ScheduledExecutor;", "Lio/reactivex/Scheduler;", "Ljava/util/concurrent/Executor;", "scheduler", "(Lio/reactivex/Scheduler;)V", "executor", "(Ljava/util/concurrent/Executor;)V", "createWorker", "Lio/reactivex/Scheduler$Worker;", "execute", "", "command", "Ljava/lang/Runnable;", "paging-rxjava2_release"}, k = 1, mv = {1, 4, 2})
public final class ScheduledExecutor extends Scheduler implements Executor {
    private final Executor executor;
    private final Scheduler scheduler;

    public ScheduledExecutor(@NotNull Scheduler scheduler2) {
        Intrinsics.checkNotNullParameter(scheduler2, "scheduler");
        final Scheduler.Worker createWorker = scheduler2.createWorker();
        Intrinsics.checkNotNullExpressionValue(createWorker, "scheduler.createWorker()");
        this.executor = new Executor() {
            public final void execute(Runnable runnable) {
                createWorker.schedule(runnable);
            }
        };
        this.scheduler = scheduler2;
    }

    @NotNull
    public Scheduler.Worker createWorker() {
        Scheduler.Worker createWorker = this.scheduler.createWorker();
        Intrinsics.checkNotNullExpressionValue(createWorker, "scheduler.createWorker()");
        return createWorker;
    }

    public void execute(@NotNull Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "command");
        this.executor.execute(runnable);
    }

    public ScheduledExecutor(@NotNull Executor executor2) {
        Intrinsics.checkNotNullParameter(executor2, "executor");
        this.executor = executor2;
        Scheduler from = Schedulers.from(executor2);
        Intrinsics.checkNotNullExpressionValue(from, "Schedulers.from(executor)");
        this.scheduler = from;
    }
}
