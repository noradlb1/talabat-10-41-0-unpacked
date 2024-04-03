package u6;

import com.facebook.bolts.CancellationToken;
import com.facebook.bolts.Continuation;
import com.facebook.bolts.Task;
import com.facebook.bolts.TaskCompletionSource;

public final /* synthetic */ class n implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CancellationToken f34730a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f34731b;

    public /* synthetic */ n(CancellationToken cancellationToken, TaskCompletionSource taskCompletionSource) {
        this.f34730a = cancellationToken;
        this.f34731b = taskCompletionSource;
    }

    public final Object then(Task task) {
        return Task.Companion.m8940completeAfterTask$lambda7$lambda6(this.f34730a, this.f34731b, task);
    }
}
