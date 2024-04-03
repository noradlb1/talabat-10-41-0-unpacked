package a00;

import io.flutter.plugins.googlesignin.BackgroundTaskRunner;
import io.flutter.plugins.googlesignin.GoogleSignInPlugin;
import io.flutter.plugins.googlesignin.Messages;
import java.util.concurrent.Future;

public final /* synthetic */ class h implements BackgroundTaskRunner.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GoogleSignInPlugin.Delegate f11646a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Messages.Result f11647b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Boolean f11648c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f11649d;

    public /* synthetic */ h(GoogleSignInPlugin.Delegate delegate, Messages.Result result, Boolean bool, String str) {
        this.f11646a = delegate;
        this.f11647b = result;
        this.f11648c = bool;
        this.f11649d = str;
    }

    public final void run(Future future) {
        this.f11646a.lambda$getAccessToken$5(this.f11647b, this.f11648c, this.f11649d, future);
    }
}
