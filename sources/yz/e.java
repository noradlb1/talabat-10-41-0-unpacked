package yz;

import com.google.android.gms.tasks.TaskCompletionSource;
import io.flutter.plugins.firebase.core.FlutterFirebaseCorePlugin;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FlutterFirebaseCorePlugin f24225b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f24226c;

    public /* synthetic */ e(FlutterFirebaseCorePlugin flutterFirebaseCorePlugin, TaskCompletionSource taskCompletionSource) {
        this.f24225b = flutterFirebaseCorePlugin;
        this.f24226c = taskCompletionSource;
    }

    public final void run() {
        this.f24225b.lambda$initializeCore$3(this.f24226c);
    }
}
