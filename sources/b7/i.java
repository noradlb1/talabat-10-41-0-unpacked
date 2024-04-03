package b7;

import com.facebook.login.LoginClient;
import com.facebook.login.LoginFragment;

public final /* synthetic */ class i implements LoginClient.OnCompletedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LoginFragment f29335a;

    public /* synthetic */ i(LoginFragment loginFragment) {
        this.f29335a = loginFragment;
    }

    public final void onCompleted(LoginClient.Result result) {
        LoginFragment.m8995onCreate$lambda0(this.f29335a, result);
    }
}
