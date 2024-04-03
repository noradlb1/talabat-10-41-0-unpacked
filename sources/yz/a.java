package yz;

import com.google.android.gms.tasks.TaskCompletionSource;
import io.flutter.plugins.firebase.core.FlutterFirebaseCorePlugin;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f24217b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f24218c;

    public /* synthetic */ a(String str, TaskCompletionSource taskCompletionSource) {
        this.f24217b = str;
        this.f24218c = taskCompletionSource;
    }

    public final void run() {
        FlutterFirebaseCorePlugin.lambda$delete$7(this.f24217b, this.f24218c);
    }
}
