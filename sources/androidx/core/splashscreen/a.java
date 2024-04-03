package androidx.core.splashscreen;

import androidx.core.splashscreen.SplashScreen;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SplashScreenViewProvider f11414b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SplashScreen.OnExitAnimationListener f11415c;

    public /* synthetic */ a(SplashScreenViewProvider splashScreenViewProvider, SplashScreen.OnExitAnimationListener onExitAnimationListener) {
        this.f11414b = splashScreenViewProvider;
        this.f11415c = onExitAnimationListener;
    }

    public final void run() {
        SplashScreen.Impl.m5738dispatchOnExitAnimation$lambda3(this.f11414b, this.f11415c);
    }
}
