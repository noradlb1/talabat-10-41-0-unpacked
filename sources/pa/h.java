package pa;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public final /* synthetic */ class h implements SuccessContinuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseRemoteConfig f50702a;

    public /* synthetic */ h(FirebaseRemoteConfig firebaseRemoteConfig) {
        this.f50702a = firebaseRemoteConfig;
    }

    public final Task then(Object obj) {
        return this.f50702a.lambda$fetchAndActivate$1((Void) obj);
    }
}
