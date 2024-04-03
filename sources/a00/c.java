package a00;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import io.flutter.plugins.googlesignin.GoogleSignInPlugin;

public final /* synthetic */ class c implements OnCompleteListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GoogleSignInPlugin.Delegate f11639b;

    public /* synthetic */ c(GoogleSignInPlugin.Delegate delegate) {
        this.f11639b = delegate;
    }

    public final void onComplete(Task task) {
        this.f11639b.lambda$signOut$0(task);
    }
}
