package u6;

import com.facebook.bolts.Continuation;
import com.facebook.bolts.Task;
import com.facebook.bolts.TaskCompletionSource;
import java.util.concurrent.atomic.AtomicBoolean;

public final /* synthetic */ class g implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f34712a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f34713b;

    public /* synthetic */ g(AtomicBoolean atomicBoolean, TaskCompletionSource taskCompletionSource) {
        this.f34712a = atomicBoolean;
        this.f34713b = taskCompletionSource;
    }

    public final Object then(Task task) {
        return Task.Companion.m8945whenAnyResult$lambda3(this.f34712a, this.f34713b, task);
    }
}
