package yz;

import com.google.android.gms.tasks.TaskCompletionSource;
import io.flutter.plugins.firebase.core.FlutterFirebasePluginRegistry;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f24237b;

    public /* synthetic */ i(TaskCompletionSource taskCompletionSource) {
        this.f24237b = taskCompletionSource;
    }

    public final void run() {
        FlutterFirebasePluginRegistry.lambda$didReinitializeFirebaseCore$1(this.f24237b);
    }
}
