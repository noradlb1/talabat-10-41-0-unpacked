package c7;

import android.content.DialogInterface;
import com.facebook.login.LoginManager;
import com.facebook.login.widget.LoginButton;

public final /* synthetic */ class f implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoginManager f29372b;

    public /* synthetic */ f(LoginManager loginManager) {
        this.f29372b = loginManager;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        LoginButton.LoginClickListener.m9007performLogout$lambda2(this.f29372b, dialogInterface, i11);
    }
}
