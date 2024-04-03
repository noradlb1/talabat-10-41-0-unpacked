package zz;

import io.flutter.plugins.firebase.crashlytics.FlutterFirebaseCrashlyticsPlugin;
import java.util.concurrent.Callable;

public final /* synthetic */ class a implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FlutterFirebaseCrashlyticsPlugin f24258b;

    public /* synthetic */ a(FlutterFirebaseCrashlyticsPlugin flutterFirebaseCrashlyticsPlugin) {
        this.f24258b = flutterFirebaseCrashlyticsPlugin;
    }

    public final Object call() {
        return this.f24258b.lambda$didCrashOnPreviousExecution$3();
    }
}
