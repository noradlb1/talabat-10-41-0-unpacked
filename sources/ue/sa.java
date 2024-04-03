package ue;

import android.view.View;
import com.facebook.login.widget.LoginButton;
import com.talabat.LoginScreen;

public final /* synthetic */ class sa implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoginScreen f57741b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LoginButton f57742c;

    public /* synthetic */ sa(LoginScreen loginScreen, LoginButton loginButton) {
        this.f57741b = loginScreen;
        this.f57742c = loginButton;
    }

    public final void onClick(View view) {
        this.f57741b.lambda$setUpFacebookLoginButtons$7(this.f57742c, view);
    }
}
