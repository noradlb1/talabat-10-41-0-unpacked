package a00;

import io.flutter.plugins.googlesignin.BackgroundTaskRunner;
import io.flutter.plugins.googlesignin.GoogleSignInPlugin;
import io.flutter.plugins.googlesignin.Messages;
import java.util.concurrent.Future;

public final /* synthetic */ class f implements BackgroundTaskRunner.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Messages.Result f11643a;

    public /* synthetic */ f(Messages.Result result) {
        this.f11643a = result;
    }

    public final void run(Future future) {
        GoogleSignInPlugin.Delegate.lambda$clearAuthCache$3(this.f11643a, future);
    }
}
