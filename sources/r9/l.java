package r9;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.internal.common.Utils;

public final /* synthetic */ class l implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f50766a;

    public /* synthetic */ l(TaskCompletionSource taskCompletionSource) {
        this.f50766a = taskCompletionSource;
    }

    public final Object then(Task task) {
        return Utils.lambda$callTask$2(this.f50766a, task);
    }
}
