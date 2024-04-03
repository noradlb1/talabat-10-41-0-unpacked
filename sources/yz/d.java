package yz;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseApp;
import io.flutter.plugins.firebase.core.FlutterFirebaseCorePlugin;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FlutterFirebaseCorePlugin f24222b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FirebaseApp f24223c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f24224d;

    public /* synthetic */ d(FlutterFirebaseCorePlugin flutterFirebaseCorePlugin, FirebaseApp firebaseApp, TaskCompletionSource taskCompletionSource) {
        this.f24222b = flutterFirebaseCorePlugin;
        this.f24223c = firebaseApp;
        this.f24224d = taskCompletionSource;
    }

    public final void run() {
        this.f24222b.lambda$firebaseAppToMap$0(this.f24223c, this.f24224d);
    }
}
