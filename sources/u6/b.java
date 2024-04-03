package u6;

import com.facebook.bolts.CancellationToken;
import com.facebook.bolts.Continuation;
import com.facebook.bolts.Task;

public final /* synthetic */ class b implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CancellationToken f34700a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Continuation f34701b;

    public /* synthetic */ b(CancellationToken cancellationToken, Continuation continuation) {
        this.f34700a = cancellationToken;
        this.f34701b = continuation;
    }

    public final Object then(Task task) {
        return Task.m8936onSuccess$lambda13(this.f34700a, this.f34701b, task);
    }
}
