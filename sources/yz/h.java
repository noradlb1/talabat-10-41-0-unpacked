package yz;

import com.google.android.gms.tasks.TaskCompletionSource;
import io.flutter.plugins.firebase.core.FlutterFirebaseCorePlugin;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f24234b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Boolean f24235c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f24236d;

    public /* synthetic */ h(String str, Boolean bool, TaskCompletionSource taskCompletionSource) {
        this.f24234b = str;
        this.f24235c = bool;
        this.f24236d = taskCompletionSource;
    }

    public final void run() {
        FlutterFirebaseCorePlugin.lambda$setAutomaticResourceManagementEnabled$6(this.f24234b, this.f24235c, this.f24236d);
    }
}
