package pa;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public final /* synthetic */ class j implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseRemoteConfig f50704a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Task f50705b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Task f50706c;

    public /* synthetic */ j(FirebaseRemoteConfig firebaseRemoteConfig, Task task, Task task2) {
        this.f50704a = firebaseRemoteConfig;
        this.f50705b = task;
        this.f50706c = task2;
    }

    public final Object then(Task task) {
        return this.f50704a.lambda$activate$2(this.f50705b, this.f50706c, task);
    }
}
