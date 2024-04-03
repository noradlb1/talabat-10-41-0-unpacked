package a00;

import io.flutter.plugins.googlesignin.GoogleSignInPlugin;
import java.util.concurrent.Callable;

public final /* synthetic */ class e implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GoogleSignInPlugin.Delegate f11641b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f11642c;

    public /* synthetic */ e(GoogleSignInPlugin.Delegate delegate, String str) {
        this.f11641b = delegate;
        this.f11642c = str;
    }

    public final Object call() {
        return this.f11641b.lambda$clearAuthCache$2(this.f11642c);
    }
}
