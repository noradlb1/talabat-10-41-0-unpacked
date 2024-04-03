package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;

public interface SchedulerMultiWorkerSupport {

    public interface WorkerCallback {
        void onWorker(int i11, @NonNull Scheduler.Worker worker);
    }

    void createWorkers(int i11, @NonNull WorkerCallback workerCallback);
}
