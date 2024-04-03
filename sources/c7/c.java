package c7;

import com.facebook.internal.FetchedAppSettings;
import com.facebook.login.widget.LoginButton;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoginButton f29368b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FetchedAppSettings f29369c;

    public /* synthetic */ c(LoginButton loginButton, FetchedAppSettings fetchedAppSettings) {
        this.f29368b = loginButton;
        this.f29369c = fetchedAppSettings;
    }

    public final void run() {
        LoginButton.m9005checkToolTipSettings$lambda3$lambda2(this.f29368b, this.f29369c);
    }
}
