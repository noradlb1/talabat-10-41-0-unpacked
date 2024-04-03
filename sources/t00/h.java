package t00;

import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.rx2.SchedulerCoroutineDispatcher;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation f28203b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SchedulerCoroutineDispatcher f28204c;

    public /* synthetic */ h(CancellableContinuation cancellableContinuation, SchedulerCoroutineDispatcher schedulerCoroutineDispatcher) {
        this.f28203b = cancellableContinuation;
        this.f28204c = schedulerCoroutineDispatcher;
    }

    public final void run() {
        SchedulerCoroutineDispatcher.m7863scheduleResumeAfterDelay$lambda1(this.f28203b, this.f28204c);
    }
}
