package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import java.util.concurrent.ThreadFactory;

public final class NewThreadScheduler extends Scheduler {
    private static final String KEY_NEWTHREAD_PRIORITY = "rx2.newthread-priority";
    private static final RxThreadFactory THREAD_FACTORY = new RxThreadFactory(THREAD_NAME_PREFIX, Math.max(1, Math.min(10, Integer.getInteger(KEY_NEWTHREAD_PRIORITY, 5).intValue())));
    private static final String THREAD_NAME_PREFIX = "RxNewThreadScheduler";

    /* renamed from: d  reason: collision with root package name */
    public final ThreadFactory f18511d;

    public NewThreadScheduler() {
        this(THREAD_FACTORY);
    }

    @NonNull
    public Scheduler.Worker createWorker() {
        return new NewThreadWorker(this.f18511d);
    }

    public NewThreadScheduler(ThreadFactory threadFactory) {
        this.f18511d = threadFactory;
    }
}
