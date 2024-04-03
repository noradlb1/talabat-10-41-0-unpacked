package zz;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.firebase.crashlytics.FlutterFirebaseCrashlyticsPlugin;

public final /* synthetic */ class m implements OnCompleteListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f24268b;

    public /* synthetic */ m(MethodChannel.Result result) {
        this.f24268b = result;
    }

    public final void onComplete(Task task) {
        FlutterFirebaseCrashlyticsPlugin.lambda$onMethodCall$10(this.f24268b, task);
    }
}
