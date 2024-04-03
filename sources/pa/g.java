package pa;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import java.util.concurrent.Callable;

public final /* synthetic */ class g implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FirebaseRemoteConfig f50700b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FirebaseRemoteConfigSettings f50701c;

    public /* synthetic */ g(FirebaseRemoteConfig firebaseRemoteConfig, FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        this.f50700b = firebaseRemoteConfig;
        this.f50701c = firebaseRemoteConfigSettings;
    }

    public final Object call() {
        return this.f50700b.lambda$setConfigSettingsAsync$5(this.f50701c);
    }
}
