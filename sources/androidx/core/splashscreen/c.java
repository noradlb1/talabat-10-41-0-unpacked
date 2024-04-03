package androidx.core.splashscreen;

import android.window.SplashScreen;
import android.window.SplashScreenView;
import androidx.core.splashscreen.SplashScreen;

public final /* synthetic */ class c implements SplashScreen.OnExitAnimationListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SplashScreen.Impl31 f11416a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SplashScreen.OnExitAnimationListener f11417b;

    public /* synthetic */ c(SplashScreen.Impl31 impl31, SplashScreen.OnExitAnimationListener onExitAnimationListener) {
        this.f11416a = impl31;
        this.f11417b = onExitAnimationListener;
    }

    public final void onSplashScreenExit(SplashScreenView splashScreenView) {
        SplashScreen.Impl31.m5740setOnExitAnimationListener$lambda0(this.f11416a, this.f11417b, splashScreenView);
    }
}
