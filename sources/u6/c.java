package u6;

import com.facebook.bolts.CancellationToken;
import com.facebook.bolts.Continuation;
import com.facebook.bolts.Task;
import com.facebook.bolts.TaskCompletionSource;
import java.util.concurrent.Executor;

public final /* synthetic */ class c implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f34702a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Continuation f34703b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Executor f34704c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CancellationToken f34705d;

    public /* synthetic */ c(TaskCompletionSource taskCompletionSource, Continuation continuation, Executor executor, CancellationToken cancellationToken) {
        this.f34702a = taskCompletionSource;
        this.f34703b = continuation;
        this.f34704c = executor;
        this.f34705d = cancellationToken;
    }

    public final Object then(Task task) {
        return Task.m8933continueWith$lambda10$lambda9(this.f34702a, this.f34703b, this.f34704c, this.f34705d, task);
    }
}
