package b7;

import android.content.Intent;
import com.facebook.FacebookCallback;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.login.LoginManager;

public final /* synthetic */ class l implements CallbackManagerImpl.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LoginManager f29339a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FacebookCallback f29340b;

    public /* synthetic */ l(LoginManager loginManager, FacebookCallback facebookCallback) {
        this.f29339a = loginManager;
        this.f29340b = facebookCallback;
    }

    public final boolean onActivityResult(int i11, Intent intent) {
        return LoginManager.m8998registerCallback$lambda0(this.f29339a, this.f29340b, i11, intent);
    }
}
