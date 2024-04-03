package yz;

import com.google.android.gms.tasks.TaskCompletionSource;
import io.flutter.plugins.firebase.core.FlutterFirebaseCorePlugin;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f24231b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Boolean f24232c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f24233d;

    public /* synthetic */ g(String str, Boolean bool, TaskCompletionSource taskCompletionSource) {
        this.f24231b = str;
        this.f24232c = bool;
        this.f24233d = taskCompletionSource;
    }

    public final void run() {
        FlutterFirebaseCorePlugin.lambda$setAutomaticDataCollectionEnabled$5(this.f24231b, this.f24232c, this.f24233d);
    }
}
