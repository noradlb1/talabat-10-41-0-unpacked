package com.deliveryhero.perseus.hits;

import androidx.work.ExistingWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkContinuation;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/deliveryhero/perseus/hits/WorkerStarterImpl;", "Lcom/deliveryhero/perseus/hits/WorkerStarter;", "workManager", "Landroidx/work/WorkManager;", "(Landroidx/work/WorkManager;)V", "startWorker", "", "initialDelay", "", "existingWorkPolicy", "Landroidx/work/ExistingWorkPolicy;", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class WorkerStarterImpl implements WorkerStarter {
    @NotNull
    private final WorkManager workManager;

    public WorkerStarterImpl(@NotNull WorkManager workManager2) {
        Intrinsics.checkNotNullParameter(workManager2, "workManager");
        this.workManager = workManager2;
    }

    public void startWorker(long j11, @NotNull ExistingWorkPolicy existingWorkPolicy) {
        Intrinsics.checkNotNullParameter(existingWorkPolicy, "existingWorkPolicy");
        WorkRequest build = ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(PerseusWorker.class).setInitialDelay(j11, TimeUnit.SECONDS)).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder(PerseusWorker::c…NDS)\n            .build()");
        WorkContinuation beginUniqueWork = this.workManager.beginUniqueWork(PerseusWorker.WORKER_NAME, existingWorkPolicy, (OneTimeWorkRequest) build);
        Intrinsics.checkNotNullExpressionValue(beginUniqueWork, "workManager\n            …orkPolicy, workerRequest)");
        beginUniqueWork.enqueue();
    }
}
