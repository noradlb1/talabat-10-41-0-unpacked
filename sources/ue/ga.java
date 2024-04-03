package ue;

import android.view.View;
import com.talabat.LoginScreen;
import library.talabat.mvp.login.LoginInteractor;

public final /* synthetic */ class ga implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoginScreen f57543b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LoginInteractor f57544c;

    public /* synthetic */ ga(LoginScreen loginScreen, LoginInteractor loginInteractor) {
        this.f57543b = loginScreen;
        this.f57544c = loginInteractor;
    }

    public final void onClick(View view) {
        this.f57543b.lambda$onCreate$4(this.f57544c, view);
    }
}
