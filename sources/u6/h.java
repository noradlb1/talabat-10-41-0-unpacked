package u6;

import com.facebook.bolts.CancellationToken;
import com.facebook.bolts.Task;
import com.facebook.bolts.TaskCompletionSource;
import java.util.concurrent.Callable;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CancellationToken f34714b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f34715c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Callable f34716d;

    public /* synthetic */ h(CancellationToken cancellationToken, TaskCompletionSource taskCompletionSource, Callable callable) {
        this.f34714b = cancellationToken;
        this.f34715c = taskCompletionSource;
        this.f34716d = callable;
    }

    public final void run() {
        Task.Companion.m8938call$lambda2(this.f34714b, this.f34715c, this.f34716d);
    }
}
