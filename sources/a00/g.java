package a00;

import io.flutter.plugins.googlesignin.GoogleSignInPlugin;
import java.util.concurrent.Callable;

public final /* synthetic */ class g implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GoogleSignInPlugin.Delegate f11644b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f11645c;

    public /* synthetic */ g(GoogleSignInPlugin.Delegate delegate, String str) {
        this.f11644b = delegate;
        this.f11645c = str;
    }

    public final Object call() {
        return this.f11644b.lambda$getAccessToken$4(this.f11645c);
    }
}
