package a00;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import io.flutter.plugins.googlesignin.GoogleSignInPlugin;

public final /* synthetic */ class d implements OnCompleteListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GoogleSignInPlugin.Delegate f11640b;

    public /* synthetic */ d(GoogleSignInPlugin.Delegate delegate) {
        this.f11640b = delegate;
    }

    public final void onComplete(Task task) {
        this.f11640b.lambda$disconnect$1(task);
    }
}
