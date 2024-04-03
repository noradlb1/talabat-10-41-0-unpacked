package yz;

import com.google.android.gms.tasks.TaskCompletionSource;
import io.flutter.plugins.firebase.core.FlutterFirebaseCorePlugin;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FlutterFirebaseCorePlugin f24220b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f24221c;

    public /* synthetic */ c(FlutterFirebaseCorePlugin flutterFirebaseCorePlugin, TaskCompletionSource taskCompletionSource) {
        this.f24220b = flutterFirebaseCorePlugin;
        this.f24221c = taskCompletionSource;
    }

    public final void run() {
        this.f24220b.lambda$optionsFromResource$4(this.f24221c);
    }
}
