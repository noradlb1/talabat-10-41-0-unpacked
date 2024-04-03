package pa;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public final /* synthetic */ class f implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Task f50699a;

    public /* synthetic */ f(Task task) {
        this.f50699a = task;
    }

    public final Object then(Task task) {
        return FirebaseRemoteConfig.lambda$ensureInitialized$0(this.f50699a, task);
    }
}
