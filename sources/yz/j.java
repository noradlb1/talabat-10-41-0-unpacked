package yz;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseApp;
import io.flutter.plugins.firebase.core.FlutterFirebasePluginRegistry;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FirebaseApp f24238b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f24239c;

    public /* synthetic */ j(FirebaseApp firebaseApp, TaskCompletionSource taskCompletionSource) {
        this.f24238b = firebaseApp;
        this.f24239c = taskCompletionSource;
    }

    public final void run() {
        FlutterFirebasePluginRegistry.lambda$getPluginConstantsForFirebaseApp$0(this.f24238b, this.f24239c);
    }
}
