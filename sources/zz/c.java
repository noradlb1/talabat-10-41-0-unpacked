package zz;

import io.flutter.plugins.firebase.crashlytics.FlutterFirebaseCrashlyticsPlugin;
import java.util.concurrent.Callable;

public final /* synthetic */ class c implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FlutterFirebaseCrashlyticsPlugin f24259b;

    public /* synthetic */ c(FlutterFirebaseCrashlyticsPlugin flutterFirebaseCrashlyticsPlugin) {
        this.f24259b = flutterFirebaseCrashlyticsPlugin;
    }

    public final Object call() {
        return this.f24259b.lambda$checkForUnsentReports$0();
    }
}
