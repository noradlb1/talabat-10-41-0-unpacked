package zz;

import io.flutter.plugins.firebase.crashlytics.FlutterFirebaseCrashlyticsPlugin;
import java.util.Map;
import java.util.concurrent.Callable;

public final /* synthetic */ class l implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map f24267b;

    public /* synthetic */ l(Map map) {
        this.f24267b = map;
    }

    public final Object call() {
        return FlutterFirebaseCrashlyticsPlugin.lambda$setCustomKey$9(this.f24267b);
    }
}
