package a00;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import io.flutter.plugins.googlesignin.GoogleSignInPlugin;

public final /* synthetic */ class i implements OnCompleteListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GoogleSignInPlugin.Delegate f11650b;

    public /* synthetic */ i(GoogleSignInPlugin.Delegate delegate) {
        this.f11650b = delegate;
    }

    public final void onComplete(Task task) {
        this.f11650b.onSignInResult(task);
    }
}
