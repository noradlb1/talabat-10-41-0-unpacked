package r9;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.internal.common.Utils;

public final /* synthetic */ class o implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f50769a;

    public /* synthetic */ o(TaskCompletionSource taskCompletionSource) {
        this.f50769a = taskCompletionSource;
    }

    public final Object then(Task task) {
        return Utils.lambda$race$1(this.f50769a, task);
    }
}
