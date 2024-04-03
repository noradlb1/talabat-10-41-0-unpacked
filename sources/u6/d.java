package u6;

import com.facebook.bolts.CancellationToken;
import com.facebook.bolts.Continuation;
import com.facebook.bolts.Task;
import com.facebook.bolts.TaskCompletionSource;
import java.util.concurrent.Executor;

public final /* synthetic */ class d implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f34706a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Continuation f34707b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Executor f34708c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CancellationToken f34709d;

    public /* synthetic */ d(TaskCompletionSource taskCompletionSource, Continuation continuation, Executor executor, CancellationToken cancellationToken) {
        this.f34706a = taskCompletionSource;
        this.f34707b = continuation;
        this.f34708c = executor;
        this.f34709d = cancellationToken;
    }

    public final Object then(Task task) {
        return Task.m8934continueWithTask$lambda12$lambda11(this.f34706a, this.f34707b, this.f34708c, this.f34709d, task);
    }
}
