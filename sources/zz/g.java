package zz;

import io.flutter.plugins.firebase.crashlytics.FlutterFirebaseCrashlyticsPlugin;
import java.util.Map;
import java.util.concurrent.Callable;

public final /* synthetic */ class g implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FlutterFirebaseCrashlyticsPlugin f24262b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Map f24263c;

    public /* synthetic */ g(FlutterFirebaseCrashlyticsPlugin flutterFirebaseCrashlyticsPlugin, Map map) {
        this.f24262b = flutterFirebaseCrashlyticsPlugin;
        this.f24263c = map;
    }

    public final Object call() {
        return this.f24262b.lambda$setCrashlyticsCollectionEnabled$7(this.f24263c);
    }
}
