package u6;

import com.facebook.bolts.CancellationToken;
import com.facebook.bolts.Continuation;
import com.facebook.bolts.Task;
import com.facebook.bolts.TaskCompletionSource;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CancellationToken f34717b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f34718c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Continuation f34719d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Task f34720e;

    public /* synthetic */ i(CancellationToken cancellationToken, TaskCompletionSource taskCompletionSource, Continuation continuation, Task task) {
        this.f34717b = cancellationToken;
        this.f34718c = taskCompletionSource;
        this.f34719d = continuation;
        this.f34720e = task;
    }

    public final void run() {
        Task.Companion.m8941completeImmediately$lambda5(this.f34717b, this.f34718c, this.f34719d, this.f34720e);
    }
}
