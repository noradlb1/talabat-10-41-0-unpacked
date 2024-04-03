package yz;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import io.flutter.plugins.firebase.core.FlutterFirebaseCorePlugin;
import io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore;

public final /* synthetic */ class b implements OnCompleteListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidFirebaseCore.Result f24219b;

    public /* synthetic */ b(GeneratedAndroidFirebaseCore.Result result) {
        this.f24219b = result;
    }

    public final void onComplete(Task task) {
        FlutterFirebaseCorePlugin.lambda$listenToResponse$1(this.f24219b, task);
    }
}
