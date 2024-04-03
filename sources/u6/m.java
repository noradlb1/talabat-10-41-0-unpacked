package u6;

import com.facebook.bolts.Continuation;
import com.facebook.bolts.Task;
import com.facebook.bolts.TaskCompletionSource;
import java.util.concurrent.atomic.AtomicBoolean;

public final /* synthetic */ class m implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f34728a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f34729b;

    public /* synthetic */ m(AtomicBoolean atomicBoolean, TaskCompletionSource taskCompletionSource) {
        this.f34728a = atomicBoolean;
        this.f34729b = taskCompletionSource;
    }

    public final Object then(Task task) {
        return Task.Companion.m8944whenAny$lambda4(this.f34728a, this.f34729b, task);
    }
}
