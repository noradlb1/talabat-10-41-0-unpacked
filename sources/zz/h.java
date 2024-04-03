package zz;

import io.flutter.plugins.firebase.crashlytics.FlutterFirebaseCrashlyticsPlugin;
import java.util.Map;
import java.util.concurrent.Callable;

public final /* synthetic */ class h implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map f24264b;

    public /* synthetic */ h(Map map) {
        this.f24264b = map;
    }

    public final Object call() {
        return FlutterFirebaseCrashlyticsPlugin.lambda$setUserIdentifier$8(this.f24264b);
    }
}
