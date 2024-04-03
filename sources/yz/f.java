package yz;

import com.google.android.gms.tasks.TaskCompletionSource;
import io.flutter.plugins.firebase.core.FlutterFirebaseCorePlugin;
import io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FlutterFirebaseCorePlugin f24227b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidFirebaseCore.PigeonFirebaseOptions f24228c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f24229d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f24230e;

    public /* synthetic */ f(FlutterFirebaseCorePlugin flutterFirebaseCorePlugin, GeneratedAndroidFirebaseCore.PigeonFirebaseOptions pigeonFirebaseOptions, String str, TaskCompletionSource taskCompletionSource) {
        this.f24227b = flutterFirebaseCorePlugin;
        this.f24228c = pigeonFirebaseOptions;
        this.f24229d = str;
        this.f24230e = taskCompletionSource;
    }

    public final void run() {
        this.f24227b.lambda$initializeApp$2(this.f24228c, this.f24229d, this.f24230e);
    }
}
