package b7;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.login.LoginManager;

public final /* synthetic */ class n implements CallbackManagerImpl.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LoginManager f29345a;

    public /* synthetic */ n(LoginManager loginManager) {
        this.f29345a = loginManager;
    }

    public final boolean onActivityResult(int i11, Intent intent) {
        return LoginManager.m9000startLogin$lambda1(this.f29345a, i11, intent);
    }
}
