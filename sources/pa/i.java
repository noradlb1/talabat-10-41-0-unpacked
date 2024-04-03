package pa;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public final /* synthetic */ class i implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseRemoteConfig f50703a;

    public /* synthetic */ i(FirebaseRemoteConfig firebaseRemoteConfig) {
        this.f50703a = firebaseRemoteConfig;
    }

    public final Object then(Task task) {
        return Boolean.valueOf(this.f50703a.processActivatePutTask(task));
    }
}
