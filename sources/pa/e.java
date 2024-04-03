package pa;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.concurrent.Callable;

public final /* synthetic */ class e implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FirebaseRemoteConfig f50698b;

    public /* synthetic */ e(FirebaseRemoteConfig firebaseRemoteConfig) {
        this.f50698b = firebaseRemoteConfig;
    }

    public final Object call() {
        return this.f50698b.getInfo();
    }
}
