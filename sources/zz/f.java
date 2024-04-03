package zz;

import io.flutter.plugins.firebase.crashlytics.FlutterFirebaseCrashlyticsPlugin;
import java.util.Map;
import java.util.concurrent.Callable;

public final /* synthetic */ class f implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FlutterFirebaseCrashlyticsPlugin f24260b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Map f24261c;

    public /* synthetic */ f(FlutterFirebaseCrashlyticsPlugin flutterFirebaseCrashlyticsPlugin, Map map) {
        this.f24260b = flutterFirebaseCrashlyticsPlugin;
        this.f24261c = map;
    }

    public final Object call() {
        return this.f24260b.lambda$recordError$4(this.f24261c);
    }
}
