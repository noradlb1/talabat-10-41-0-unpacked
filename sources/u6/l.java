package u6;

import com.facebook.bolts.Task;
import com.facebook.bolts.TaskCompletionSource;
import java.util.concurrent.ScheduledFuture;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ScheduledFuture f34726b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f34727c;

    public /* synthetic */ l(ScheduledFuture scheduledFuture, TaskCompletionSource taskCompletionSource) {
        this.f34726b = scheduledFuture;
        this.f34727c = taskCompletionSource;
    }

    public final void run() {
        Task.Companion.m8943delay$lambda1(this.f34726b, this.f34727c);
    }
}
