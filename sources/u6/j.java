package u6;

import com.facebook.bolts.CancellationToken;
import com.facebook.bolts.Continuation;
import com.facebook.bolts.Task;
import com.facebook.bolts.TaskCompletionSource;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CancellationToken f34721b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f34722c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Continuation f34723d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Task f34724e;

    public /* synthetic */ j(CancellationToken cancellationToken, TaskCompletionSource taskCompletionSource, Continuation continuation, Task task) {
        this.f34721b = cancellationToken;
        this.f34722c = taskCompletionSource;
        this.f34723d = continuation;
        this.f34724e = task;
    }

    public final void run() {
        Task.Companion.m8939completeAfterTask$lambda7(this.f34721b, this.f34722c, this.f34723d, this.f34724e);
    }
}
