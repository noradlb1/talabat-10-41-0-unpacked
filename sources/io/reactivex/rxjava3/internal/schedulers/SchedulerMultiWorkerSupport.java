package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Scheduler;

public interface SchedulerMultiWorkerSupport {

    public interface WorkerCallback {
        void onWorker(int i11, @NonNull Scheduler.Worker worker);
    }

    void createWorkers(int i11, @NonNull WorkerCallback workerCallback);
}
