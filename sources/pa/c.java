package pa;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.concurrent.Callable;

public final /* synthetic */ class c implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FirebaseRemoteConfig f50697b;

    public /* synthetic */ c(FirebaseRemoteConfig firebaseRemoteConfig) {
        this.f50697b = firebaseRemoteConfig;
    }

    public final Object call() {
        return this.f50697b.lambda$reset$6();
    }
}
