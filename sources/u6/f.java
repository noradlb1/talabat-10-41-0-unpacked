package u6;

import com.facebook.bolts.CancellationToken;
import com.facebook.bolts.Continuation;
import com.facebook.bolts.Task;

public final /* synthetic */ class f implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CancellationToken f34710a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Continuation f34711b;

    public /* synthetic */ f(CancellationToken cancellationToken, Continuation continuation) {
        this.f34710a = cancellationToken;
        this.f34711b = continuation;
    }

    public final Object then(Task task) {
        return Task.m8937onSuccessTask$lambda14(this.f34710a, this.f34711b, task);
    }
}
