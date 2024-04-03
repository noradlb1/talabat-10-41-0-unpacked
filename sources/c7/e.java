package c7;

import com.facebook.login.widget.LoginButton;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f29370b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LoginButton f29371c;

    public /* synthetic */ e(String str, LoginButton loginButton) {
        this.f29370b = str;
        this.f29371c = loginButton;
    }

    public final void run() {
        LoginButton.m9004checkToolTipSettings$lambda3(this.f29370b, this.f29371c);
    }
}
