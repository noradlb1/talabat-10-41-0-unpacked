package zz;

import io.flutter.plugins.firebase.crashlytics.FlutterFirebaseCrashlyticsPlugin;
import java.util.Map;
import java.util.concurrent.Callable;

public final /* synthetic */ class k implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map f24266b;

    public /* synthetic */ k(Map map) {
        this.f24266b = map;
    }

    public final Object call() {
        return FlutterFirebaseCrashlyticsPlugin.lambda$log$5(this.f24266b);
    }
}
