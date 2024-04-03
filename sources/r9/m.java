package r9;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.internal.common.Utils;

public final /* synthetic */ class m implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f50767a;

    public /* synthetic */ m(TaskCompletionSource taskCompletionSource) {
        this.f50767a = taskCompletionSource;
    }

    public final Object then(Task task) {
        return Utils.lambda$race$0(this.f50767a, task);
    }
}
